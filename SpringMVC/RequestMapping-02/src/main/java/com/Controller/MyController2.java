package com.Controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/test")//在所有处理方法的指定url之前加上一个公共前缀
public class MyController2 {

    /** @RequestMapping 的 method属性可以指定请求的类型，他的值为
     *                          RequestMethod.GET 或RequestMethod.POST 等
     * */
    @RequestMapping(value = "/some.do", method = RequestMethod.GET)
    public ModelAndView dosome(){
       
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","草泥马");
        mv.setViewName("result");
        return mv;
    }


    @RequestMapping(value = "/other.do", method = RequestMethod.POST)
    public ModelAndView doother(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","POOOOOOOOOOOOOST");
        mv.setViewName("result");
        return mv;
    }
    /**处理器方法通过 HttpSession , HttpServletRequest ， HttpServletResponse
     * 对象来获取用户的请求参数 */
    @RequestMapping( "/some2.do")
    public ModelAndView dosome2(HttpSession session, HttpServletRequest request ,
                                HttpServletResponse response){
        ModelAndView mv = new ModelAndView();
        //使用时直接调用对象方法即可，对象会被框架赋值
        mv.addObject("msg",request.getParameter("name"));
        mv.setViewName("result");
        return mv;
    }
}
