package com.Project1.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import vo.Student;

@Controller
public class MyController {
    //RequestMapping默认是ISO-8859-1， 所以中文会乱码，要使用produces来指定contentType
    @RequestMapping(value = "return-String.do", produces = "text/plain;charset=utf-8")
    //1 、 如果返回String，仅仅转发到视图,但需要配置视图解析器
    public String doReturnView(){
        //return的值可以是视图的逻辑名称，也可以是视图的具体路径、
        //其中也可以手工将对象添加到request作用域

//        return "show"; // 逻辑视图名
        return "/WEB-INF/views/show.jsp"; // 返回路径也可以，但此时不可以配置视图解析器。会拼接地址

    }
    /**框架通过是否有@ResponseBody注解 来判断返回String的时候返回的是数据还是视图
     * @ResponseBody 表示返回的String是一个字符串数据，如果没有就说嘛是视图*/


    //2 返回void，处理AJAX，具体请看笔记，不太常用

    //3 返回Object类以响应AJAX请求，Object指所有对象
    /***********    转为Jason对象的方法实现！！！！          ***********/
        // 将对象转化为jason对象，所以要添加jackson依赖
        // 1 。 在 springmvc配置文件中加入一个标签： <mvc:annotation-driven> 注解驱动
        // 2。 在处理器方法上加入@ResponseBody 注解. 其支持原理详见springmvc笔记21页
        // 返回对象就是返回数据， 与视图无关，即Model部分
    @ResponseBody
    public Object doReturnObject(){
        Student s = new Student();
        s.setAge(18);
        s.setName("zhangsan");
        return s;
    }

}
