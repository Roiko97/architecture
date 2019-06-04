package com.cd.coordination.impl;


import com.cd.coordination.LevelService;
import com.cd.coordination.dao.*;
import com.cd.coordination.entity.*;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("levelService")
public class LevelServiceImpl implements LevelService {

    @Qualifier("userDao")
    @Autowired
    UserDao userDao;

    @Qualifier("teamDao")
    @Autowired
    TeamDao teamDao;

    @Qualifier("cooperationDao")
    @Autowired
    CooperationDao cooperationDao;

    @Qualifier("wordDao")
    @Autowired
    WordDao wordDao;

    @Qualifier("memberDao")
    @Autowired
    MemberDao memberDao;

    public JSONObject demandLevel(String student_id) {
        JSONObject jsonObject  =  new JSONObject();
        Team team = new Team();
        User stu = new User();
        stu.setStudent_id(student_id);
        String mark = userDao.userCheck(stu.getStudent_id()).getMark();
        if(mark!= null) {
            Member stu_1 = new Member();
            stu_1.setMark(mark);
            stu_1.setStudent_id(student_id);
            team = teamDao.teamFind(stu_1.getStudent_id(),stu_1.getMark());
            if(team.getLevel() != null) {
                String number = team.getLevel();
                int a = Integer.parseInt(number);
                List<Mission> mis = new ArrayList<Mission>();
                Mission mi = new Mission();
                jsonObject = new JSONObject();
                if(a == 1) {
                    for(int i = 1; i <= 3; i++) {
                        mi.setId(i);
                        mi = wordDao.missionId(mi.getId());
                        mis.add(mi);
                    }
                    mi.setId(6);
                    mi = wordDao.missionId(mi.getId());
                    mis.add(mi);
                    mi.setId(8);
                    mi = wordDao.missionId(mi.getId());
                    mis.add(mi);
                    jsonObject.put("Mission", mis);
                }
                if(a == 2) {
                    for(int i = 1; i <= 4; i++) {
                        mi.setId(i);
                        mi = wordDao.missionId(mi.getId());
                        mis.add(mi);
                    }
                    mi.setId(6);
                    mi = wordDao.missionId(mi.getId());
                    mis.add(mi);
                    mi.setId(8);
                    mi = wordDao.missionId(mi.getId());
                    mis.add(mi);
                    jsonObject.put("Mission", mis);
                }
                if(a == 3) {
                    for(int i = 1; i <= 8; i++) {
                        mi.setId(i);
                        mi = wordDao.missionId(mi.getId());
                        mis.add(mi);
                    }
                    jsonObject.put("Mission", mis);
                }
            }else {
                jsonObject = new JSONObject("{result:false}");
            }
        }else {
            jsonObject = new JSONObject("{result:false}");
        }
        return jsonObject;
    }

