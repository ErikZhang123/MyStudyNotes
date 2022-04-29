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
<%--    <base href = "http://localhost:8080/Path_08/"/>
        base 用于解决地址不一致的问题  具体请看readme 但是当路径修改的时候不可能每次手动修改
        所以可以通过java代码来获取路径--%>

    <%
        String basePath = request.getScheme()+"://"+
        request.getServerName()+":"+ request.getServerPort() +
        request.getContextPath()+"/"; // 动态获取
    %>
    <base href = "<%=basePath%>"  />
<%--    但是这种方法只在当前页面有效--%>
</head>

<body>
    <form action="${pageContext.request.contextPath}/doForward.do" >
        <input name="name" type="text">
        <input name="age" type="text">
        <input type = "submit" value = "doForward">
    </form>
    <br>
    <form action="${pageContext.request.contextPath}/doRedirect.do" >
        <input name="name" type="text">
        <input name="age" type="text">
        <input type = "submit" value = "doRedirect">
    </form>


    <img src = "images/p1.jpg" alt="这里有一个图片，但没法显示">
</body>

</html>
