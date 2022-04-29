package ba01;

import org.springframework.stereotype.Component;

@Component("serciveimp")
//业务方法
public class ServiceImp implements Service{
    public void doSome(){
        System.out.println("doSome is working!");
    }
    public Student doSome2(Integer age){
        return new Student("zhagnsan",age);
    }
    public Integer doSome3(Integer age){
        System.out.println("doSome3 目标方法执行了");
        return age;
    }
    public Integer doSome4(Student student){
        System.out.println("doSome4 目标方法执行了");
        return 1;
    }

}
