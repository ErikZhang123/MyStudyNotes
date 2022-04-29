package Map.HashMap;

import java.util.Properties;

/*
*
* Properties是属性类，其继承Hashtable
* Properties的key和value都是String类型
* 其主要掌握的方法有
* 存：pro.setProperty("a","b");
* 取：String pro.get Property("key");
* */
public class PropertiesDemo {
    public static void main(String[] args) {
        Properties pro = new Properties();
        Integer a =10;
        pro.setProperty(a.toString(),"30");
        System.out.println(pro.get(a.toString()));
    }
}
