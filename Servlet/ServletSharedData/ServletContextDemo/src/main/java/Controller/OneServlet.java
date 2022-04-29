package Controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //共享数据ServletContext接口使用
        String username="zhangsan";
        //1、通过request对象获取ServletContext实现类,用一个名为application的变量接受
        ServletContext application=request.getServletContext();
        //2、用application的setAttribute方法，将要共享的数据以键值对的方式存入
        application.setAttribute("username",username);
        //3、接收方：即TwoServlet从application中拿取需要的数据
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
