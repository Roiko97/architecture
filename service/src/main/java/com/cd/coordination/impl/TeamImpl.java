package com.cd.coordination.impl;


import com.cd.coordination.TeamService;
import com.cd.coordination.TrackService;
import com.cd.coordination.dao.MemberDao;
import com.cd.coordination.dao.MessageDao;
import com.cd.coordination.dao.TeamDao;
import com.cd.coordination.dao.UserDao;
import com.cd.coordination.entity.Member;
import com.cd.coordination.entity.Message;
import com.cd.coordination.entity.Team;
import com.cd.coordination.entity.User;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service("teamService")
public class TeamImpl implements TeamService {

    @Qualifier("userDao")
    @Autowired
    UserDao users;

    @Qualifier("teamDao")
    @Autowired
    TeamDao teamDao;

    @Qualifier("memberDao")
    @Autowired
    MemberDao memberDao;

    @Qualifier("messageDao")
    @Autowired
    MessageDao messageDao;

    @Autowired
    TrackService trackService;

    public JSONObject teamFind(String student_id){
        JSONObject jsonObject  =  new JSONObject();
        User check = new User();
        check.setStudent_id(student_id);
        User checkTrue = users.userCheck(check.getStudent_id());
        if(checkTrue.getMark() != null)
        {
            Member stu_1 = new Member();
            Member stu_2 = new Member();
            stu_2.setMark(checkTrue.getMark());
            List<Member> stu = new ArrayList<Member>();
            List<Team> user_1 = new ArrayList<Team>();
            Team user = new Team();
            stu_1.setStudent_id(student_id);
            if(memberDao.checkMemMark(stu_1.getStudent_id())!=null)
            {
                stu = memberDao.checkMemMark(stu_1.getStudent_id());//根据学号获取该学生加入的所有小组member库信息
                user = teamDao.teamId(stu_2.getMark());//根据mark查询当前小组的小组信息
                for(int i = 0; i < stu.size();i++) {
                    Team team = new Team();
                    Member mem = stu.get(i);
                    Team tf = teamDao.teamId(mem.getMark());
                    team.setMark(tf.getMark());
                    team.setHeading(tf.getHeading());
                    user_1.add(team);
                }
                if(user != null)
                {
                    jsonObject.put("heading",user.getHeading());
                    jsonObject.put("mark", checkTrue.getMark());
                    jsonObject.put("team", user_1);
                }
            }
        }else {
            jsonObject.put("heading", "尚未加入小组");
        }
        return jsonObject;
    }

    public String teamCreate(String student_id, String heading, String endT){
        int end = Integer.parseInt(endT);
        String mark = getRandomString(10);
        Member mem = new Member();
        Integer mark_check = teamDao.teamCreate(heading,mark,student_id,end);
        if(mark_check != 0)
        {
            User st = new User();
            st.setStudent_id(student_id);
            st = users.userCheck(st.getStudent_id());
            if(memberDao.memberInsert(mark,student_id,st.getStudent_name())!=0)
            {
                User stu = new User();
                User stu_2 = new User();
                stu.setStudent_id(student_id);
                stu_2 = users.userCheck(stu.getStudent_id());
                stu_2.setMark(mark);
                if(users.userMark(stu_2.getMark(),stu_2.getStudent_id())!= 0) {
                    trackService.insertTrack(student_id,mark);
                    return "{\"result\":true}";
                }else {
                    return "{\"result\":false}";
                }
            }else {
                return "{\"result\":false}";
            }
        }else {
            return "{\"result\":false}";
        }
    }

    public String teamChange(String student_id, String mark){
        User stu_1 = new User();
        stu_1.setMark(mark);
        stu_1.setStudent_id(student_id);
        Integer isTrue = users.userMark(stu_1.getMark(),stu_1.getStudent_id());
        if(isTrue!= 0) {
            return "{\"result\":true}";
        }else {
            return "{\"result\":false}";
        }
    }

    public String sendMessage(String student_id, String receiveid){
        User stu_1 = new User();
        String sendid = student_id;
        stu_1.setStudent_id(sendid);
        String mark = users.userCheck(stu_1.getStudent_id()).getMark();
        Message mess = new Message();
        mess.setReceiveid(receiveid);
        mess.setMark(mark);
        Message mess_1 = new Message();
        mess_1 = messageDao.messageGet(mess.getReceiveid());
        if(mess_1 == null) {
            Member mem = new Member();
            mem.setMark(mark);
            String sendname = users.userCheck(stu_1.getStudent_id()).getStudent_name();
            Team team = new Team();
            team = teamDao.teamId(mem.getMark());
            String heading = team.getHeading();
            Integer result = 0;
            Message user = new Message(sendid,receiveid,result,mark,sendname,heading);
            User check = new User();
            check.setStudent_id(receiveid);
            User isTrue = users.userCheck(check.getStudent_id());
            if(isTrue != null) {
                Integer True = messageDao.sendMessage(sendid,receiveid,result,mark,sendname,heading);
                if(True != 0 ) {
                    trackService.insertTrack(student_id,mark);
                    return "{\"result\":true}";
                }else {
                    return "{\"result\":false}";
                }
            }else {
                return "{\"result\":false}";
            }
        }else {
            return "{\"result\":false}";
        }
    }

