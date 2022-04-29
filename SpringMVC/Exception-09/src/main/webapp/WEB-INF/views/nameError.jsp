<%--
  Created by IntelliJ IDEA.
  User: erikzhang
  Date: 2022/2/2
  Time: 9:52 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>NameError</title>
</head>
<body>
        <h3>NameError</h3><br/>
        <h3> ${msg}</h3><br/>
<%--        获取异常对象的提示信息--%>
        Detail: <h3>${ex.message}</h3>
</body>
</html>
