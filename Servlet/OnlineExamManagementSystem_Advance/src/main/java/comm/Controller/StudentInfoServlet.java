package comm.Controller;

import comm.JDBCUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "StudentInfoServlet", value = "/StudentInfoServlet")
public class StudentInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection c = JDBCUtil.getConnection(request);
        String sql = "select * from STUDENTINFO";
        try {
            PreparedStatement ps = JDBCUtil.getPreparedStatement(c,sql);
            ResultSet rs = JDBCUtil.getResultSet(ps);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("这是学生信息");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
