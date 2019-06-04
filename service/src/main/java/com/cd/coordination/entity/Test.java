package com.cd.coordination.entity;

public class Test {
    private int id; //编号
    private String mark; //小组唯一表示，以id来检索需求分析表
    private String subject; //题目
    private String frequency; //次数
    private String field; //预期结果
    private String process; //预期过程
    private String testprocess; //测试过程
    private String result ; //测试结果
    private String conclusion; //测试结论
    private String remark ; //备注
    private String operator; //姓名
    private String releasetime; //发布时间
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
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getFrequency() {
        return frequency;
    }
    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }
    public String getField() {
        return field;
    }
    public void setField(String field) {
        this.field = field;
    }
    public String getProcess() {
        return process;
    }
    public void setProcess(String process) {
        this.process = process;
    }
    public String getTestprocess() {
        return testprocess;
    }
    public void setTestprocess(String testprocess) {
        this.testprocess = testprocess;
    }
    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }
    public String getConclusion() {
        return conclusion;
    }
    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
    public String getOperator() {
        return operator;
    }
    public void setOperator(String operator) {
        this.operator = operator;
    }
    public String getReleasetime() {
        return releasetime;
    }
    public void setReleasetime(String releasetime) {
        this.releasetime = releasetime;
    }

    @Override
    public String toString() {
        return "Test [id=" + id + ", mark=" + mark + ", subject=" + subject + ", frequency=" + frequency + ", field="
                + field + ", process=" + process + ", testprocess=" + testprocess + ", result=" + result
                + ", conclusion=" + conclusion + ", remark=" + remark + ", operator=" + operator + ", releasetime="
                + releasetime + "]";
    }
    public Test(String mark, String subject, String operator, String frequency, String field, String process, String testprocess,
                String result, String conclusion, String remark) {
        super();
        this.mark = mark;
        this.subject = subject;
        this.operator = operator;
        this.frequency = frequency;
        this.field = field;
        this.process = process;
        this.testprocess = testprocess;
        this.result = result;
        this.conclusion = conclusion;
        this.remark = remark;
    }
    public Test() {
        super();
    }
}
