<%--
  Created by IntelliJ IDEA.
  User: erikzhang
  Date: 2022/1/25
  Time: 6:15 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3> <a href="test/some.do" >准备发送get请求 </a> </h3>
<h3> <a href="test/some2.do" >准备发送 some2.do请求, 在浏览器地址中手动添加参数 </a> </h3>
<form action = "test/other.do" method = "post">
    <input type = "submit" value = "提交post请求">
</form>

<%--向other.do 提交get方式的请求被拒绝，报错405--%>
<form action = "test/other.do" method ="get">
    <input type = "submit" value = "提交get请求">
</form>
</body>
</html>
