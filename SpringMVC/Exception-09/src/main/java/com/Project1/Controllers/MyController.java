package com.Project1.Controllers;

import com.Project1.Exceptions.AgeException;
import com.Project1.Exceptions.NameException;
import com.Project1.Exceptions.UserException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {


    @RequestMapping(value = "/doException.do")
    public ModelAndView dosome(String name, int age) throws UserException {
        ModelAndView mv = new ModelAndView();
        //这里不再使用try catch处理异常，而是将异常交给框架
        if( ! name.equals("zhangsan"))
            throw new NameException("姓名不正确");
        if(age<18)
            throw new AgeException("未成年不许观看");

        mv.addObject("myname", name);
        mv.addObject("myage", age);

        mv.setViewName("show");
        return mv;
    }
}