    public String receiveMessage(String result , String mark , String student_id){
        int a = Integer.parseInt(result);
        String receiveid = student_id;
        if(a == 1) {
            User st = new User();
            st.setStudent_id(receiveid);
            st = users.userCheck(st.getStudent_id());
            Member mem = new Member();
            mem.setStudent_id(receiveid);
            mem.setMark(mark);
            mem.setName(st.getStudent_name());
            memberDao.memberInsert(mark,receiveid,st.getStudent_name());
            User stu = new User();
            stu.setStudent_id(receiveid);
            stu.setMark(mark);
            users.userMark(stu.getMark(),stu.getStudent_id());
            Message mess = new Message();
            mess.setReceiveid(receiveid);
            mess.setMark(mark);
            Integer isTrue = messageDao.deleteMessage(mess.getMark(),mess.getReceiveid());
            if(isTrue != 0) {
                trackService.insertTrack(student_id,mark);
                return "{\"result\":true}";
            }else {
                return "{\"result\":false}";
            }
        }else if (a == 2){
            Message mess = new Message();
            mess.setReceiveid(receiveid);
            mess.setMark(mark);
            Integer isTrue = messageDao.deleteMessage(mess.getMark(),mess.getReceiveid());
            if(isTrue != 0) {
                trackService.insertTrack(student_id,mark);
                return "{\"result\":true}";
            }else {
                return "{\"result\":false}";
            }
        }else {
            return "{\"result\":false}";
        }
    }

    public String positionRevice(String student_id, String position){
        User stu = new User();
        stu.setStudent_id(student_id);
        User stu_1 = new User();
        stu_1 = users.userCheck(stu.getStudent_id());
        String mark = stu_1.getMark();
        Member mem = new Member();
        mem.setMark(mark);
        mem.setStudent_id(student_id);
        Member new_mem = memberDao.teamMember(mem.getStudent_id(),mem.getMark());
        if(new_mem != null) {
            new_mem.setPosition(position);
            Integer isTrue = memberDao.memberRevise(new_mem.getMark(),new_mem.getStudent_id(),new_mem.getPosition());
            if(isTrue != 0) {
                trackService.insertTrack(student_id,mark);
                return "{\"result\":true}";
            }else {
                return "{\"result\":false}";
            }
        }else {
            //未找到该成员
            return "{\"result\":false}";
        }
    }

    public JSONObject memberFind(String student_id){
        JSONObject jsonObject  =  new JSONObject();
        User stu = new User();
        stu.setStudent_id(student_id);
        User stu_1 = new User();
        stu_1 = users.userCheck(stu.getStudent_id());
        String mark = stu_1.getMark();
        if(mark !=null) {
            Member mem = new Member();
            mem.setMark(mark);
            List<Member>allmem = new ArrayList<Member>();
            allmem = memberDao.memberFind(mem.getMark());
            Team team = new Team();
            team = teamDao.teamFind(mem.getStudent_id(),mem.getMark());
            String starT = team.getStartT();
            int endT = team.getEndT();
            String date = null;
            try {
                date = getAfterDay(starT,endT);
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if(allmem != null) {
                jsonObject.put("member", allmem);
                jsonObject.put("endT", date);
            }else {
                jsonObject.put("false","false");
            }
        }else {
            jsonObject = new JSONObject("{result:null}");

        }
        return jsonObject;
    }

    public String leaveTeam(String student_id){
        User stu = new User();
        stu.setStudent_id(student_id);
        User stu_1 = new User();
        stu_1 = users.userCheck(stu.getStudent_id());
        String mark = stu_1.getMark();
        if(mark != null) {
            Member mem = new Member();
            mem.setMark(mark);
            mem.setStudent_id(student_id);
            Integer isTrue = memberDao.leaveTeam(mem.getStudent_id(),mem.getMark());
            if(isTrue != 0) {
                List<Member> user = new ArrayList<Member>();
                Member mem_1 = new Member();
                mem_1.setMark(mark);
                user = memberDao.memberFind(mem_1.getMark());
                if(user != null) {
                    Member mem_2 = user.get(1);
                    User stu_2 = new User();
                    stu_2.setMark(mem_2.getMark());
                    stu_2.setStudent_id(student_id);
                    Integer istrue = users.userMark(stu_2.getMark(),stu_2.getStudent_id());
                    if(istrue!= 0) {
                        trackService.insertTrack(student_id,mark);
                        return "{\"result\":true}";
                    }else {
                        return "{\"result\":false}";
                    }
                }else {
                    trackService.insertTrack(student_id,mark);
                    return "{\"result\":true}";
                }
            }else {
                trackService.insertTrack(student_id,mark);
                return "{\"result\":true}";
            }
        }else {
            trackService.insertTrack(student_id,mark);
            return "{\"result\":true}";
        }
    }

    public JSONObject checkMessage(String student_id){
        JSONObject jsonObject  =  new JSONObject();
        Message stu = new Message();
        stu.setReceiveid(student_id);
        List<Message> stu_1 = null;
        stu_1 = messageDao.messageFind(stu.getReceiveid());
        if(stu_1 != null) {
            jsonObject.put("message", stu_1);
        }else {
            jsonObject = new JSONObject("{result:fasle}");

        }
        return jsonObject;
    }

    String getAfterDay(String startDay, int count) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf.parse(startDay);
            Calendar cl = Calendar.getInstance();
            cl.setTime(date);
            cl.add(Calendar.DATE, count);
            return sdf.format(cl.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    private String getRandomString(int length) {
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
