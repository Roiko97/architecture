package com.cd.coordination.entity;

public class Message {
    Integer id;
    String sendid; //发送者id
    String receiveid; //接受者id
    Integer result; //0代表未处理 1代表确定 2代表拒绝
    String releasetime; //发送时间
    String mark;     //标记
    String sendname; //发送者姓名
    String teamname; //发送者组名
    String heading;  //组名

    public String getSendid() {
        return sendid;
    }
    public void setSendid(String sendid) {
        this.sendid = sendid;
    }
    public Integer getResult() {
        return result;
    }
    public void setResult(Integer result) {
        this.result = result;
    }
    public String getReleasetime() {
        return releasetime;
    }
    public void setReleasetime(String releasetime) {
        this.releasetime = releasetime;
    }

    public String getReceiveid() {
        return receiveid;
    }
    public void setReceiveid(String receiveid) {
        this.receiveid = receiveid;
    }
    public String getMark() {
        return mark;
    }
    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getSendname() {
        return sendname;
    }
    public void setSendname(String sendname) {
        this.sendname = sendname;
    }


    public String getTeamname() {
        return teamname;
    }
    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }


    public String getHeading() {
        return heading;
    }
    public void setHeading(String heading) {
        this.heading = heading;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", sendid='" + sendid + '\'' +
                ", receiveid='" + receiveid + '\'' +
                ", result=" + result +
                ", releasetime='" + releasetime + '\'' +
                ", mark='" + mark + '\'' +
                ", sendname='" + sendname + '\'' +
                ", teamname='" + teamname + '\'' +
                ", heading='" + heading + '\'' +
                '}';
    }

    public Message(String sendid, String reciveid, Integer result) {
        super();
        this.sendid = sendid;
        this.receiveid = reciveid;
        this.result = result;
    }
    public Message(String sendid, String reciveid) {
        super();
        this.sendid = sendid;
        this.receiveid = reciveid;
    }

    public Message(String sendid, String receiveid, Integer result, String mark, String sendname) {
        super();
        this.sendid = sendid;
        this.receiveid = receiveid;
        this.result = result;
        this.mark = mark;
        this.sendname = sendname;
    }


    public Message(String sendid, String receiveid, Integer result, String mark, String sendname, String heading) {
        super();
        this.sendid = sendid;
        this.receiveid = receiveid;
        this.result = result;
        this.mark = mark;
        this.sendname = sendname;
        this.heading = heading;
    }
    public Message() {
        super();
    }
    public Message(String sendid, String receiveid, Integer result, String releasetime, String mark, String sendname,
                   String heading) {
        super();
        this.sendid = sendid;
        this.receiveid = receiveid;
        this.result = result;
        this.releasetime = releasetime;
        this.mark = mark;
        this.sendname = sendname;
        this.heading = heading;
    }

}
