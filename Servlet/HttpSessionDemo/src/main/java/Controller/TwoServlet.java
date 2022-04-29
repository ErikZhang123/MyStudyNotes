package Controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Enumeration;

public class TwoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String viplevel = (String) session.getAttribute("zhangsan");
        System.out.println(viplevel);

        //遍历session中的对象
        Enumeration ObjectNames = session.getAttributeNames();
        while(ObjectNames.hasMoreElements()){
            String obj= (String) session.getAttribute((String) Ob
                    jectNames.nextElement());
            System.out.println(obj);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
