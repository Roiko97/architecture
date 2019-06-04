package com.cd.coordination.controller;


import com.cd.coordination.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

//import org.json.JSONObject;

@Controller("teamController")
@RequestMapping("/team")
public class TeamController {

    @Autowired
    TeamService teamService;


    @RequestMapping("/teamFind")
    @ResponseBody
    public String teamFind(HttpSession session){
        String student_id = (String) session.getAttribute("student_id");
        return teamService.teamFind(student_id).toString();
    }

    @RequestMapping("/teamCreate")
    @ResponseBody
    public String teamCreate(HttpSession session, @RequestParam  String heading, @RequestParam String endT){
        String student_id = (String) session.getAttribute("student_id");
        return teamService.teamCreate(student_id,heading,endT);
    }

    @RequestMapping("/teamChange")
    @ResponseBody
    public String teamChange(HttpSession session, @RequestParam  String mark){
        String student_id = (String) session.getAttribute("student_id");
        return teamService.teamChange(student_id,mark);
    }

    @RequestMapping("/sendMessage")
    @ResponseBody
    public String sendMessage( HttpSession session,@RequestParam(value="receiveid",required=false)String receiveid){
        String student_id = (String) session.getAttribute("student_id");
        return teamService.sendMessage(student_id,receiveid);
    }

    @RequestMapping("/receiveMessage")
    @ResponseBody
    public String receiveMessage( HttpSession session,@RequestParam  String result , @RequestParam String mark ){
        String student_id = (String) session.getAttribute("student_id");
        return teamService.receiveMessage(result,mark,student_id);
    }

    @RequestMapping("/positionRevice")
    @ResponseBody
    public String positionRevice(HttpSession session,@RequestParam String position){
        String student_id = (String) session.getAttribute("student_id");
        return teamService.positionRevice(student_id,position);
    }

    @RequestMapping("/leaveTeam")
    @ResponseBody
    public String leaveTeam(HttpSession session){
        String student_id = (String) session.getAttribute("student_id");
        return teamService.leaveTeam(student_id);
    }

    @RequestMapping("/memberFind")
    @ResponseBody
    public String memberFind(HttpSession session){
        String student_id = (String) session.getAttribute("student_id");
        return teamService.memberFind(student_id).toString();
    }

    @RequestMapping("/checkMessage")
    @ResponseBody
    public String checkMessage(HttpSession session){
        String student_id = (String) session.getAttribute("student_id");
        return teamService.checkMessage(student_id).toString();
    }
}
