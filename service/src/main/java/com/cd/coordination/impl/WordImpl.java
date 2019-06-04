package com.cd.coordination.impl;

import com.cd.coordination.TrackService;
import com.cd.coordination.WordService;
import com.cd.coordination.dao.*;
import com.cd.coordination.entity.*;
import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.DocumentEntry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("wordService")
public class WordImpl implements WordService {

    @Qualifier("userDao")
    @Autowired
    UserDao userDao;

    @Qualifier("cooperationDao")
    @Autowired
    CooperationDao cooperationDao;

    @Qualifier("teamDao")
    @Autowired
    TeamDao teamDao;

    @Qualifier("wordDao")
    @Autowired
    WordDao wordDao;

    @Qualifier("memberDao")
    @Autowired
    MemberDao memberDao;

    @Autowired
    TrackService trackService;

    public void cooperationExport(String student_id,HttpServletRequest request,HttpServletResponse response) {
        User stu = new User();
        stu.setStudent_id(student_id);
        String mark = userDao.userCheck(stu.getStudent_id()).getMark();
        Cooperation mem = new Cooperation();
        mem.setMark(mark);
        Member te = new Member();
        te.setMark(mark);
        List<Cooperation> test = new ArrayList<Cooperation>();
        test = cooperationDao.communicateFind(mem.getMark());
        Team team = teamDao.teamFind(te.getStudent_id(),te.getMark());
        Map<String, Object> map = new HashMap<String, Object>();
        List<Cooperation>list = new ArrayList<Cooperation>();
        for(int i = 0 ; i < test.size();i++) {
            Cooperation mem_2 = new Cooperation();
            mem_2.setAnnouncer(test.get(i).getAnnouncer());
            mem_2.setHeading(test.get(i).getHeading());
            mem_2.setReleasetime(test.get(i).getReleasetime());
            list.add(mem_2);
            map.put("enter","<br /><br />");
        }
        map.put("cooperationlist", list);
        String filename = team.getHeading().toString();
        String template = "cooperation.ftl";
        try {
            WordUtils.exportMillCertificateWord(request,response,map,filename,template);
        } catch (IOException e) {
            e.printStackTrace();
        }
        trackService.insertTrack(student_id,mark);
    }

    public JSONObject demandFind(String student_id) {
        JSONObject jsonObject  =  new JSONObject();
        User stu_1 = new User();
        stu_1.setStudent_id(student_id);
        String mark = userDao.userCheck(stu_1.getStudent_id()).getMark();
        Demand stu = new Demand();
        stu.setMark(mark);
        List stu_2 = new ArrayList<Demand>();
        stu_2 = wordDao.demandFind(stu.getMark());
        if(stu_2 != null) {
            jsonObject = new JSONObject("{result:true}");
            jsonObject.put("data", stu_2);
        }else {
            jsonObject = new JSONObject("{result:false}");
        }
        return  jsonObject;
    }

    public JSONObject demandWrite(String student_id, String date, String title) {
        JSONObject jsonObject  ;
        User stu_1 = new User();
        stu_1.setStudent_id(student_id);
        String mark = userDao.userCheck(stu_1.getStudent_id()).getMark();
        Demand stu = new Demand(mark,date,title);
        Integer isTrue = wordDao.demandInsert(stu.getTitle(),stu.getDate(),stu.getMark());
        if(isTrue != 0) {
            trackService.insertTrack(student_id,mark);
            jsonObject = new JSONObject("{result:true}");
        }else {
            jsonObject = new JSONObject("{result:false}");
        }
        return jsonObject;
    }

    public JSONObject demo(String student_id, String id, String level) {
        JSONObject jsonObject  =  new JSONObject();
        User stu = new User();
        stu.setStudent_id(student_id);
        String mark = userDao.userCheck(stu.getStudent_id()).getMark();
        Member mem = new Member();
        mem.setMark(mark);
        Team team = teamDao.teamFind(mem.getStudent_id(),mem.getMark());
        if(student_id.equals(team.getStudent_id()))
        {
            Demo demo = new Demo();
            demo.setId(id);
            Demo test = new Demo();
            test = wordDao.demoSelect(demo.getId());
            team.setData(test.getDate());
            team.setLevel(level);
            Integer Istrue = teamDao.teamRevice(team.getData(),team.getSchedule(),team.getLevel(),team.getMark());
            if(test != null && Istrue != 0) {
                trackService.insertTrack(student_id,mark);
                jsonObject = new JSONObject("{result:true}");
            }else {
                jsonObject = new JSONObject("{result:false}");
            }
        }else {
            jsonObject = new JSONObject("{result:false}");
        }
        return jsonObject;
    }

