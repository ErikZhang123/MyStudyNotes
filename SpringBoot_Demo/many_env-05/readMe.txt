一、多环境配置：
    如何在 开发/测试/用户使用环境中切换
    可以在resources中创建多个环境文件
    格式： application-环境名称.properties 或 .yml 格式
eg: application-dev.properties

因为默认读取的是 application.properties / .yml 文件，所以在这个文件中指定去读哪一个文件
使用spring.profiles.active=dev ， 此时springboot会去找 application+"-"+dev 这个配置文件

二、从配置文件中获取数据
1。 在java类中可以使用@Value("${key}") 从配置文件中获取数据

2。 可以通过配置文件为java对象的属性赋值，这样有很多值的时候不用一个个赋值
@Component
@ConfigurationProperties(prefix = "school")，前缀的默认是空
//在配置文件中找到要获取的信息的前缀，然后框架会将 前缀.信息名 的值拿出来，和对象中的属性名进行比较，给相同的赋值
public class School {
    private String name;
    private String website;

    }

3。 通过加入依赖， 处理 ConfigurationProperties有关的元数据
     <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-configuration-processor</artifactId>
            <optional> true</optional>
        </dependency>