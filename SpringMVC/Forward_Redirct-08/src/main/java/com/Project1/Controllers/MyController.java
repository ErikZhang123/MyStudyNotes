package com.Project1.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController  {

/**      处理器方法返回ModelAndView，实现转发forward
        语法： setViewName("forward:视图文件完整路径")
        forward特点： 使用该关键字的时候，视图解析器会失效
**/
    @RequestMapping(value = "/doForward.do" )
    public ModelAndView dosome(String name , int age){
        ModelAndView mv = new ModelAndView();
        mv.addObject("name",name);
        mv.addObject("age",age);
        //视图解析器失效，需要完整地址才能访问
        //加了forward这种方式叫显示转发。一般运用： 如果视图不在视图解析器所标注的目录下的时候使用
        //可以转发到任意指定的视图
//        mv.setViewName("show"); 此时show被视图解析器所标注，可以访问到view下的show.jsp
//        mv.setViewNmae("hello"); 是不行的
        //但是如果此时我想访问views2下的hello.jsp， 就需要通过转发的方式
        mv.setViewName("forward:/WEB-INF/views2/hello.jsp");
        return mv;
    }

/** 处理器方法返回ModelAndView，实现重定向redirect
 * 语法： setViewName("redirect:视图文件完整路径")
 *        redirect特点： 使用该关键字的时候，视图解析器会失效
 *                      注意，因为是通过用户浏览器发送的请求，因此无法访问到WEB-INF下的视图
*     框架提供了一个额外功能：  Model中的简单类型数据会转为String，作为重定向的页面的"请求参数""
 *      目的是让doRedirect 与 Redirect_show之间传递请求参数。
 *      而不是作为response返回给页面： 因此在这里加入的参数返回给页面之后，会作为重定向的请求参数发送给
 *      之后的页面，而不会改变request作用域，因此如果在页面中直接使用ER表达式获取变量，则获取不到
 *      在目标页面中需使用参数集合对象 ${param} 获取请求参数值
 *
 * */
    @RequestMapping(value = "/doRedirect.do" )
    public ModelAndView doRedirect(String name , int age){
        ModelAndView mv = new ModelAndView();
        mv.addObject("name",name);
        mv.addObject("age",age);
        //视图解析器失效，需要完整地址才能访问

        mv.setViewName("redirect:Redirect_show.jsp");
//        mv.setViewName("redirect:/WEB-INF/views2/hello.jsp"); 不可以，用户浏览器请求无法访问WEB-INF的视图
        return mv;

    }
}
