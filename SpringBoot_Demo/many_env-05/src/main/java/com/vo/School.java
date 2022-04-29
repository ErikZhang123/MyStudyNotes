package com.vo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "school")
//指定在配置文件中要获取的信息的前缀，然后框架会将 前缀.信息名 拿出来，和对象中的属性名进行比较，给相同的赋值
public class School {

    private String name;
    private String website;

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", website='" + website + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
