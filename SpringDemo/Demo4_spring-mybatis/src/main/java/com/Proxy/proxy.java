package com.Proxy;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import java.util.*;
import com.Student.Student;
@Component
@Aspect
public class proxy {
    @AfterReturning(value = "execution(* com.Service.StudentServiceImpl.select())", returning = "students")
    public void NumbersOfStudent(JoinPoint joinPoint,Object students){
        System.out.println("代理类number执行");
        List<Student> list = (List<Student>) students;
        System.out.println("增强类查询有多少个学生的结果为："+ list.size());
    }

    @Around(value = "execution(* com.Service.StudentServiceImpl.insert(com.Student.Student))")
    public Object CheckInsertSuccess(ProceedingJoinPoint proceedingjoinPoint) throws Throwable {
        System.out.println("代理类check执行");
        Object[] args = proceedingjoinPoint.getArgs();
        int r=0;
        if(args.length==1 && args[0]!=null){
            System.out.println("Studne类型符合要求");
            r =  (int)proceedingjoinPoint.proceed();
        }
        if(r==1)
            System.out.println("插入成功");
        return r;
    }
}
