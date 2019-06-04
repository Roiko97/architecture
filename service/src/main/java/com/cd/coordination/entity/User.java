package com.cd.coordination.entity;

public class User {
    private Integer id; //编号
    private String student_id; //学号
    private String student_name; //姓名
    private String password; //密码
    private String datatime; //年级
    private String mark;     //当前项目标记
    private String lasttime; //上次登录时间
    private String thistime; //当前登录时间
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getStudent_id() {
        return student_id;
    }
    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }
    public String getStudent_name() {
        return student_name;
    }
    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getDatatime() {
        return datatime;
    }
    public void setDatatime(String datatime) {
        this.datatime = datatime;
    }

    public String getMark() {
        return mark;
    }
    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getLasttime() {
        return lasttime;
    }
    public void setLasttime(String lasttime) {
        this.lasttime = lasttime;
    }
    public String getThistime() {
        return thistime;
    }
    public void setThistime(String thistime) {
        this.thistime = thistime;
    }
    @Override
    public String toString() {
        return "User [student_id=" + student_id + ", student_name=" + student_name + ", password=" + password
                + ", datatime=" + datatime + ", mark=" + mark + "]";
    }
    public User(String student_id, String password) {
        super();
        this.student_id = student_id;
        this.password = password;
    }

    public User(String student_id, String student_name, String password, String datatime, String mark) {
        super();
        this.student_id = student_id;
        this.student_name = student_name;
        this.password = password;
        this.datatime = datatime;
        this.mark = mark;
    }
    public User() {
        super();
    }
}
