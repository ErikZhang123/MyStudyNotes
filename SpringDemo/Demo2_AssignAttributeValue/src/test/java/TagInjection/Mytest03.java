package TagInjection;

import com.TagInjection.ba03.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mytest03 {
    @Test
    public void test03(){
        String conf = "TagInjection/ba03/ApplicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(conf);
        Student student = (Student) applicationContext.getBean("Student");
        Student student2 = (Student) applicationContext.getBean("Student2");
        System.out.println(student);
        System.out.println(student2);
    }
}
