package com.cd.coordination.entity;

public class Member {
    private int id; //编号
    private String mark; //小组组号，以id来检索需求分析表
    private String student_id; //学号
    private String position; //职责
    private String name; //姓名
    private String datetime; //年级
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getMark() {
        return mark;
    }
    public void setMark(String mark) {
        this.mark = mark;
    }
    public String getStudent_id() {
        return student_id;
    }
    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDatetime() {
        return datetime;
    }
    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    @Override
    public String toString() {
        return "Member [id=" + id + ", mark=" + mark + ", student_id=" + student_id + ", position=" + position
                + ", name=" + name + ", datetime=" + datetime + "]";
    }

    public Member(int id2, String mark2, String student_id, String position, String name, String datetime) {
        id = id2;
        mark = mark2;
        this.student_id = student_id;
        this.position = position;
        this.name = name;
        this.datetime = datetime;
    }
    public Member() {
        super();
    }
}
