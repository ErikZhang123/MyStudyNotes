package Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "OEMSServlet", value = "/OEMSServlet")
public class OEMSServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //req获取请求协议包参数,枚举类型
        Enumeration<String> result = req.getParameterNames();

        Map<String,String> parametermap = new HashMap<>();
        //有5个数据(包括了注册/登录参数）
        while(result.hasMoreElements()) {
            String parametername = result.nextElement();
            String parametervalue = req.getParameter(parametername);
            parametermap.put(parametername,parametervalue);
        }
//        StudentInfo studentinfo = new StudentInfo();
        //用set遍历map无法保证输入顺序与输出顺序一致，从而创建类较困难
//        Set<Map.Entry<String,String>> parameterSet = parametermap.entrySet();
//        for (Map.Entry<String,String> node:parameterSet) {
//            System.out.println("参数名="+node.getKey()+" 参数值="+node.getValue());
//        }因此在StudentInfo里面创建了构造函数，直接输入参数map就可以创建对象

        StudentInfo studentInfo=new StudentInfo(parametermap);
        Date starttime = new Date();
        try {
            studentInfo.add(req);
//            studentInfo.add();每次都需要创建Connection，太过繁琐
            /**使用优化后的add方法大大加快了运行速度，使其性能的吞吐量增加，延时降低*/
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Date lasttime = new Date();


        System.out.println("总耗时"+(lasttime.getTime()-starttime.getTime())+"毫秒");

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = resp.getWriter();
        pw.print("<center>注册成功</center>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
