<%--
  Created by IntelliJ IDEA.
  User: erikzhang
  Date: 2022/1/30
  Time: 3:40 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    String basePath=request.getScheme()+"://" + request.getServerName()+":"+request.getServerPort()+
            request.getContextPath()+"/";

%>
<head>
    <title>index</title>
    <base href="<%=basePath%>">
</head>
<body>
    <div align="center">
        <img src="images/ssm.jpg"/>
        <table>
            <tr>
                <td> <a href="jsp/register_student.jsp">注册学生</a> </td> // 点击以后跳到注册页面
            </tr>
<%--浏览学生使用AJAX请求处理--%>
            <tr>
                <td> <a href="jsp/query_student.jsp">浏览学生</a></td> // 点击以后跳到浏览页面
            </tr>
        </table>

    </div>

</body>
</html>
