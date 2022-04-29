package com.packagewar16.controller;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JspController  {

    @RequestMapping("/main")
    public String main(Model model){
        model.addAttribute("data","Springboot打包为war文件");
        return "index";
    }

}
