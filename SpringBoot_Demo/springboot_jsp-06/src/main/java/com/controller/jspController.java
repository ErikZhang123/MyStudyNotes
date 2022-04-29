package com.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class jspController {

    @RequestMapping("/dojsp")
    public String doJsp(HttpServletRequest request){
        request.setAttribute("data","SrpingBoot使用了JSP，我是data");
        return "index"; // 返回视图逻辑名称
    }

////两种方法是一样的
//    @RequestMapping("/dojsp")
//    public String doJsp(Model model){ // 其实就是ModelAndView的Model
//        model.addAttribute("data","SrpingBoot使用了JSP，我是data");
//        return "index"; // 返回视图逻辑名称
//    }
}
