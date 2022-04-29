package com.config;


import com.vo.Student;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Configuration : 当前类作为配置文件使用，SpringBoot使用纯java语言来对框架配置，不用书写复杂的xml文件。
 * 修饰的类 作用相当于beans.xml。配置文件可以有多个.
 * @ImportResource() : 可以将写在xml配置文件中bean对象也注入到容器中
 *              属性： value = "classpath: 文件名" ； 其中classpath：用于获取类路径下的文件
 *              可以使用数组的方式指定多个配置文件：
 *              {"classpath:applicationContext1.xml","classpath:applicationContext2.xml",...}
 * @PropertySource( value = "classpath:") 仅仅告诉框架读取指定文件
 * @ComponentScan(value = "具体类名" 或者 basePackages = "指定包" 包下的所有类都会被读取他们的注解)
 * 其实就是注解扫描器
 * */
@Configuration
@ImportResource(value = "classpath:applicationContext.xml")
@PropertySource( value = "classpath:config.properties")
@ComponentScan(basePackages = "com.dao")
public class SpringConfig {

    /**创建方法，返回值是对象
     *  在方法的上面加入@Bean
     *  此时，方法的返回值对象会被注入到容器中
     * @Bean 相当于xml中的标签，将这个返回的对象放到容器中
     * 如果不指定对象名称，默认的对象id是方法名
     * */
    @Bean
    public Student createStudent(){
        Student s =  new Student();
        s.setName("李四");
        s.setAge(37);
        s.setGender("男");
        return s;
    }

    //也可以使用name属性指定返回的对象在容器中的名称，即bean的id，使用哪个id可以获得这个对象
//    就是 <bean id = "?"  >
    @Bean(name = "lisiStudent")
    public Student createStudent2(){
        Student s =  new Student();
        s.setName("李四");
        s.setAge(37);
        s.setGender("男");
        return s;
    }
}
