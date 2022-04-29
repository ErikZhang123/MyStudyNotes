package TagInjection;

import com.TagInjection.ba02.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mytest02 {
    @Test
    public void test02(){
        String conf = "TagInjection/ba02/ApplicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(conf);
        Student student = (Student)applicationContext.getBean("Student");
//        School school = new School("USYD");
//        student.setSchool(school);//可以看出，引用数据类型实际上也是调用了set方法，因此也可以使用set注入,但在语法上有差别
        System.out.println(student);
    }
}
