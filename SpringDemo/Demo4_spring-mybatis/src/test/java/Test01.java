import com.Student.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.Service.StudentService;

import java.util.List;

public class Test01 {

    public static void main(String[] args) {
        String conf = "spring-mybatis.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(conf);
        StudentService service = (StudentService) applicationContext.getBean("studentServiceImp");
        service.select();
        service.insert(new Student(2,"lisi",29));
        Object  s= applicationContext.getBean("MySqlSessionFactory");
        System.out.println(s==null);
    }
}
