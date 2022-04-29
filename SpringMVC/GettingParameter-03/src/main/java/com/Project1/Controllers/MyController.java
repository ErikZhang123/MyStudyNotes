package com.Project1.Controllers;


import vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MyController {

/*接收用户提交的参数有两种方法**/

    /*1、逐个接收请求参数： 处理器方法的形参名要和请求中参数名一致，同名的请求参数赋给同名的形参
    *   框架接收参数的过程：
    *   1。使用request对象接收参数，框架会都用String来接收参数
    *   String strName = request.getParameter(name);
    *   String strAge = request.getParameter(age);
    *   2. SpringMVC 通过中央调度器DispatherServlet 调用dosome1
    *       调用方法的时候按照对应参数的名称赋给对应形参
    *          框架提供类型转换的功能，自动转换为对应参数名称的参数类型。
    *          如果无法转换类型，会报错400。 表示客户端错误，在提交请求参数的过程中发生问题。
    *          在后端代码中会抛出warning，但是不会在后端报错。
    * */
    @RequestMapping("/some1.do")
    public ModelAndView dosome1(String name, int age){
            // 框架会为参数赋值，在处理过程中可以直接使用
        ModelAndView mv = new ModelAndView();
        mv.addObject("name",name);
        mv.addObject("age",age);
        mv.setViewName("show");
        return mv;
    }
    //如果请求中的变量名和处理方法的形参名不一样，则无法使用第一种方法接受
    /*方法二：
    * 使用@RequestParam 解决逐个接收时请求变量名和处理方法形参名不一样的问题
    *          属性： value 请求中参数的名称
    *           required 是一个boolean ， 默认为True。True表示请求中必须包含此参数,如果不包含，浏览器报错400
    *           可以使用这个特性来加强安全性
    * 使用方法：在处理方法的每个形参定义之前使用
    * */
    @RequestMapping("/some2.do")
    // 表示请求中参数名为name的值会赋给name2；
    public ModelAndView dosome2(@RequestParam(value="name",required = false) String name2,
                                @RequestParam(value="age") int age2){
        // 框架会为参数赋值，在处理过程中可以直接使用
        ModelAndView mv = new ModelAndView();
        mv.addObject("name",name2);
        mv.addObject("age",age2);
        mv.setViewName("show");
        return mv;
    }
    /*
    方法三： 使用对象接收； 适合接收多个参数，只要保证 请求参数名 和对象属性同名就可以
    形参数也可以有多个对象，同名也不会互相干扰
            框架会调用 set() 方法为对应的参数赋值
            注意：不能使用RequestParam，没有意义
    * */

    @RequestMapping("/some3.do")
    public ModelAndView dosome3(Student student){
        String name = student.getName();
        int age = student.getAge();
        ModelAndView mv = new ModelAndView();
        mv.addObject("name",name);
        mv.addObject("age",age);
        mv.setViewName("show");
        return mv;
    }
}
