package ba01;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Aspect
public class Proxy02 {
//    后置通知:
        /**1、方法必须为public
         * 2、方法没有返回值
         * 3、方法如果有参数，建议为Object类*/
    @AfterReturning(value="execution(* ba01.ServiceImp.doSome3(Integer))", returning="res")
    public void doSomePlus03(Object res){
        Integer value = (Integer) res;
        System.out.println("doSomePlus03 结果是："+(++value));
//
    }
}