    public void exWord(String student_id,HttpServletRequest request,HttpServletResponse response) {
        User stu = new User();
        stu.setStudent_id(student_id);
        String mark = userDao.userCheck(stu.getStudent_id()).getMark();
        Member mem = new Member();
        mem.setMark(mark);
        Team team = teamDao.teamFind(mem.getStudent_id(),mem.getMark());
        try {
            //word内容
            String content=team.getData();
            byte b[] = content.getBytes("utf-8");  //这里是必须要设置编码的，不然导出中文就会乱码。
            ByteArrayInputStream bais = new ByteArrayInputStream(b);//将字节数组包装到流中
            /*
             * 关键地方
             * 生成word格式
             */
            POIFSFileSystem poifs = new POIFSFileSystem();
            DirectoryEntry directory = poifs.getRoot();
            DocumentEntry documentEntry = directory.createDocument("WordDocument", bais);
            //输出文件
            String fileName=team.getHeading().toString();
            request.setCharacterEncoding("UTF-8");
            response.setContentType("application/msword");//导出word格式
            response.addHeader("Content-Disposition", "attachment;filename=" +new String( (fileName + ".doc").getBytes(),"iso-8859-1"));

            OutputStream ostream = response.getOutputStream();
            poifs.writeFilesystem(ostream);
            bais.close();
            ostream.close();
        }catch(Exception e){
            ;
        }
        trackService.insertTrack(student_id,mark);
    }

    public JSONObject tablefind(String student_id) {
        JSONObject jsonObject  =  new JSONObject();
        User stu_1 = new User();
        stu_1.setStudent_id(student_id);
        String mark = userDao.userCheck(stu_1.getStudent_id()).getMark();
        Member mem = new Member();
        Team team  = new Team();
        mem.setMark(mark);
        mem.setStudent_id(student_id);
        team = teamDao.teamId(mem.getMark());
        if(team.getData() != null)
        {
            jsonObject.put("data", team.getData());
        }else {
            jsonObject = new JSONObject("{result:false}");
        }
        return jsonObject;
    }

    public JSONObject tableWrite(String student_id, String data) {
        JSONObject jsonObject  =  new JSONObject();
        User stu_1 = new User();
        stu_1.setStudent_id(student_id);
        String mark = userDao.userCheck(stu_1.getStudent_id()).getMark();
        Member mem = new Member();
        Team team  = new Team();
        mem.setMark(mark);
        team = teamDao.teamId(mem.getMark());
        team.setData(data);
        Integer Istrue = teamDao.teamRevice(team.getData(),team.getSchedule(),team.getLevel(),team.getMark());
        if(Istrue != 0) {
            trackService.insertTrack(student_id,mark);
            jsonObject = new JSONObject("{result:true}");
            jsonObject.put("data", team.getData());
        }else {
            jsonObject = new JSONObject("{result:false}");
        }
        return jsonObject;
    }

    public JSONObject templateSelect(String mark, String id) {
        JSONObject jsonObject  =  new JSONObject();
        Team team = new Team();
        team.setMark(mark);
        if(teamDao.teamId(team.getMark())!=null) {
            Team stu = teamDao.teamId(team.getMark());
            Demo demo = new Demo();
            demo.setId(id);
            Demo test = new Demo();
            test = wordDao.demoSelect(demo.getId());
            stu.setData(test.getDate());
            teamDao.teamRevice(stu.getData(),stu.getSchedule(),stu.getLevel(),stu.getMark());
            jsonObject.put("test", test.getDate());

        }else {
            jsonObject = new JSONObject("{result:false}");
        }
        return jsonObject;
    }

    public void testExport(String student_id,HttpServletRequest request,HttpServletResponse response) {
        User stu = new User();
        stu.setStudent_id(student_id);
        String mark = userDao.userCheck(stu.getStudent_id()).getMark();
        Member mem = new Member();
        mem.setMark(mark);
        Test te = new Test();
        te.setMark(mark);
        List<Test> test = new ArrayList<Test>();
        test =cooperationDao.testUnitFind(te.getMark());
        Team team = teamDao.teamFind(mem.getStudent_id(),mem.getMark());
        Map<String, Object> map = new HashMap<String, Object>();
        List<Test>list = new ArrayList<Test>();
        for(int i = 0 ; i < test.size();i++) {
            Test mem_2 = new Test();
            mem_2.setOperator(test.get(i).getOperator());
            mem_2.setFrequency(test.get(i).getFrequency());
            mem_2.setSubject(test.get(i).getSubject());
            mem_2.setField(test.get(i).getField());
            mem_2.setProcess(test.get(i).getProcess());
            mem_2.setTestprocess(test.get(i).getTestprocess());
            mem_2.setResult(test.get(i).getResult());
            mem_2.setConclusion(test.get(i).getConclusion());
            mem_2.setRemark(test.get(i).getRemark());
            mem_2.setReleasetime(test.get(i).getReleasetime());
            list.add(mem_2);
            map.put("enter","<br /><br />");
        }
        map.put("list", list);
        String filename = team.getHeading().toString();
        String template = "test.ftl";
        try {
            WordUtils.exportMillCertificateWord(request,response,map,filename,template);
        } catch (IOException e) {
            e.printStackTrace();
        }
        trackService.insertTrack(student_id,mark);
    }
}
