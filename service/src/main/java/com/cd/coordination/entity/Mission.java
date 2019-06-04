package com.cd.coordination.entity;

public class Mission {
    private int id;
    private String name;  //名称
    private String introduce; //介绍
    private String process;  //过程
    private String effect; //作用
    private String jump;//跳转页面

    public int getId() {
        return id;
    }
    public void setId(int  number) {
        this.id = number;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getIntroduce() {
        return introduce;
    }
    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
    public String getProcess() {
        return process;
    }
    public void setProcess(String process) {
        this.process = process;
    }
    public String getEffect() {
        return effect;
    }
    public void setEffect(String effect) {
        this.effect = effect;
    }
    public String getJump() {
        return jump;
    }
    public void setJump(String jump) {
        this.jump = jump;
    }
    @Override
    public String toString() {
        return "Mission [name=" + name + ", introduce=" + introduce + ", process=" + process + ", effect=" + effect
                + ", jump=" + jump + "]";
    }
    public Mission(String name, String introduce, String process, String effect, String jump) {
        super();
        this.name = name;
        this.introduce = introduce;
        this.process = process;
        this.effect = effect;
        this.jump = jump;
    }
    public Mission() {
        super();
    }
}
