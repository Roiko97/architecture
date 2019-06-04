package com.cd.coordination.entity;

public class Demand {
    private Integer id;
    private String mark;  //标记
    private String title; //标题
    private String date;  //内容
    private String releasetime; //发布时间
    public String getMark() {
        return mark;
    }
    public void setMark(String mark) {
        this.mark = mark;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getReleasetime() {
        return releasetime;
    }
    public void setReleasetime(String releasetime) {
        this.releasetime = releasetime;
    }

    @Override
    public String toString() {
        return "Demand{" +
                "id=" + id +
                ", mark='" + mark + '\'' +
                ", title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", releasetime='" + releasetime + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Demand(String mark, String title, String date) {
        super();
        this.mark = mark;
        this.title = title;
        this.date = date;
    }
    public Demand() {
        super();
    }

}
