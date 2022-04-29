package servlet09.servlet09.Config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import servlet09.servlet09.MyServlet;

import javax.servlet.ServletRegistration;

@Configuration
public class ServletConfig {

//    方法一：
//    @Bean
////    定义方法，注册Servlet对象
//    public ServletRegistrationBean servletRegistration(){
//        //new ServletRegistrationBean<>(T servlet , String url )
//        /*第一个参数是我们的servlet对象，第二个是url地址*/
//        ServletRegistrationBean bean = new ServletRegistrationBean(
//                new MyServlet(), "/myservlet");
//        return bean;
//    }


//    方法二：
@Bean
public ServletRegistrationBean servletRegistration2(){
    //利用ServletRegistrationBean的无参构造
    ServletRegistrationBean bean = new ServletRegistrationBean();
    bean.setServlet(new MyServlet());
    bean.addUrlMappings("/test","/login"); // 可以指定servlet处理多个uri
//    addUrlMappings实际上就是 url-partten标签
    return bean;
}
}
