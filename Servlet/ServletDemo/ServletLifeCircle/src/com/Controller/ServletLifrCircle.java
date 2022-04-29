package com.Controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ServletLifrCircle extends HttpServlet {
    public ServletLifrCircle(){
        System.out.println("ServletLiftCircle对象已创建");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("SLC的doget方法已调用");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
