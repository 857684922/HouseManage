package com.xun.housemanage;

/**
 * Created by Administrator on 2016/5/11.
 */
public class Student {
    private String name;
    private String id;
    private String grade;

    public Student(String name, String id, String grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getGrade() {

        return grade;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {

        return id;
    }

    public String getName() {
        return name;
    }
}
