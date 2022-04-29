
拦截器的使用：
1。需要创建自己的拦截器类，并实现HandlerInterceptor接口。
    其中的三个方法有default，重写需要用到的方法即可
2。创建一个配置类，实现WebMvcConfigurer接口，其中有addInterceptor方法

//添加拦截器对象，并注入到容器中
@Override
public void addInterceptors(InterceptorRegistry registry) {
    //创建拦截器对象：
    HandlerInterceptor interceptor = new MyInterceptor();
    // 让拦截器拦截哪些网址 , 可以使用list数组，一次拦截多个uri地址
//        registry.addInterceptor().addPathPatterns();
//        registry.addInterceptor().excludePathPatterns(); // 让拦截器不拦截哪些网址
    String[] path = {"/user/**"};
    String[] exclude = {"/user/login"};
    registry.addInterceptor(interceptor)
            .addPathPatterns(path)
            .excludePathPatterns(exclude);
}

注意，要给这个配置文件加上@Configuration注解，拦截器才可以起作用