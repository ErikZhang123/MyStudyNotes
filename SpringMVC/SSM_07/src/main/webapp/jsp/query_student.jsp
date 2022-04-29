<%--
  Created by IntelliJ IDEA.
  User: erikzhang
  Date: 2022/2/2
  Time: 7:15 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath=request.getScheme()+"://" + request.getServerName()+":"+request.getServerPort()+
            request.getContextPath()+"/";

%>
<html>
<head>
    <title>浏览学生</title>
    <base href = <%=basePath%> />
    <script type="text/javascript" src="js/jquery-3.5.1.js"></script>
    <script type="text/javascript">
        $(function (){
            //想让网页加载以后直接显示查询数据，不想再点击按钮查询
            //此处的方法在当前页面dom对象加载后执行
            loadStudentInfo();
            // $("#student_info_query").click(function (){
            //     loadStudentInfo();
            // })
        })
        function loadStudentInfo(){
            $.ajax({
                url:"student/select.do",
                type:"get",
                dataType:"json",
                success:function(data){
                    //清除旧数据，防止重复点击的时候累加显示
                    $("#info").html("");
                    // alert("data=" + data) 测试获取对象
                    //循环显示对象
                    $.each(data,function(i,n){
                        $("#info").append("<tr>")
                            .append("<td>"+n.id+"</td>")
                            .append("<td>"+n.name+"</td>")
                            .append("<td>"+n.age+"</td>")
                            .append("</tr>")
                    })
                }
            })
        }
    </script>
</head>
<body>
    <div align="center">
        <table>
            <thead>
                <tr>
                    <td>学号</td>
                    <td>姓名</td>
                    <td>年龄</td>
                </tr>
            </thead>
            <tbody id="info">
            </tbody>
        </table>
        <input type="button" id="student_info_query" value="查询"/>
    </div>
</body>
</html>
