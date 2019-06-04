package com.cd.coordination.entity;

public class SeniorLevel {
    private String  Requirements;      //基本要求
    private String  objective;		   //主要目标
    private String  functionaldemand;  //功能需求
    private String  database;          //数据库需求
    private String  constraint;        //设计约束
    private String  dataitem;          //数据项
    private String  dictionaries;      //数据字典复审
    private String  INinterface;       //内部接口设计
    private String  OUTinterface;      //外部接口设计
    private String  Testrequirement;   //功能性测试需求
    private String  testcase;          //测试用例
    public String getRequirements() {
        return Requirements;
    }
    public void setRequirements(String requirements) {
        Requirements = requirements;
    }
    public String getObjective() {
        return objective;
    }
    public void setObjective(String objective) {
        this.objective = objective;
    }
    public String getFunctionaldemand() {
        return functionaldemand;
    }
    public void setFunctionaldemand(String functionaldemand) {
        this.functionaldemand = functionaldemand;
    }
    public String getDatabase() {
        return database;
    }
    public void setDatabase(String database) {
        this.database = database;
    }
    public String getConstraint() {
        return constraint;
    }
    public void setConstraint(String constraint) {
        this.constraint = constraint;
    }
    public String getDataitem() {
        return dataitem;
    }
    public void setDataitem(String dataitem) {
        this.dataitem = dataitem;
    }
    public String getDictionaries() {
        return dictionaries;
    }
    public void setDictionaries(String dictionaries) {
        this.dictionaries = dictionaries;
    }
    public String getINinterface() {
        return INinterface;
    }
    public void setINinterface(String iNinterface) {
        INinterface = iNinterface;
    }
    public String getOUTinterface() {
        return OUTinterface;
    }
    public void setOUTinterface(String oUTinterface) {
        OUTinterface = oUTinterface;
    }
    public String getTestrequirement() {
        return Testrequirement;
    }
    public void setTestrequirement(String testrequirement) {
        Testrequirement = testrequirement;
    }
    public String getTestcase() {
        return testcase;
    }
    public void setTestcase(String testcase) {
        this.testcase = testcase;
    }
    @Override
    public String toString() {
        return "SeniorLevel [Requirements=" + Requirements + ", objective=" + objective + ", functionaldemand="
                + functionaldemand + ", database=" + database + ", constraint=" + constraint + ", dataitem=" + dataitem
                + ", dictionaries=" + dictionaries + ", INinterface=" + INinterface + ", OUTinterface=" + OUTinterface
                + ", Testrequirement=" + Testrequirement + ", testcase=" + testcase + "]";
    }
    public SeniorLevel(String requirements, String objective, String functionaldemand, String database,
                       String constraint, String dataitem, String dictionaries, String iNinterface, String oUTinterface,
                       String testrequirement, String testcase) {
        super();
        Requirements = requirements;
        this.objective = objective;
        this.functionaldemand = functionaldemand;
        this.database = database;
        this.constraint = constraint;
        this.dataitem = dataitem;
        this.dictionaries = dictionaries;
        INinterface = iNinterface;
        OUTinterface = oUTinterface;
        Testrequirement = testrequirement;
        this.testcase = testcase;
    }
    public SeniorLevel() {
        super();
    }
}
