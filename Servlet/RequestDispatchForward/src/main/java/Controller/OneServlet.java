package Controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "OneServlet", value = "/OneServlet")
public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("this is first in RequestForward!");
        //向tomcat申请一个requestdispatcher对象，告诉tomcat需要用到哪个servlet的地址
        RequestDispatcher report = request.getRequestDispatcher("/two");
        //通过foward方法让接下来的servlet继承当前的request和response对象
        report.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
