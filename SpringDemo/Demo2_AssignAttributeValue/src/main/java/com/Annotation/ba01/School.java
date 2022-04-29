package com.Annotation.ba01;

import com.Annotation.ba01.Building;
import com.Annotation.ba01.Eat;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value="dinnerHouse")
public class School extends Building implements Eat {
    @Value("USYD")
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
