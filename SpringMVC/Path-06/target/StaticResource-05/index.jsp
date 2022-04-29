<%--
  Created by IntelliJ IDEA.
  User: erikzhang
  Date: 2022/1/29
  Time: 7:27 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/some.do" >
        <input name="name" type="text">
        <input name="age" type="text">
        <input type = "submit" value = "submit">
    </form>

    <img src = "images/p1.jpg" alt="这里有一个图片，但没法显示">
</body>

</html>
