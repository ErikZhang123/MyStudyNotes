package com;

import com.config.SpringConfig;
import com.dao.databaseInfo;
import com.vo.Cat;
import com.vo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mytest {

    @Test
    public void test01(){
        //指定配置文件
        String config = "beans.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(config);
        Student s = (Student) context.getBean("myStudent");
        System.out.println("Student :" + s);
    }
    //使用JavaConfig的方式
    @Test
    public void test02(){
        //使用java程序中的注解来确定Configuration文件，括号中的参数指向包含@Configuration和@Bean的类的字节码
        ApplicationContext context = new AnnotationConfigApplicationContext(
                SpringConfig.class);
        //
        Student s =(Student) context.getBean("createStudent");
        System.out.println(s);
    }

    @Test
    public void test03(){
        //使用java程序中的注解来确定Configuration文件，括号中的参数指向包含@Configuration和@Bean的类的字节码
        ApplicationContext context = new AnnotationConfigApplicationContext(
                SpringConfig.class);
        //
        Student s =(Student) context.getBean("lisiStudent");
        System.out.println(s);
    }
//确认ImportResources的作用
    @Test
    public void test04(){
        ApplicationContext context = new AnnotationConfigApplicationContext(
                SpringConfig.class);
        Cat c =(Cat) context.getBean("myCat");
        System.out.println(c);
    }

    @Test
    public void test05(){
        ApplicationContext context = new AnnotationConfigApplicationContext(
                SpringConfig.class);
        databaseInfo d = (databaseInfo) context.getBean("info");
        System.out.println(d);
    }
}
