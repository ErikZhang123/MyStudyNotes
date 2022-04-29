
@SpringBootApplication:  是由多个注解组成的
    1。 @SpringBootConfiguration：由 @Configuration 复合
        与Configuration的作用一致，赋予当前类 配置文件的功能 ，因此可以在Application中使用@Bean注入对象
    2。 @EnableAutoConfiguration ：
        启用自动配置，将java对象配置好后注入到Spring容器
    3。 @ComponentScan : 找到注解，创建对象。在001中有使用举例
        因为默认扫描的包是： @ComponentScan所在类的 当前包，以及包中的所有子包，因此
        注意：！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
        Application 类 必须与 所有需要用到的 controller，dao等类的'主包'在同一文件夹中，否则会产生404
        否则需要特别声明
        @SpringBootApplication(scanBasePackages = ) 或者@SpringBootApplication(scanBasePackageClasses = )
        声明扫描的base包或类
SpringBoot 中通过主启动类 Application 启动服务
    在主启动类的主方法中使用 SpringApplication.run(Application.class , args)；
    这个args指的是main中的传入指令 args


配置文件的使用：
名字：必须是application
扩展名： properties (k=v)格式数据  或者 yml (k:v) 格式
因此可以是 application.properties 或者 application.yml，但是默认情况下使用properties。
即如果两种格式文件同时出现，会优先使用properties

使用：可以通过server. 使用各种方法配置
比如： 在properties格式时
#设置端口号
server.port=8082

#设置访问的上下文路径 contextpath
server.servlet.context-path=/myboot
#让controller访问路径变为： /myboot/hello

yml文件格式下：
注意： 每个冒号之后一定要有一个空格符
server:
    port: 8083
    servlet:
        context-path: /myboot2


