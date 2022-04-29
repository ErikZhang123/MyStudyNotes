package com.Service;

import com.DAO.StudentDAO;
import com.Exception.NoEnoughBalanceException;
import com.Student.Student;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Component(value="studentServiceImp")
public class StudentServiceImpl implements StudentService {
//    在service实现类中，由于需要用到DAO对象，所以这里必须有一个DAO对象
//    主要就是在service实现类中调用DAO对象来完成增强工作。
//    Service调用Mybatis的DAO接口生成的对象，从数据库中获取所需要的数据，然后通过service对数据/结果进行增强功能的操作。
//    类似于目标类而非代理类

    @Resource
    StudentDAO studentDAO;

    public StudentDAO getStudentDAO() {
        return studentDAO;
    }

    public void setStudentDAO(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public int insert(Student student) {
        int num = studentDAO.insertStudent(student);
        return num;
    }

    @Override
    public List<Student> select() {
        List<Student> list = studentDAO.selectStudent();
        return list;
    }

    @Override
    public Student selectById(Integer id) {
        Student student = studentDAO.selectStudentByID(id);
        return student;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,
    noRollbackFor = RuntimeException.class)

    public int Recharge(Integer id, Double amount) {
        if(amount <5)
            throw new RuntimeException("充值金额至少为5元");
        return studentDAO.Recharge(id,amount);
    }

    @Override
    public int Consume(Integer id, Double amount) {
        Student s = studentDAO.selectStudentByID(id);
        if(amount > s.getBalance())
            throw new NoEnoughBalanceException();
        return studentDAO.Consume(id,amount);
    }


}
