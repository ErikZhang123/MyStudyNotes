package Annotaion;

import com.Annotation.ba01.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mytest01 {
    public static void main(String[] args) {
        String conf="Annotation/ApplicationContext.xml";
        ApplicationContext app= new ClassPathXmlApplicationContext(conf);
        Student student = (Student) app.getBean("student001");
        System.out.println(student);
    }


}
