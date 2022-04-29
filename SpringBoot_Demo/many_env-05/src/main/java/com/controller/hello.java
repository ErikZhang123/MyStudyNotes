package com.controller;

import com.vo.School;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class hello {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return " Many environment hello";
    }


    @Value("${school.name}")
    String name;
    @Value("${site}")
    String site;

    @RequestMapping("/read")
    @ResponseBody
    public String read(){
        return "schoolname is "+name + ". site is "+ site;
    }

    @Resource // 从容器中获取一个同名对象，如果不存在则获取一个school类型的对象
    private School info;

    @RequestMapping("/info")
    @ResponseBody
    public String schoolInfo(){
        return info.toString();
    }
}
