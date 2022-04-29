package com.Controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Enumeration;

/*读取【请求头】/【请求体】中的数据
当method=GET时，请求协议包的请求参数放在请求头中
当method=POST时，请求协议包的请求参数放在请求体中
* */
public class SecondServlet extends HttpServlet {
    //POST与GET读取请求参数的代码是相同的
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    1。读取请求参数名,返回一个枚举类型的参数。这个参数包含了参数名与参数值
      Enumeration<String> result = request.getParameterNames();
//    2。遍历参数
      while(result.hasMoreElements()){
          String parameterName = result.nextElement();//获取下一个对象
          String parameterValue = request.getParameter(parameterName);
          //通过参数名获取参数值，类似map结构
          System.out.println("参数名： "+parameterName+"  参数值： "+ parameterValue);
      }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
