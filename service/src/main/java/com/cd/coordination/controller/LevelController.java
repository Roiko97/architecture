package com.cd.coordination.controller;


import com.cd.coordination.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller("levelController")
@RequestMapping("level")
public class LevelController {

    @Autowired
    LevelService levelService;

    @RequestMapping("/demandLevel")
    @ResponseBody
    public String demandLevel(HttpSession session){
        String student_id = (String) session.getAttribute("student_id");
        return levelService.demandLevel(student_id).toString();
    }

    @RequestMapping("/intermediateLevel")
    @ResponseBody
    public String intermediateLevel(HttpSession session){
        String student_id = (String) session.getAttribute("student_id");
        return levelService.intermediateLevel(student_id).toString();
    }

    @ResponseBody
    @RequestMapping("/missionLevel")
    public String missionLevel(HttpSession session) throws Exception {
        String student_id = (String) session.getAttribute("student_id");
        return levelService.missionLevel(student_id).toString();
    }

    @RequestMapping("/primaryLevel")
    @ResponseBody
    public String primaryLevel(HttpSession session){
        String student_id = (String) session.getAttribute("student_id");
        return levelService.primaryLevel(student_id).toString();
    }

    @ResponseBody
    @RequestMapping("/seniorLevel")
    public String seniorLevel(HttpSession session){
        String student_id = (String) session.getAttribute("student_id");
        return levelService.seniorLevel(student_id).toString();
    }
}
