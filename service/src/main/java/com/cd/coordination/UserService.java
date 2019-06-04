package com.cd.coordination;

import com.cd.coordination.entity.User;
import org.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserService {

    public JSONObject userLogin(String std_id, String std_pwd);

    public User userCheck(String std_id);

    public JSONObject userRevice(String student_id, String std_pwd, String old_pwd);

    public Integer userMark(String mark, String std_id);

    public Integer userTime(String lasttime, String thistime, String student_id);

    public JSONObject userMessage(String std_id);

    public void userCancellation(HttpServletResponse response, HttpServletRequest request) throws Exception;
}
