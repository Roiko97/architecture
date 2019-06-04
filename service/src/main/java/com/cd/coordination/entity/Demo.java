package com.cd.coordination.entity;

public class Demo {
    private String id;
    private String date; //文本
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    @Override
    public String toString() {
        return "demo [id=" + id + ", date=" + date + "]";
    }
    public Demo(String id, String date) {
        super();
        this.id = id;
        this.date = date;
    }
    public Demo() {
        super();
    }

}
