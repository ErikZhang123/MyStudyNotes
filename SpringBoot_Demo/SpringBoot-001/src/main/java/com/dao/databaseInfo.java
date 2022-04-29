package com.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("info")
public class databaseInfo {
//    在SrpingConfig中国呢使用@PropertyResourc
//    在具体需要赋值的地方，使用 @Value来获取properties文件中的value

    @Value("${jdbc.url}")
    private String url ;
    @Value("${jdbc.name}")
    private String name;
    @Value("${jdbc.password}")
    private String password;

    @Override
    public String toString() {
        return "databaseInfo{" +
                "url='" + url + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
