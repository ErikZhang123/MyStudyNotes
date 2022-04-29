package com.thymeleaf19.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class helloThymeleaf {

    @RequestMapping("/hello")
    public String hello(HttpServletRequest request,Model model) {
        request.setAttribute("data", "欢迎使用模版引擎");
        model.addAttribute("data2","欢迎使用模版引擎,使用Model添加");
        return "hello";
    }
}
