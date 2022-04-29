import com.DAO.StudentDAO;
import com.Service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

    @Test
    public void test01(){
        String conf = "spring-mybatis.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(conf);
        StudentService studentService =  (StudentService) applicationContext.getBean("studentServiceImp");
//        使用注解进行事务管理
        System.out.println(studentService.Recharge(1,110.0));
//        System.out.println(studentService.selectById(1));
//        使用aspectJ进行事务管理
        System.out.println(studentService.Consume(1,100.0));
    }
}
