<%--
  Created by IntelliJ IDEA.
  User: erikzhang
  Date: 2022/2/2
  Time: 8:07 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>
        hello
    </title>
</head>
<body>
<h3> 这是一个views2里面的视图</h3>
<%--直接使用ER表达式无法取到值，因为此时这两个参数是作为当前页面的请求参数被发过来的
所以在请求参数依然在第一次发送的request作用域中，并没有加入到第二次的request中。--%>
<%--<h3>你的名字是 ： ${name}</h3>--%>
<%--<h3>你的年龄是 ： ${age}</h3>--%>
<h3>你的名字是 ： ${param.name}</h3>
<h3>你的年龄是 ： ${param.age}</h3>
<%--param.name 就可以取到，相当于 request.getParameter("name) --%>
</body>
</html>