    public JSONObject intermediateLevel(String student_id) {
        JSONObject jsonObject  =  new JSONObject();
        User stu = new User();
        stu.setStudent_id(student_id);
        stu = userDao.userCheck(stu.getStudent_id());
        String mark = stu.getMark();
        Team stu_1 = new Team();
        stu_1.setMark(mark);
        stu_1 = teamDao.teamId(stu_1.getMark());
        int i = Integer.parseInt(stu_1.getLevel());
        List<Mission> finish = new ArrayList<Mission>();
        List<Mission> working = new ArrayList<Mission>();
        List<Mission> Nostart = new ArrayList<Mission>();
        if(i ==  1) {
            int endT = stu_1.getEndT();
            String startT = stu_1.getStartT();
            long day = getDays(startT);
            Test test = new Test();
            test.setMark(stu_1.getMark());
            List<Test> test_1 = new ArrayList<Test>();
            test_1 = cooperationDao.testUnitFind(test.getMark());
            Mission id = new Mission();
            Mission mi = new Mission();

            //测试里程碑
            if(day > endT && test_1.size() >= 3) {
                mi.setId(3);
                id = wordDao.missionId(mi.getId());
                finish.add(id);
            }else if(test_1.size() == 0){
                mi.setId(3);
                id = wordDao.missionId(mi.getId());
                Nostart.add(id);
            }else {
                mi.setId(3);
                id = wordDao.missionId(mi.getId());
                working.add(id);
            }
            //查看测试用例
            if(day < endT) {
                mi.setId(6);
                id = wordDao.missionId(mi.getId());
                working.add(id);
            }else {
                mi.setId(6);
                id = wordDao.missionId(mi.getId());
                finish.add(id);
            }
            Demand demand = new Demand();
            demand.setMark(stu_1.getMark());
            List<Demand> deman = new ArrayList<Demand>();
            deman = wordDao.demandFind(demand.getMark());

            //需求分析里程碑
            if(stu_1.getData() != null && deman.size() > 3 && day > endT) {
                mi.setId(2);
                id = wordDao.missionId(mi.getId());
                finish.add(id);
            }else if(deman.size() == 0){
                mi.setId(2);
                id = wordDao.missionId(mi.getId());
                Nostart.add(id);
            }else {
                mi.setId(2);
                id = wordDao.missionId(mi.getId());
                working.add(id);
            }
            Member mem = new Member();
            mem.setMark(stu_1.getMark());
            List<Member> mem_1 = new ArrayList<Member>();
            mem_1 = memberDao.memberFind(mem.getMark());
            //人员分配里程碑
            if(endT < day) {
                mi.setId(1);
                id = wordDao.missionId(mi.getId());
                finish.add(id);
            }else {
                mi.setId(1);
                id = wordDao.missionId(mi.getId());
                working.add(id);
            }
            //文档导出
            if(day < endT) {
                mi.setId(8);
                id = wordDao.missionId(mi.getId());
                working.add(id);
            }else {
                mi.setId(8);
                id = wordDao.missionId(mi.getId());
                finish.add(id);
            }
            jsonObject.put("finish", finish);
            jsonObject.put("working", working);
            jsonObject.put("Nostart", Nostart);
        }else {
            jsonObject = new JSONObject("{result:false}");
        }
        return jsonObject;
    }

    //后台不控制跳转
    public JSONObject missionLevel(String student_id)  throws  Exception{
        JSONObject jsonObject  =  new JSONObject();
        User stu = new User();
        stu.setStudent_id(student_id);
        stu = userDao.userCheck(stu.getStudent_id());
        String mark = stu.getMark();
        if(mark != null) {
            Team team = new Team();
            team.setMark(mark);
            team = teamDao.teamId(team.getMark());
            if(team.getLevel() != null) {
                int i = Integer.parseInt(team.getLevel());
                if(i == 1) {
                    jsonObject = new JSONObject("{result:intermediateLevel}");
                    //response.sendRedirect("IntermediateLevelServlet");
                }else if(i == 2) {
                    jsonObject = new JSONObject("{result:primaryLevel}");
                    //response.sendRedirect("PrimaryLevelServlet");
                }else if(i == 3) {
                    jsonObject = new JSONObject("{result:seniorLevel}");
                    //response.sendRedirect("SeniorLevelServlet");
                }else {
                    jsonObject = new JSONObject("{result:false}");
                }
            }else {
                jsonObject = new JSONObject("{result:false}");
            }
        }else {
            jsonObject = new JSONObject("{result:false}");
        }
        return jsonObject;
    }

