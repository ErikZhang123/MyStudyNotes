使用过滤器

和Servlet有点类似
第一步：建立过滤器对象 ， 实现的是Servlet规范中的Filter，以及doFilter方法

第二步：建立配置类文件，并注册过滤器到容器中，这一步和servlet是一样的
 @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean f = new FilterRegistrationBean();
        f.setFilter( new myfilter());
        //配置过滤器地址
        f.addUrlPatterns("/user/*");
        return f;
    }
第三步：修改外部配置文件 application.properties

server.servlet.encoding.enabled=false
#SpringBoot中默认已经配置了CHaracterEncodingFilter，但是他默认是ISO-8859-1
#如果这里为true，他会使用原本默认的过滤器；设置为false，关闭系统中默认的过滤器
#所以也可以在这个配置文件中来设置框架默认的字符集过滤器，也可以用以解决乱码问题


-------------------------
修改默认字符集的第二种方式，直接在application.properties 中进行修改

server.servlet.encoding.enabled=true
server.servlet.encoding.charset=utf-8
server.servlet.encoding.force=true 用force就把请求和response都使用charset的值

也可以指定某一项使用charset值
server.servlet.encoding.force-request=true
server.servlet.encoding.force-response=true