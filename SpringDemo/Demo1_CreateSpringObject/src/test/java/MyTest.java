import Service.MyService;
import Service.Service01;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
   @Test
    public void test01(){
       MyService myService = new Service01();
       myService.doSome();
   }
   @Test
    public void test02(){
       //使用spring创建对象
       //1、指定spring配置文件的位置
       String springconf = "resources/SpringBean.xml";
//       2、创建表示spring容器的对象，ApplicationContext来代表spring容器，通过容器获取的对象
//       括号中是configure的路径,它会从target的class根目录下读配置文件，然后创建对象
       ApplicationContext applicationContext = new ClassPathXmlApplicationContext(springconf);

       System.out.println("构造方法是否执行？");
//      3、从容器中获取某个对象
       MyService myService = (Service01)applicationContext.getBean("service01");
       //通过id获取对象，常用，使用接口类型来接收
//      4、使用spring创建的对象
       myService.doSome();
   }
   @Test
   public void test03(){
      //通过spring接口来获取对象的信息
      String springconf = "resources/SpringBean.xml";
      ApplicationContext applicationContext = new ClassPathXmlApplicationContext(springconf);
      int num = applicationContext.getBeanDefinitionCount();//获取容器中对象的数量
      System.out.println("容器中对象的数量是："+num);
      String[] names = applicationContext.getBeanDefinitionNames();//获取容器中对象的名称
      for (String name :names) {
         System.out.println(name);
      }
   }
}
