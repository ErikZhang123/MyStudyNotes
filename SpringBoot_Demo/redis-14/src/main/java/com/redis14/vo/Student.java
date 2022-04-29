package com.redis14.vo;

import java.io.Serializable;

public class Student implements Serializable {
//    在偏好设置里面的serializable class without serialVersionUID打勾，让其产生提示
//    方便产生
    private static final long serialVersionUID = 3689631499988234523L;
    String name ;
    Integer age;
    Integer sid;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sid=" + sid +
                '}';
    }
}
