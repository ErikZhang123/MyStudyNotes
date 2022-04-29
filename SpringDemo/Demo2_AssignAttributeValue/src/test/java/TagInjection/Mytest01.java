package TagInjection;

import com.TagInjection.ba01.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class Mytest01 {
    @Test
    public void test01(){
        String conf = "TagInjection/ba01/ApplicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(conf);
        Student student = (Student)applicationContext.getBean("Student");
        System.out.println(student);
    }
    @Test
    public void test02(){
        String conf = "TagInjection/ba01/ApplicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(conf);
        Date date = (Date)applicationContext.getBean("myDate");
        System.out.println(date);
    }
}
