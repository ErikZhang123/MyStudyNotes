相对路径和绝对路径问题
也就是在jsp发送请求的时候，action最前面是否需要 / 的问题

首先。 jsp, html 中使用的地址都是前段页面的地址，都是相对地址。

1. 绝对地址： 带有协议名称
2. 相对地址， 没有协议开头， 比如 user/some.do   /suer/some.do
    相对地址不能独立使用，需要有一个参考地址+相对地址才能使用资源

3. 参考地址如何处理
    1） 访问地址不加 /   ： 注意，因为会受前面路径变化的影响，所以有可能会出错
    比如在访问了 some.do 以后 访问地址变为https://localhost:8080/Path_06/user/some.do
    再回到index.jsp再点击的时候会变为https://localhost:8080/Path_06/user/some.do/some.do
    解决方法：
    1。加 ${pageContext.request.contextPath}转为加 / 的方式
    2。在页面中加入base标签，表示当前页面中访问的基地址： 所有 无 '/' 开头的地址都是以base标签的地址为参考地址
    也就是说都是用base + 访问地址 来形成行的请求地址
    base中都是带协议的绝对地址

    比如 ： https://localhost:8080/Path_06/index.jsp
            绝对路径： https://localhost:8080/Path_06/
            资源：index.jsp
    当请求地址没有斜杠开头的时候，访问地址会变为当前资源的绝对路径 + 发送请求的链接地址
        比如此时发送请求 user/some.do：
        访问地址变为https://localhost:8080/Path_06/user/some.do

    2） 访问地址加 /

         比如此时发送请求 /user/some.do
         访问地址变为https://localhost:8080/user/some.do
    如果访问地址之前加了 /
        访问地址会变为： https://localhost:8080 + 访问地址
        所以在访问的时候需要用 <form action="/Path_06/user/some.do">
        但这样前缀就变固定了，不太灵活
        所以用EL表达式 ${pageContext.request.contextPath} 会将其前面的路径加上
         <form action="${pageContext.request.contextPath}/user/some.do">

