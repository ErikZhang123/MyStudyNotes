package com.Controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
/*
* 除了在前端通过form，超链接，location的方式操作浏览器发送请求
* 在后端也可以使用代码来控制浏览器请求
* 比如控制location属性
* */
public class ThirdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "http://www.baidu.com?username=mike";
        //url格式为：地址？参数名=参数值
        //由于是通过修改location，也就是地址栏的内容来发送请求，所以请求方式一定是GET；
        response.sendRedirect(url);
        //可以让浏览器向指定的地址发送请求。
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
