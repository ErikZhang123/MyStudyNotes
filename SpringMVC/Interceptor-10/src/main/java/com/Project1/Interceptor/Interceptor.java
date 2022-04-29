package com.Project1.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class Interceptor implements HandlerInterceptor {
//需要用哪个，重写哪个就可以，不一定要全部重写。新版本中已经有default的方法了

    /**preHandler 预处理方法 很重要！ 控制请求是否被处理，是项目的入口
     * 参数： Object handler 是被拦截的Controller对象
     * 返回值是一个boolean
 *      特点：  1。在Controller的处理方法之前先执行的方法，用户请求首先到达该方法
     *          2。在这个方法中可以获得请求的信息，验证是否符合要求。
     *              如果验证失败，可以截断请求，不让请求被处理。返回false，如果没有处理，会跳到一个空白页面。
     *                                                  并且后面两个方法都不会执行，处理器方法也不会执行
     *              如果验证成功，则可以处理，放行请求。返回true
     *
     * **/
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("拦截器preHandler正在作用");
//        return true;
        //如果是false， 可以给浏览器一个返回结果，这里使用forward让服务器转发到视图以后返回给浏览器
//        request.getRequestDispatcher("WEB-INF/views/tips.jsp").forward(request,response);
//        return false;
            return true;
    }


    /**后处理方法，在Controller方法执行以后执行。
     * ModelAndView modelAndView ： Controller方法执行之后返回的mv
     * Object handler ： Controller的hanlder对象
     * 特点：
     *  在处理器方法执行之后执行
     *  能对处理器方法的返回值ModelAndView 修改数据和视图，可以对Controller的结果进行修正
     * */
    private long start;
    private long end;
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        start = System.currentTimeMillis();
        //对原来的执行结果进行调整： 即修改数据或视图
        if(modelAndView!=null) {
            modelAndView.addObject("mydate",new Date()) ;
            modelAndView.setViewName("other");
        }

        System.out.println("PostHandler is executed！");
    }
    /**最后执行的方法：
     *  Object handler
     *  Exception ex：程序执行中发生的异常
     *  特点： 在请求处理完成后执行： 即当视图处理完成以后（对视图执行了forward操作），认为请求处理完成。
*       2 . 一般做资源回收工作，将一些处理过程中创建的对象进行删除，或者对异常做记录.
     *              如果出现异常，会返回400
     *
     * */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        end = System.currentTimeMillis();

        System.out.println("AfterCompetion is executed！ The time used is :"+(end-start) + " ms");
    }

}
