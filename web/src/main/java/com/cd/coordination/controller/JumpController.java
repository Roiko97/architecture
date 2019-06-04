package com.cd.coordination.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller("jumpController")
@RequestMapping("/jump")
public class JumpController {


    @RequestMapping(value = "/home")
    public String home() {
        return "on";
    }

    @RequestMapping("/toSummarize")
    public String toSummarize(HttpSession session){
        String student_id = (String)session.getAttribute("student_id");
        if(student_id == null)
            return "redirect:home";
        else
            return "Summarize";
    }

    @RequestMapping("/toCommunicate")
    public String toCommunicate(HttpSession session){
        String student_id = (String)session.getAttribute("student_id");
        if(student_id == null)
            return "redirect:home";
        else
            return "Communicate";
    }

    @RequestMapping("/toDemand")
    public String toDemand(HttpSession session){
        String student_id = (String)session.getAttribute("student_id");
        if(student_id == null)
            return "redirect:home";
        else
            return "Demand";
    }
    @RequestMapping("/toDevelopment")
    public String toDevelopment(HttpSession session){
        String student_id = (String)session.getAttribute("student_id");
        if(student_id == null)
            return "redirect:home";
        else
            return "Development";
    }
    @RequestMapping("/toDocument")
    public String toDocument(HttpSession session){
        String student_id = (String)session.getAttribute("student_id");
        if(student_id == null)
            return "redirect:home";
        else
            return "Document";
    }
    @RequestMapping("/toFileExport")
    public String toFileExport(HttpSession session){
        String student_id = (String)session.getAttribute("student_id");
        if(student_id == null)
            return "redirect:home";
        else
            return "FileExport";
    }
    @RequestMapping("/toTestUnit")
    public String toTestUnit(HttpSession session){
        String student_id = (String)session.getAttribute("student_id");
        if(student_id == null)
            return "redirect:home";
        else
            return "TestUnit";
    }
}
