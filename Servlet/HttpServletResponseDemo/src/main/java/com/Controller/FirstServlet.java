package com.Controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * HttpServletResponse接口实现类由http服务器提供
 * 用doGet/doPost将执行结果以二进制写入响应体，交给浏览器
 * 其实现类被称为响应对象
 *
 * */
public class FirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String result = "helloworld";
        int money = 50;
        PrintWriter out = response.getWriter();
        out.write(result);
        out.write(money);
        /**PrintWriter.write()方法只能输出字符，字符串，ASCII码，如果直接在括号内填入数字类型，会被认为是ASCII码
         * 因此开发中不用write()方法，而改用
         * PrintWriter.print()方法*/
        out.print("money应该是50："+money);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
