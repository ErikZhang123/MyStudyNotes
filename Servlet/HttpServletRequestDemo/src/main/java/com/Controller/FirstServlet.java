package com.Controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
/**
 * HttpServletRequest接口的实现类被称为请求对象
 * 请求对象由Http服务器进行创建
 * 通过doGet/doPost方法对于http请求协议包中的内容进行读取
 */

@WebServlet(name = "FirstServlet", value = "/FirstServlet")
public class FirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    /*1、读取请求行中的内容(url、method、uri
        uri是资源文件精准定位地址，在请求行中并没有该属性，其本质上是截取了一段url的字符
        其格式为："/网站名/资源文件名"
        uri用于让HTTP服务器对被访问的文件进行定位
     * */
     String url = request.getRequestURL().toString();
     String method = request.getMethod();
     String uri = request.getRequestURI();

        System.out.println(url);//http://localhost:8080/HttpServletRequestDemo_war/fs
        System.out.println(method);//GET
        System.out.println(uri);//  "/HttpServletRequestDemo_war/fs"
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
