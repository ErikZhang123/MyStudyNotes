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
    <title>拦截器</title>
</head>
    <h3> 拦截器</h3>
<body>
   <p>全局异常处理</p>
    <form action="doInterceptor.do">
        你的名字：<input name="name" type="text"/>
        <br/>
        你的年龄：<input name="age" type="text"/>
        <input type="submit" value="提交"/>
    </form>
</body>

</html>
