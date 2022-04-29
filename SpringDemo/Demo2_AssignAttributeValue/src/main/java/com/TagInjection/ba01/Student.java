package com.TagInjection.ba01;

public class Student {
    String name;
    int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("setName被调用");
        this.name = name;
    }
//本类中并不存在Email属性
    public void setEmail(String name) {
        System.out.println("setEmail被调用");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("setAge被调用");
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
