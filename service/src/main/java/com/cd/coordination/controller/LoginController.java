package com.cd.coordination.controller;

import com.cd.coordination.UserService;
import com.cd.coordination.dao.UserDao;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller("loginController")
@RequestMapping("/login")
public class LoginController {


    @Qualifier("userDao")
    @Autowired
    private UserDao userDao;

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/testLogin" )
    public String  testLogin(String student_id , String password) {
        JSONObject jsonObject = userService.userLogin(student_id, password);
        return jsonObject.toString();
        //  return ServerResponse.createBySuccess(jsonObject);
    }

    @ResponseBody
    @RequestMapping(value = "/userLogin" )
    public String  userLogin(String student_id , String password , HttpSession session ) {
        JSONObject jsonObject = userService.userLogin(student_id, password);

        session.setAttribute("student_id",student_id);
        session.setAttribute("password",password);


        return jsonObject.toString();
      //  return ServerResponse.createBySuccess(jsonObject);
    }

    @ResponseBody
    @RequestMapping("/userRevice")
    public String userRevice(HttpSession session , @RequestParam String password){
        String student_id = (String) session.getAttribute("student_id");
        String old_pwd = (String) session.getAttribute("password");
        return userService.userRevice(student_id,password,old_pwd).toString();
        //return ServerResponse.createBySuccess(userService.UserReviceServlet(student_id,password,old_pwd));
    }

    @RequestMapping("/userMessage")
    @ResponseBody
    public String userMessage(HttpSession session){
        String student_id = (String) session.getAttribute("student_id");
        return  userService.userMessage(student_id).toString();
       // return ServerResponse.createBySuccess( userService.UserMessageServlet(student_id));
    }

    @RequestMapping("/userCancellation")
    public String userCancellation(HttpSession session ,HttpServletResponse response, HttpServletRequest request) throws Exception {
        userService.userCancellation(response,request);
        return "redirect:home";
    }

}
