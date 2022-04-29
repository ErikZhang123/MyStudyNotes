package ba01;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Proxy03 {
//    环绕通知:
        /**1、方法必须为public
         * 2、方法必须有一个返回值，推荐使用object类，就是目标方法的执行结果，可以被修改
         * 3、方法有参数，固定参数ProceedingJoinPoint，这个参数让我们可以在切片方法中选择何时执行目标方法，或者不执行目标方法
         *
         *目标方法调用前后都可以增强功能
         * */
    @Around(value="execution(* *..ServiceImp.doSome4(*))")
    public Integer doSomePlus04(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("doSomePlus04 切片方法正在执行");
        proceedingJoinPoint.proceed();
        System.out.println("doSomePlus04 又执行了");
        return 100;

    }
}
