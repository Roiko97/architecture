package com.cd.coordination.entity;

public class IntermediateLevel {
    private String name; //模板名
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "IntermediateLevel [name=" + name + "]";
    }

    public IntermediateLevel() {
        super();
    }

}
