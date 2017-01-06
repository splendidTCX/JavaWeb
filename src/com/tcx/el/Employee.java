package com.tcx.el;

/**
 * Created by Tang on 2017/1/6.
 */
public class Employee {
    private String name;
    private int age;

    public String getName() {
        System.out.println("GetName Excute!");
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
