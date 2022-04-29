package TagInjection;

import com.TagInjection.ba04.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mytest04 {
    @Test
    public void test04(){
        String conf = "TagInjection/ba04/ApplicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(conf);
        Student student = (Student)applicationContext.getBean("Student");
        Student student2 = (Student)applicationContext.getBean("Student2");
        System.out.println(student);
        System.out.println(student2);
    }
}
