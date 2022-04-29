package comm.Controller;

import comm.JDBCUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

public class loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("session对象已创建");
        HttpSession session = request.getSession();

        userinfo ui=new userinfo(request);
        System.out.println("userinfo对象已创建");
        boolean flag = ui.search();
        if(flag){
            response.sendRedirect("Querry.html");
        }
        else{
            response.sendRedirect("loginError.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        userinfo ui=new userinfo(request);
        System.out.println("userinfo对象已创建");
        boolean flag = ui.search();
        if(flag){
            response.sendRedirect("Querry.html");
        }
        else{
            response.sendRedirect("loginError.html");
        }
    }
}
