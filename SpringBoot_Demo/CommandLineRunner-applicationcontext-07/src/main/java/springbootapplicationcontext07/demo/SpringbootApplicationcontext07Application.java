package springbootapplicationcontext07.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import springbootapplicationcontext07.demo.service.myservice;

import javax.annotation.Resource;

@SpringBootApplication
public class SpringbootApplicationcontext07Application implements CommandLineRunner {

    public static void main(String[] args)  {
        /**run的返回结果是ConfigurableApplicationContext，这个类继承了Application。所以
         实际上run的返回值就是一个容器对象，同样可以通过getBean的方法从中获取对象
         一般在测试的时候使用
         **/
        System.out.println("main方法开始执行，开始创建容器对象");
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringbootApplicationcontext07Application.class, args);
        //使用 ApplicationContext也可以
        myservice m = (myservice) applicationContext.getBean("userService");
        m.hello("张三");
    }
//CommandLineRunner的run方法，在容器启动后执行，所以可以调用容器中的对象。执行时机很重要
    @Resource
    private myservice userService;
    @Override
    public void run(String... args) throws Exception {
        //此处可以做一些自定义的操作，比如读取数据库，读取文件等
        System.out.println("获取到了对象"+userService);
        System.out.println("容器对象创建好了，run方法开始执行");
    }
}
