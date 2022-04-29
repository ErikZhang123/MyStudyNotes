package ba01;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component//必须先声明切面类才可以使用。
@Aspect//用@Aspect来声明这是一个切面类
public class Proxy01 {
    //切面类需要有切面方法来增强目标类方法
    //切面类包含两个方面：切面方法使用的时间和位置
//  前置通知
    @Before(value="execution(public void ba01.ServiceImp.doSome())")
//  @Before来表示，该切面方法会在目标类方法执行之前执行。
//  也可以使用通配符的格式：
//    @Before(value="execution(* *a01..ServiceImp.*(..))")
//  如果此时目标方法写错，导致没有找到目标方法，那么不会报错，只是代理增强功能失效
//  execution()是切入点表达式，表明切面方法使用的位置，即对哪些目标方法进行增强
    public void doSomePlus(JoinPoint joinPoint){
//      JoinPoint 可以获取目标方法的信息，比如方法名称，参数类型等
        System.out.println(joinPoint.getSignature());//获取方法的声明
        Object[] args = joinPoint.getArgs();//获取方法的参数列表，返回Object[]
        String methodName = joinPoint.getSignature().getName();//可以通过声明再次获取信息
        System.out.println("doSome的使用时间是："+ new Date());

    }

}
