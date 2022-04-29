import ba01.Service;
import ba01.ServiceImp;
import ba01.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mytest01 {
    public static void main(String[] args) {
        String conf="resources/AOP_ApplicationContext.xml";
        ApplicationContext app = new ClassPathXmlApplicationContext(conf);
        Service service = (Service) app.getBean("serciveimp");

        service.doSome();

        Student student = (Student) service.doSome2(30);

        service.doSome3(20);

        int a = service.doSome4(new Student("zhangsan",29));
        System.out.println(a);
    }

}
