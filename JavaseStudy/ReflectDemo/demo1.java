package JavaseStudy.ReflectDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
/**
*
*通过反射机制实例化对象
*
* 1、Class.newInstance();  该方法已经过时
*   该方法会且仅会调用自建类的无参构造方法
*   若类中只存在有参构造而没有无参构造时会报错
*
* 使用反射机制实例化对象的原因是：
* 1、较灵活 在不改变java代码的情况下通过改变配置文件可以使其创建不同类型的java对象
* 符合OCP 即开闭原则：对扩展开放，对修改关闭
*/
public class demo1 {
    public static void main(String[] args) {
//        1、IO读取配置文件
        try {
            FileInputStream fis = new FileInputStream("D:\\IDEA\\src\\JavaseStudy\\ReflectDemo\\Classinfo.properties");
//        2、创建属性类对象Map
            Properties pro = new Properties();
//        3、加载I/O流
            pro.load(fis);
//        4、关闭流
            fis.close();
//        5、通过key获取value
            String className = pro.getProperty("className");
//        6、通过反射机制获取Class，通过Class实例化对象；
//            Class c = Class.forName("JavaseStudy.ReflectDemo.User");
            Class c = Class.forName(className);
            Object obj = c.newInstance();
//            直接输出对象类型+地址值，更改配置文件中的对象类型可以变更创建对象的类型。
            System.out.println(obj);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

}
