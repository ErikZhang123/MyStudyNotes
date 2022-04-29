package com.transaction12.service;

import com.transaction12.dao.StudentMapper;
import com.transaction12.model.Student;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class myServiceImp implements MyService{
    @Resource
    StudentMapper studentMapper;

    /**@Transactional 表示方法有事务支持，如果不设置属性，默认使用数据库的隔离级别 REQUIRED 传播行为
     *                  ： 超时时间 -1
     *                  如果抛出异常，则回滚事务
     * **/
    @Transactional
    @Override
    public int addStudent(Student student) {
        System.out.println("插入业务执行了");
        int rows = studentMapper.insert(student);
        System.out.println("执行sql语句");
//        抛出一个runtime exception， 为了回滚事务
//        int n = 10/0;
        return rows;
    }
}
