package com.Project1.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
//所有 Controller对象都存在springmvc容器中
@Controller("mycontroller")
//叫做控制器 也叫做后端控制器 back controller
public class MyController {
//    处理用户提交的请求，使用方法来处理，可以自定义返回值和参数。
    /**
     * 现在我们想使用dosome来处理 some.do请求
     * @RequestMapping : 请求映射，作用是把一个请求地址和一个方法绑定在一起
     *          属性： value： 表示请求的url地址，value必须唯一，不能重复。
     *                      在使用时以 " / " 开头
     *  使用位置：  1。在方法上面
     *              2。 在类上面
*        使用RequestMapping修饰的方法叫做：处理器方法或控制器方法，类似于servlet中的doPost或者doGet
     * */
    // value是一个数组，可以写多个值 { 1,2,3,4,5} 的格式
    @RequestMapping(value = "/some.do")
    public ModelAndView dosome(){
        //准备处理请求，这里假设service已经完成，准备返回了.
        /**
         * ModelAndView: 包含两个部分
         *      1。Model： 数据，请求完成以后要显示给用户的数据
         *      2。View： 视图，比如jsp等
     *     此处假设已经有数据和视图了
         * */
        ModelAndView mv = new ModelAndView();
        //注意，此处的value是Object类，所以可以是任意类型
        mv.addObject("msg","你好大傻逼");
        mv.addObject("fun","你用过我啦，好耶");
        //添加的数据最后把数据放入request作用域

        //框架对视图执行的是forward操作，相当于 request.getRequestDispather("转发的地址").forward(...)
//      mv.setViewName("/show.jsp"); 当show放在webapp下的时候不安全，所以一般放在WEB_INF下

//        mv.setViewName("/WEB-INF/view/show.jsp"); // 可以在controller里修改路径，
        // 也可以在mvc.xml里用视图解析器来设置视图文件路径, 此时已经设置好了视图解析器的前缀后缀
        mv.setViewName("show");

        //返回mv，mv在后期对数据和视图做r
        // equest和forward操作，并不是现在做。
        return mv;
    }
}
