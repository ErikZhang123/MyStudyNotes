<%--
  Created by IntelliJ IDEA.
  User: erikzhang
  Date: 2022/1/30
  Time: 4:49 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    String basePath=request.getScheme()+"://" + request.getServerName()+":"+request.getServerPort()+
            request.getContextPath()+"/";

%>
<head>
    <title>regist</title>
    <base href="<%=basePath%>">
</head>

<body>
<div align="center">
    <form action="student/add.do">
        <table>
            <tr>
                <td>姓名：</td>
                <td> <input name="name" type="text"> </td>

            </tr>
            <tr>
                <td>年龄：</td>
                <td> <input name="age" type="text"> </td>
            </tr>
            <tr>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td> <input value="注册" type="submit"> </td>

            </tr>

        </table>

    </form>
</div>
</body>
</html>
