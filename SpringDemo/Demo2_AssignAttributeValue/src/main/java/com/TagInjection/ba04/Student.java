package com.TagInjection.ba04;

public class Student {
    private String name;
    private int age;
    private Building school;
    private Eat dinnerHouse;

    public Eat getDinnerHouse() {
        return dinnerHouse;
    }

    public void setDinnerHouse(Eat dinnerHouse) {
        this.dinnerHouse = dinnerHouse;
    }

    public Building getSchool() {
        return school;
    }

    public void setSchool(Building school) {
        this.school = school;
    }



    public Student() {
    }

    public Student(String name, int age, School school) {
        this.name = name;
        this.age = age;
        this.school=school;
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
                ", school=" + school +
                ", dinnerHouse=" + dinnerHouse +
                '}';
    }
}