    public JSONObject primaryLevel(String student_id) {
        JSONObject jsonObject  =  new JSONObject();
        User stu = new User();
        stu.setStudent_id(student_id);
        stu = userDao.userCheck(stu.getStudent_id());
        String mark = stu.getMark();
        Team stu_1 = new Team();
        stu_1.setMark(mark);
        stu_1 = teamDao.teamId(stu_1.getMark());
        int i = Integer.parseInt(stu_1.getLevel());
        List<Mission> finish = new ArrayList<Mission>();
        List<Mission> working = new ArrayList<Mission>();
        List<Mission> Nostart = new ArrayList<Mission>();
        if(i == 2) {
            int endT = stu_1.getEndT();
            String startT = stu_1.getStartT();
            long day = getDays(startT);
            Test test = new Test();
            test.setMark(stu_1.getMark());
            List<Test> test_1 = new ArrayList<Test>();
            test_1 = cooperationDao.testUnitFind(test.getMark());
            Mission id = new Mission();
            Mission mi = new Mission();
            //测试里程碑
            if(day > endT && test_1.size() >= 3) {
                mi.setId(3);
                id = wordDao.missionId(mi.getId());
                finish.add(id);
            }else if(test_1.size() == 0){
                mi.setId(3);
                id = wordDao.missionId(mi.getId());
                Nostart.add(id);
            }else {
                mi.setId(3);
                id = wordDao.missionId(mi.getId());
                working.add(id);
            }
            //查看测试里程碑
            if(day < endT) {
                mi.setId(6);
                id = wordDao.missionId(mi.getId());
                working.add(id);
            }else {
                mi.setId(6);
                id = wordDao.missionId(mi.getId());
                finish.add(id);
            }

            Demand demand = new Demand();
            demand.setMark(stu_1.getMark());
            List<Demand> deman = new ArrayList<Demand>();
            deman = wordDao.demandFind(demand.getMark());
            //需求分析里程碑
            if(stu_1.getData() != null && deman.size() > 3 && day > endT) {
                mi.setId(2);
                id = wordDao.missionId(mi.getId());
                finish.add(id);
            }else if(deman.size() == 0){
                mi.setId(2);
                id = wordDao.missionId(mi.getId());
                Nostart.add(id);
            }else {
                mi.setId(2);
                id = wordDao.missionId(mi.getId());
                working.add(id);
            }
            Member mem = new Member();
            mem.setMark(stu_1.getMark());
            List<Member> mem_1 = new ArrayList<Member>();
            mem_1 = memberDao.memberFind(mem.getMark());

            //人员分配里程碑
            if(endT < day) {
                mi.setId(1);
                id = wordDao.missionId(mi.getId());
                finish.add(id);
            }else {
                mi.setId(1);
                id = wordDao.missionId(mi.getId());
                working.add(id);
            }
            //开发文档里程碑
            if(stu_1.getData()!= null && endT - day < 3) {
                mi.setId(4);
                id = wordDao.missionId(mi.getId());
                finish.add(id);
            }else {
                mi.setId(4);
                id = wordDao.missionId(mi.getId());
                working.add(id);
            }
            //文档导出
            if(day < endT) {
                mi.setId(8);
                id = wordDao.missionId(mi.getId());
                working.add(id);
            }else {
                mi.setId(8);
                id = wordDao.missionId(mi.getId());
                finish.add(id);
            }
            jsonObject.put("finish", finish);
            jsonObject.put("working", working);
            jsonObject.put("Nostart", Nostart);
        }else {
            jsonObject = new JSONObject("{result:false}");
        }
        return jsonObject;
    }

