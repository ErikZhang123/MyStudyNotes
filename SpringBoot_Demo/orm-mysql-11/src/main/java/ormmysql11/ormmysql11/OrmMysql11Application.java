package ormmysql11.ormmysql11;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//启动累使用@MapperScan注解，可以扫描包下的所有mapper.basePackages 是dao所在的包名
//可以用数组的形式，指定多个包， {"b1","b2",...}
@MapperScan(basePackages="ormmysql11.ormmysql11.dao")
public class OrmMysql11Application {

    public static void main(String[] args) {
        SpringApplication.run(OrmMysql11Application.class, args);
    }

}
