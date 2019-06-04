package com.cd.coordination.entity;

import java.util.List;

/**
 *
 */
public class Cooperation {
    int id; //
    String mark; //标记
    String data; //记录信息
    String announcer; //交互发布者
    String releasetime; //发布时间
    String state; //状态
    String heading; //标题
    List<Reply> Reply;

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
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
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
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getHeading() {
        return heading;
    }
    public void setHeading(String heading) {
        this.heading = heading;
    }
    public List<Reply> getReply() {
        return Reply;
    }
    public void setReply(List<Reply> reply) {
        Reply = reply;
    }
    @Override
    public String toString() {
        return "Cooperation [mark=" + mark + ", data=" + data + ", announcer=" + announcer + ", releasetime="
                + releasetime + ", state=" + state + ", heading=" + heading + ", Reply=" + Reply + "]";
    }
    public Cooperation(String mark, String data, String announcer, String state, String heading) {
        super();
        this.mark = mark;
        this.data = data;
        this.announcer = announcer;
        this.state = state;
        this.heading = heading;
    }

    public Cooperation(int id, String mark, String data, String announcer, String releasetime, String state,
                       String heading) {
        super();
        this.id = id;
        this.mark = mark;
        this.data = data;
        this.announcer = announcer;
        this.releasetime = releasetime;
        this.state = state;
        this.heading = heading;
    }
    public Cooperation() {
        super();
    }

}