    public JSONObject seniorLevel(String student_id){
        JSONObject jsonObject  =  new JSONObject();
        User stu = new User();
        stu.setStudent_id(student_id);
        stu = userDao.userCheck(stu.getStudent_id());
        String mark = stu.getMark();
        Team stu_1 = new Team();
        stu_1.setMark(mark);
        stu_1 = teamDao.teamId(stu_1.getMark());
        int i = Integer.parseInt(stu_1.getLevel());
        List<Mission> finish = new ArrayList<Mission>();
        List<Mission> working = new ArrayList<Mission>();
        List<Mission> Nostart = new ArrayList<Mission>();
        if(i == 3) {
            int endT = stu_1.getEndT();
            String startT = stu_1.getStartT();
            long day = getDays(startT);
            Test test = new Test();
            test.setMark(stu_1.getMark());
            List<Test> test_1 = new ArrayList<Test>();
            test_1 = cooperationDao.testUnitFind(test.getMark());
            Mission id = new Mission();
            Mission mi = new Mission();
            //测试里程碑
            if(day > endT && test_1.size() >= 3) {
                mi.setId(3);
                id = wordDao.missionId(mi.getId());
                finish.add(id);
            }else if(test_1.size() == 0){
                mi.setId(3);
                id = wordDao.missionId(mi.getId());
                Nostart.add(id);
            }else {
                mi.setId(3);
                id = wordDao.missionId(mi.getId());
                working.add(id);
            }
            //查看测试里程碑
            if(day < endT) {
                mi.setId(6);
                id = wordDao.missionId(mi.getId());
                working.add(id);
            }else {
                mi.setId(6);
                id = wordDao.missionId(mi.getId());
                finish.add(id);
            }

            Demand demand = new Demand();
            demand.setMark(stu_1.getMark());
            List<Demand> deman = new ArrayList<Demand>();
            deman = wordDao.demandFind(demand.getMark());
            //需求分析里程碑
            if(stu_1.getData() != null && deman.size() > 3 && day > endT) {
                mi.setId(2);
                id = wordDao.missionId(mi.getId());
                finish.add(id);
            }else if(deman.size() == 0){
                mi.setId(2);
                id = wordDao.missionId(mi.getId());
                Nostart.add(id);
            }else {
                mi.setId(2);
                id = wordDao.missionId(mi.getId());
                working.add(id);
            }
            Member mem = new Member();
            mem.setMark(stu_1.getMark());
            List<Member> mem_1 = new ArrayList<Member>();
            mem_1 = memberDao.memberFind(mem.getMark());

            //人员分配里程碑
            if(endT < day) {
                mi.setId(1);
                id = wordDao.missionId(mi.getId());
                finish.add(id);
            }else {
                mi.setId(1);
                id = wordDao.missionId(mi.getId());
                working.add(id);
            }
            //开发文档里程碑
            if(stu_1.getData()!= null && endT - day < 3) {
                mi.setId(4);
                id = wordDao.missionId(mi.getId());
                finish.add(id);
            }else {
                mi.setId(4);
                id = wordDao.missionId(mi.getId());
                working.add(id);
            }
            //开发交流里程碑
            Cooperation coo = new Cooperation();
            coo.setMark(stu_1.getMark());
            List coop = new ArrayList<Cooperation>();
            coop = cooperationDao.communicateFind(coo.getMark());
            if(coop.size() == 0) {
                mi.setId(5);
                id = wordDao.missionId(mi.getId());
                Nostart.add(id);
            }
            if(coop.size() > 0 &&  day < endT - 3) {
                mi.setId(5);
                id = wordDao.missionId(mi.getId());
                working.add(id);
            }else if(coop.size() > 0 && endT - day <= 3){
                mi.setId(5);
                id = wordDao.missionId(mi.getId());
                finish.add(id);
            }
            //查看开发交流
            if(day < endT) {
                mi.setId(7);
                id = wordDao.missionId(mi.getId());
                working.add(id);
            }else {
                mi.setId(7);
                id = wordDao.missionId(mi.getId());
                finish.add(id);
            }
            //文档导出
            if(day < endT) {
                mi.setId(8);
                id = wordDao.missionId(mi.getId());
                working.add(id);
            }else {
                mi.setId(8);
                id = wordDao.missionId(mi.getId());
                finish.add(id);
            }
            jsonObject.put("finish", finish);
            jsonObject.put("working", working);
            jsonObject.put("Nostart", Nostart);
        }else {
            jsonObject = new JSONObject("{result:false}");
        }
        return jsonObject;
    }








    public static long  getDays(String date1)
    {
        SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        Date mydate = null;
        String date2 = myFormatter.format(new Date());
        try {
            date = myFormatter.parse(date1);
            mydate = myFormatter.parse(date2);
        } catch (Exception e) {
        }
        long day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
        return day;
    }
}
