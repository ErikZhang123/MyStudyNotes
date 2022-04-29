package Controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Enumeration;
//如何创建cookie对象并将其发送给浏览器
public class CookidServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Enumeration parameter = request.getParameterNames();
        Cookie card = null;
        while(parameter.hasMoreElements()){
            String parametername = parameter.nextElement().toString();
            String paramtervalue = request.getParameter(parametername);
            if(parametername.equals("username")){
                //以键值对方式创建cookie对象
                card = new Cookie(parametername,paramtervalue);
                System.out.println("Cookie已建立");
            }
            response.addCookie(card);//在响应包头中放入cookie发送给浏览器
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
