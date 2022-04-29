package filters10.filters10.Config;

import filters10.filters10.servlet.myservlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.ServletRegistration;

@Configuration
public class servletConfig {

    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        ServletRegistrationBean s = new ServletRegistrationBean<>();
        s.setServlet(new myservlet());
        s.addUrlMappings("/myservlet");
        return s;
    }


}
