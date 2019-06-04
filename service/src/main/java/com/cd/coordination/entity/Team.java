package com.cd.coordination.entity;

public class Team {
    private int id; //编号
    private String heading; //小组选题
    private String schedule; //进度
    private String mark; //小组唯一表示，以id来检索需求分析表
    private String data; //需求分析内容
    private String startT; //项目开始时间
    private int endT; //项目结束时间
    private String student_id; //小组创建人id
    private String level; //模板等级
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getHeading() {
        return heading;
    }
    public void setHeading(String heading) {
        this.heading = heading;
    }
    public String getSchedule() {
        return schedule;
    }
    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }
    public String getMark() {
        return mark;
    }
    public void setMark(String mark) {
        this.mark = mark;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public String getStartT() {
        return startT;
    }
    public void setStartT(String startT) {
        this.startT = startT;
    }
    public int getEndT() {
        return endT;
    }
    public void setEndT(int endT) {
        this.endT = endT;
    }

    public String getStudent_id() {
        return student_id;
    }
    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getLevel() {
        return level;
    }
    public void setLevel(String level) {
        this.level = level;
    }
    public Team(int id, String heading, String schedule, String mark, String data, String startT, int endT) {
        super();
        this.id = id;
        this.heading = heading;
        this.schedule = schedule;
        this.mark = mark;
        this.data = data;
        this.startT = startT;
        this.endT = endT;
    }
    public Team(int id, String heading, String schedule, String mark, String startT, int endT) {
        super();
        this.id = id;
        this.heading = heading;
        this.schedule = schedule;
        this.mark = mark;
        this.startT = startT;
        this.endT = endT;
    }

    public Team(String mark) {
        super();
        this.mark = mark;
        // TODO Auto-generated constructor stub
    }
    public Team() {
        super();
    }


}
