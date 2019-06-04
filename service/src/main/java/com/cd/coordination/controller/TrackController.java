package com.cd.coordination.controller;

import com.cd.coordination.TrackService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller("trackController")
@RequestMapping("/track")
public class TrackController {


    @Autowired
    TrackService trackService;

    @RequestMapping("/getTrack")
    @ResponseBody
    public String getTrack(HttpSession session){
        String student_id = session.getAttribute("student_id").toString();

        String mark = trackService.getUserMark(student_id);
        //value
        List<Integer> list = trackService.getTrack(student_id,mark);
        //data
        List<String> data =  trackService.getDate();
        //y
        List<String> y = new ArrayList<String>();
        y.add("value");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("xAxis",data);
        jsonObject.put("yAxis",y);
        jsonObject.put("series",list);

        return jsonObject.toString();
    }
}
