package com.cd.coordination.impl;

import com.cd.coordination.TrackService;
import com.cd.coordination.UserService;
import com.cd.coordination.dao.UserDao;
import com.cd.coordination.entity.User;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service("userService")
public class UserServiceImpl  implements UserService {

    @Qualifier("userDao")
    @Autowired
    private UserDao userDao;

    @Autowired
    TrackService trackService;

    public JSONObject userLogin(String std_id, String std_pwd) {
        JSONObject jsonObject ;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//获取此次登录时间
        Date now = new Date();
        String time = df.format(now);
        User user  = new User();
        User user_new = userDao.userLogin(std_id,std_pwd);
        System.out.println(user_new);
        if(user_new != null)
        {
            user_new.setLasttime(user_new.getThistime());
            user_new.setThistime(time);
            Integer isTrue = userDao.userTime(user_new.getLasttime(),user_new.getThistime(),user_new.getStudent_id());
            if(isTrue != 0) {
                jsonObject = new JSONObject("{result:true}");
            }else {
                jsonObject = new JSONObject("{result:false}");
            }
        }else {
            jsonObject = new JSONObject("{result:false}");
        }
        System.out.println("jsonObj="+jsonObject);
        return jsonObject;
    }

    public User userCheck(String std_id) {
        return userDao.userCheck(std_id);
    }

    public JSONObject userRevice(String student_id,String std_pwd, String old_pwd) {
        JSONObject jsonObject ;
        User user  = new User();
        user.setStudent_id(student_id);
        user.setPassword(old_pwd);
        User user_new = userDao.userLogin(user.getStudent_id(),user.getPassword());
        user_new.setPassword(std_pwd);
        Integer isTrue = userDao.userRevise(user_new.getStudent_id(),user_new.getPassword());
        if(isTrue != 0) {
            trackService.insertTrack(student_id,trackService.getUserMark(student_id));
            jsonObject = new JSONObject("{result:true}");
        }else {
            jsonObject = new JSONObject("{result:false}");
        }
        return jsonObject;
    }

    public Integer userMark(String mark , String std_id) {
       return userDao.userMark(mark,std_id);
    }

    public Integer userTime(String lasttime, String thistime, String std_id) {
        return userDao.userTime(lasttime,thistime,std_id);
    }

    public JSONObject userMessage(String std_id) {
        JSONObject jsonObject  =  new JSONObject();
        User stu = new User();
        stu.setStudent_id(std_id);
        if(userDao.userMessage(std_id)!= null) {
            jsonObject.put("message", userDao.userMessage(std_id));
        }else {
            jsonObject = new JSONObject("{result:false}");
        }
        return jsonObject;
    }


    public void userCancellation(HttpServletResponse response,HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession(false);//防止创建Session
        if(session == null){
            return ;
        }
        session.removeAttribute("student_id");
    }


}
