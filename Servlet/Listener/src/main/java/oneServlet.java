import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "oneServlet", value = "/oneServlet")
public class oneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       ServletContext sc = request.getServletContext();
       sc.setAttribute("zhangsan","vip1");//添加
       sc.setAttribute("zhangsan","vip3");//修改
       sc.removeAttribute("zhangsan");//删除
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
