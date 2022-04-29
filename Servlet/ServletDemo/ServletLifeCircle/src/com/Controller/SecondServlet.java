package com.Controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SecondServlet", value = "/SecondServlet")
public class SecondServlet extends HttpServlet {
    public SecondServlet(){
        System.out.println("SecondServlet对象已创建");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("SS的doget方法已调用");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
