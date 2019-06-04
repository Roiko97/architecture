package com.cd.coordination.entity;

public class Reply {
    String date; //记录信息
    String announcer; //交互发布者
    String releasetime; //发布时间
    String mark; //标记
    String reply_id; //回复标记
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getAnnouncer() {
        return announcer;
    }
    public void setAnnouncer(String announcer) {
        this.announcer = announcer;
    }
    public String getReleasetime() {
        return releasetime;
    }
    public void setReleasetime(String releasetime) {
        this.releasetime = releasetime;
    }

    public String getMark() {
        return mark;
    }
    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getReply_id() {
        return reply_id;
    }
    public void setReply_id(String reply_id) {
        this.reply_id = reply_id;
    }
    @Override
    public String toString() {
        return "Reply [date=" + date + ", announcer=" + announcer + ", releasetime=" + releasetime + ", mark=" + mark
                + "]";
    }
    public Reply(String date, String announcer, String releasetime, String mark) {
        super();
        this.date = date;
        this.announcer = announcer;
        this.mark = mark;
    }
    public Reply() {
        super();
    }


}
