package com.Controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/*如何在PrintWriter.print()时处理其中的html命令，如换行<br/>
解决PrintWriter.print()在输出中文时乱码的问题
 * */
public class SecondServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String result = "上海<br/>北京<br/>广州<br/>";
//        PrintWriter out = response.getWriter();
//        out.print(result);
//        //此时如果直接输出，浏览器会将其当作文本文件处理，因为此时的Content-type=text
//        //所以要在申请输出流之前对其Content-type属性进行修改
//        response.setContentType("text/html");
//        PrintWriter out2 = response.getWriter();
//        out2.print(result);
        //但此时浏览器默认的语言库是ISO-8859-1，这是一种东欧语系的语言，因此在解析中文时会出现乱码'？'
        //因此需要手动设置content-type的charset属性为UTF-8;
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out3 = response.getWriter();
        out3.print(result);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
