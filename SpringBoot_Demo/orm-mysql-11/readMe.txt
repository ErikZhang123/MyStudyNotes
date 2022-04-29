
1. 在建立的时候需要加入Mybatis框架，以及MySQL Driver驱动
    mybatis-spring 依赖，来继承mybatis
2. 创建dao接口和mapper文件, 创建方法和Mybatis一样
    注意：mapper文件要和接口文件名字一致。
    方法1)  接口上添加@Mapper注解
    方法2)  也可以使用@MapperScan，放在启动类之上
            @SpringBootApplication
            启动累使用@MapperScan注解，可以扫描包下的所有mapper.basePackages 是dao所在的包名
            可以用数组的形式，指定多个包， {"b1","b2",...}
            @MapperScan(basePackages="ormmysql11.ormmysql11.dao")
            public class OrmMysql11Application {
                public static void main(String[] args) {
                    SpringApplication.run(OrmMysql11Application.class, args);
                }
            }
    方法3)  如果dao和mapper文件不在一个包下
            可以将mapper文件放到resources目录下，这样将java文件和mapper文件分离。更清晰
            在application.properties 文件中指定mapper位置
            是在resources 目录下mapper文件夹中所有的xml文件
            （有时候在target目录下会丢失配置文件，在maven中配置resources读取所有文件）
            <resources>
                <resource>
                    <directory>src/main/resources</directory>
                    <includes>
                        <include>**/*.*</include>
                    </includes>
                </resource>
            </resources>
            mybatis.mapper-locations=classpath:mapper/*.xml

3。在pom文件中配置resources，读取所有xml文件，或者使用上面方法三中的配置
    <resources>
                <resource>
                    <directory>src/main/java</directory>
                    <includes>
                        <include>**/*.xml</include>
                    </includes>
                </resource>
    </resources>
4。在application.properties 中配置数据库
    #配置数据库
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.url=jdbc:mysql://localhost:3306/STUDENTINFO
    spring.datasource.username=root
    spring.datasource.password=12345678

5. 设置开启日志,有很多日志的格式，选取需要的
    在application.properties下
    mybatis.configuration.log-impl=org.apache.ibatis.logging.stdout.StdOutImpl

