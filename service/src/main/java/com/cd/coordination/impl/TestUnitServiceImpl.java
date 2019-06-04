package com.cd.coordination.impl;

import com.cd.coordination.TestUnitService;
import com.cd.coordination.TrackService;
import com.cd.coordination.dao.CooperationDao;
import com.cd.coordination.dao.UserDao;
import com.cd.coordination.entity.Cooperation;
import com.cd.coordination.entity.Test;
import com.cd.coordination.entity.User;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("testUnitService")
public class TestUnitServiceImpl implements TestUnitService {

    @Qualifier("userDao")
    @Autowired
    UserDao userDao;

    @Qualifier("cooperationDao")
    @Autowired
    CooperationDao cooperationDao;

    @Autowired
    TrackService trackService;

    public JSONObject communicateFind(String student_id,String number) {
        JSONObject jsonObject  =  new JSONObject();
        User stu = new User();
        stu.setStudent_id(student_id);
        String mark = userDao.userCheck(stu.getStudent_id()).getMark();
        if(mark == null) {
            jsonObject = new JSONObject("{result:false}");
        }else {
            int a = Integer.parseInt(number);
            Cooperation writer = new Cooperation();
            writer.setMark(mark);
            List<Cooperation> Istrue = cooperationDao.communicateFind(writer.getMark());
            if(Istrue != null) {
                Cooperation[]test = new Cooperation[Istrue.size()];
                Cooperation[]send = new Cooperation[7];
                int b = Istrue.size();
                for(int i = 0; i< Istrue.size(); i++) {
                    test[i] = Istrue.get(i);
                }
                if(b == 0) {
                    jsonObject.put("send", send);
                }
                if(a*7 > b && a*7 - 7 <= b || a*7 == b) {
                    int j = 0;
                    for(int i = a*7 - 7; i < b;i++)
                    {
                        System.out.print(test[i]);
                        send[j++] = test[i];
                    }
                    jsonObject.put("send", send);
                }
                if(a*7 < b ) {
                    for(int i = a*7 - 7; i < a*7;i++)
                    {
                        send[i] = test[i];
                    }
                    jsonObject.put("send", send);
                }
            }else {
                jsonObject = new JSONObject("{result:false}");
            }
        }
        return jsonObject;
    }

    public JSONObject communicateInsert(String student_id,String data,String heading) {
        JSONObject jsonObject  =  new JSONObject();
        User stu_1 = new User();
        stu_1.setStudent_id(student_id);
        String mark = userDao.userCheck(stu_1.getStudent_id()).getMark();
        String state = "未回复";
        User istrue = new User();
        istrue.setStudent_id(student_id);
        String announcer = userDao.userCheck(istrue.getStudent_id()).getStudent_name();
        Cooperation stu = new Cooperation(mark,data,announcer,state,heading);
        Integer isTrue = cooperationDao.communicateInsert(stu.getMark(),stu.getData(),stu.getAnnouncer(),stu.getState(),stu.getHeading());
        if(isTrue != 0) {
            trackService.insertTrack(student_id,mark);
            jsonObject.put("communicate", cooperationDao.communicateFind(stu.getMark()));
        }else {
            jsonObject = new JSONObject("{result:false}");
        }
        return jsonObject;
    }

    public JSONObject testUnitFind(String student_id, String number) {
        JSONObject jsonObject = new JSONObject();
        User stu_1 = new User();
        stu_1.setStudent_id(student_id);
        String mark = userDao.userCheck(stu_1.getStudent_id()).getMark();
        if(mark == null) {
            jsonObject = new JSONObject("{result:false}");
        }else {
            int a = Integer.parseInt(number);
            Test writer = new Test();
            writer.setMark(mark);
            List<Test> Istrue = cooperationDao.testUnitFind(writer.getMark());
            if(Istrue != null) {
                Test []test = new Test[Istrue.size()];
                Test []send = new Test[5];
                int b = Istrue.size();
                for(int i = 0; i< Istrue.size(); i++) {
                    test[i] = Istrue.get(i);
                }
                if(a*5 - 4 > b) {
                    jsonObject.put("send", send);
                }
                if(a*5 > b && a*5 - 4 <= b || a*5 == b) {
                    int j = 0;
                    for(int i = a*5 - 5; i < b;i++)
                    {
                        send[j++] = test[i];
                    }
                    jsonObject.put("send", send);
                }
                if(a*5 < b ) {
                    for(int i = a*5 - 5; i < a*5;i++)
                    {
                        send[i] = test[i];
                    }
                    jsonObject.put("send", send);
                }
            }else {
                jsonObject = new JSONObject("{result:false}");
            }
        }
        return jsonObject;
    }

    public JSONObject testUnit(String student_id, String field, String result, String subject, String frequency, String process, String testprocess, String conclusion, String remark, String operator) {
        JSONObject jsonObject;
        String mark =  userDao.userCheck(student_id).getMark();
        Test writer = new Test(mark,subject,operator,frequency,field,process,testprocess,result,conclusion,remark);
        Integer Istrue = cooperationDao.testUnitInsert(writer.getMark(),
                writer.getSubject(),writer.getOperator(),writer.getFrequency(),writer.getField(),writer.getProcess(),writer.getTestprocess(),writer.getResult(),writer.getConclusion(),writer.getRemark());
        if(Istrue != 0) {
            trackService.insertTrack(student_id,mark);
            jsonObject = new JSONObject("{result:true}");
        }else {
            jsonObject = new JSONObject("{result:false}");
        }
        return jsonObject;
    }

    public JSONObject testUnitRevice(String student_id, int id) {
        JSONObject jsonObject;
        User stu_1 = new User();
        stu_1.setStudent_id(student_id);
        String mark = userDao.userCheck(stu_1.getStudent_id()).getMark();
        int a = id;
        Test test = new Test();
        test.setId(a);
        test.setMark(mark);
        Integer isTrue = cooperationDao.testUnitDelete(test.getMark(),test.getId());
        if(isTrue != 0) {
            trackService.insertTrack(student_id,mark);
            jsonObject = new JSONObject("{result:true}");
        }else {
            jsonObject = new JSONObject("{result:false}");
        }
        return jsonObject;
    }
}
