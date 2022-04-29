package Controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "HttpSessionServlet", value = "/HttpSessionServlet")
public class HttpSessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("one已被访问");
        HttpSession session = request.getSession();
        session.setAttribute("zhangsan","VIP9");
    }
}
