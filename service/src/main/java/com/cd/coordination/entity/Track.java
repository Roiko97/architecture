package com.cd.coordination.entity;

import org.springframework.format.annotation.DateTimeFormat;

public class Track {

    private Integer id;

    private String student_id;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    private String dealTime;

    private String mark;

    @Override
    public String toString() {
        return "Track{" +
                "id=" + id +
                ", student_id='" + student_id + '\'' +
                ", dealTime=" + dealTime +
                ", mark='" + mark + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }



    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Track() {
        super();
    }

    public String getDealTime() {
        return dealTime;
    }

    public void setDealTime(String dealTime) {
        this.dealTime = dealTime;
    }

    public Track(Integer id, String student_id, String dealTime, String mark) {
        this.id = id;
        this.student_id = student_id;
        this.dealTime = dealTime;
        this.mark = mark;
    }
}
