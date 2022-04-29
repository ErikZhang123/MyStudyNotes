package com.vo;

public class Cat {
    private String catId;

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public String getName() {
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

    private String name;
    private int age;

    @Override
    public String toString() {
        return "Cat{" +
                "catId='" + catId + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
