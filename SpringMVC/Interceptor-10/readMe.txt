拦截器：
需要实现 HandlerInterceptor接口。其功能类似于过滤器filter。但是过滤器是用于过滤参数
拦截器用于拦截请求，对请求做判断处理

拦截器是全局的，可以对多个COntroller做拦截
    一个项目中可以有0个或多个拦截器，同时工作拦截用户请求。
    拦截器常用于：用户登录处理，权限检查，记录日志

使用步骤：
    1。定义类实现HandlerInterceptor接口,并实现拦截器的三个方法
    2。在springmvc配置文件中声明拦截器，并声明拦截的地址

拦截器执行的时间：
    1。在Controller中的方法执行之前，即 请求处理之前进行拦截
    2。在Controller方法执行之后也会执行拦截器
    3。在请求处理完成以后也会执行

拦截器用的依然是 AOP的思想   ： 环绕在业务方法前后的一系列逻辑方法
浏览器->preHandler->Controller-> postHandler->  返回用户浏览器 ->CompletionHandler

当存在多个拦截器对同一个请求都起作用的时候，他们的执行顺序 == 在springmvc中拦截器对象声明的顺序
所以，顺序优先的拦截器，他的范围往往更广。
但是当执行posthandler和aftercompletion的时候，顺序会反过来
！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
1。如果拦截器全部通过
请求 -> 拦截器1pre -> 拦截器2pre ->Controller -> 拦截器2post -> 拦截器1post -> 视图解析器 ->拦截器2_AfterCompletion
-> 拦截器1_AfterCompletion

2。注意！！！ 如果当某一个preHandler出现false，那么后面的post不会执行
但是 "前面" 所有返回true的拦截器所对应的AfterCompletion方法一定会执行，类似于if——else的关系