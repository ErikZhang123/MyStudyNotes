package com.Project1.Handler;

import com.Project1.Exceptions.AgeException;
import com.Project1.Exceptions.NameException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import sun.util.resources.es.CurrencyNames_es_EC;

/**
 * 本意是：控制器增强
 * @ControllerAdvice: 为控制器类增加功能 --- 异常处理
 *  特点： 必须让框架知道这个注解所在的包名，需要在springmvc中用组件扫描器配置
 * **/

@ControllerAdvice
public class ExceptionProcessor {
    //定义方法，处理异常
    /**
     * 处理异常的方法和控制器方法的定义方式一样
     * 形参： Exception， 表示Controller中抛出的异常对象
     * @ExceptionHandler(异常的class文件)： 表示发生此类异常时由本方法处理
     * **/
    @ExceptionHandler(value  = NameException.class)
    public ModelAndView nameHandler(Exception exception){
        //处理NameException异常
        /**
         *  1。记录异常到日志文件，或者数据库： 包括记录日志发生时间，哪个方法发生的，异常错误的内容。
         *  2。发送通知， 把异常信息发送给相关人员
         *  3。给用户友好提示
         * **/
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","你是张三吗？你不是你叫个der");
        mv.addObject("ex",exception);
        mv.setViewName("nameError");
        return mv;
    }
    @ExceptionHandler(value = AgeException.class)
    public ModelAndView AgeHandler(Exception e){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","未成年你看个der");
        mv.addObject("ex",e);
        mv.setViewName("ageError");
        return mv;
    }
    //处理其他未知的异常，在我们设计的时候没有想到的异常
    //不对其value进行赋值，就可以对所有没有指定的异常进行处理
    @ExceptionHandler
    public ModelAndView OhterHandler(Exception e){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","你把我弄坏了啦");
        mv.addObject("ex",e);
        mv.setViewName("ageError");
        return mv;
    }
}
