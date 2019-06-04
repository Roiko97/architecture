package com.cd.coordination.impl;

import com.cd.coordination.TrackService;
import com.cd.coordination.dao.TrackDao;
import com.cd.coordination.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;


@Service("trackService")
public class TrackServiceImpl implements TrackService {

    @Autowired
    TrackDao trackDao;

    @Autowired
    UserDao userDao;

    public List<Integer> getTrack(String student_id, String mark) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        List<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<7;i++){
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(new Date());
            calendar.add(calendar.DATE,-i);
            String date2= sdf.format(calendar.getTime());
            Integer result = trackDao.getTrack(student_id,mark,date2);
            list.add(result);
        }
        System.out.println(list);
        return list;
    }

    public Integer insertTrack(String student_id, String mark) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(new Date());
        return trackDao.insertTrack(student_id,mark,date);
    }

    public String getUserMark(String student_id) {
        return userDao.userCheck(student_id).getMark();
    }

    public List<String> getDate(){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<String> list = new ArrayList<String>();

        for(int i=0;i<7;i++){
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(new Date());
            calendar.add(calendar.DATE,-i);
            String date2= sdf.format(calendar.getTime());
            list.add(date2);
        }

        return list;
    }
}
