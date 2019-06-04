package com.cd.coordination.controller;

import com.cd.coordination.TestUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller("testUtilController")
@RequestMapping("/testUtil")
public class TestUtilController {


    @Autowired
    TestUnitService testUnitService;

    @RequestMapping("/communicateFind")
    @ResponseBody
    public String communicateFind(HttpSession session, @RequestParam String number){
        String student_id = (String) session.getAttribute("student_id");
        return testUnitService.communicateFind(student_id,number).toString();
    }

    @RequestMapping("/communicateInsert")
    @ResponseBody
    public String communicateInsert(HttpSession session,@RequestParam String data,@RequestParam String heading){
        String student_id = (String) session.getAttribute("student_id");
        return testUnitService.communicateInsert(student_id,data,heading).toString();
    }

    @RequestMapping("/testUnitFind")
    @ResponseBody
    public String testUnitFind(HttpSession session,@RequestParam String number){
        String student_id = (String) session.getAttribute("student_id");
        return testUnitService.testUnitFind(student_id,number).toString();
    }

    @RequestMapping("/testUnit")
    @ResponseBody
    public String testUnit(HttpSession session,@RequestParam(value="field",required=false) String field, @RequestParam(value="result",required=false) String result, @RequestParam(value="subject",required=false) String subject,
                           @RequestParam(value="frequency",required=false) String frequency,@RequestParam(value="process",required=false) String process,@RequestParam(value="testprocess",required=false) String testprocess,@RequestParam(value="conclusion",required=false) String conclusion,@RequestParam(value="remark",required=false) String remark,@RequestParam(value="operator",required=false) String operator){
        String student_id = (String) session.getAttribute("student_id");
        return testUnitService.testUnit(student_id,field,result,subject,frequency,process,testprocess,conclusion,remark,operator).toString();
    }

    @RequestMapping("/testUnitRevice")
    @ResponseBody
    public String testUnitRevice(HttpSession session,@RequestParam  int id){
        String student_id = (String) session.getAttribute("student_id");
        return testUnitService.testUnitRevice(student_id,id).toString();
    }

}
