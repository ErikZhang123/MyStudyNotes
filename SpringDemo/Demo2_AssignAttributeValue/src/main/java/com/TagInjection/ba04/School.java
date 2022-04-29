package com.TagInjection.ba04;

public class School extends Building implements Eat{
    private String name;

    public School() {
    }
    public School(String name) {
        this.name = name;
    }

    @Override
    public void eat() {
        System.out.println("学校食堂");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                '}';
    }
}
