package Controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class getCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//       request.getCookies返回一个cookie数组
        Cookie cookieArray[]=request.getCookies();
//        循环遍历数组中的元素
        String key=null;
        String value=null;
        for(Cookie cookie:cookieArray){
            if(cookie.getName().equals("username")){
//              在获取到所需要的信息以后，通过数据库找寻该用户匹配的信息，然后为其提供更加个性化的服务
//              此处以只获取用户名为例
                 key=cookie.getName();
                 value=cookie.getValue();
            }

        }
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("<center>欢迎回家"+value+"</center>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
