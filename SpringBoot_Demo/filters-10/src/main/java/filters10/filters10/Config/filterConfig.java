package filters10.filters10.Config;

import filters10.filters10.myfilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.multipart.support.MultipartFilter;

@Configuration
public class filterConfig {

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean f = new FilterRegistrationBean();
        f.setFilter( new myfilter());
        //配置过滤器地址
        f.addUrlPatterns("/user/*");
        return f;
    }
    //通过字符集过滤器，防止post出乱码,还需要在application.properties 中设置
//    server.servlet.encoding.enabled=false ， 才能起作用/
    //多个过滤器时需要用不同的方法进行多次配置,不能再一个方法中多次配置，否则下面的会覆盖掉上面的配置

    @Bean
    public FilterRegistrationBean filterRegistrationBean2(){
        FilterRegistrationBean encode = new FilterRegistrationBean();

        CharacterEncodingFilter encodingfilter = new CharacterEncodingFilter();
        encodingfilter.setEncoding("utf-8");
        encodingfilter.setForceRequestEncoding(true);
        encodingfilter.setForceResponseEncoding(true);

        encode.setFilter(encodingfilter);
        encode.addUrlPatterns("/*");
        return encode;
    }

}
