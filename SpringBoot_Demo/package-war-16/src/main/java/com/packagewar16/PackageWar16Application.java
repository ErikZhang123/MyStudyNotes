package com.packagewar16;

import com.packagewar16.controller.JspController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class PackageWar16Application extends SpringBootServletInitializer {

    public static void main(String[] args)  {
        SpringApplication.run(PackageWar16Application.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        sources 里面是继承extends SpringBootServletInitializer的类的class文件
        return builder.sources(PackageWar16Application.class);
    }

}
