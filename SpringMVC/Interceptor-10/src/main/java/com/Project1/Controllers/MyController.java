package com.Project1.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {


    @RequestMapping(value = "/doInterceptor.do")
    public ModelAndView dosome(String name, int age) {
        System.out.println("======================MyController 正在执行===================");
        ModelAndView mv = new ModelAndView();
        mv.addObject("name", name);
        mv.addObject("age", age);
        mv.setViewName("show");
        return mv;
    }

}