package com.Annotation.ba01;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


public class Building implements Eat{

    String color;
    public Building(){}

    public Building(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Building{" +
                "color='" + color + '\'' +
                '}';
    }

    @Override
    public void eat() {
        System.out.println("building eat");
    }
}
