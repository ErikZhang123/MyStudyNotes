package com.Project1.Services.Imp;

import com.Project1.DAO.StudentTransaction;
import com.Project1.Domain.Student;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentService implements com.Project1.Services.StudentService {
    //将spring生成的dao对象赋给当前值
    @Resource
    private StudentTransaction studentTransaction;

    @Override
    public int addStudent(Student student) {
        System.out.print(studentTransaction==null);
        int nums = studentTransaction.addStudent(student);
        return nums;
    }

    @Override
    public List<Student> selectStudent() {
        return studentTransaction.selectStudent();
    }
}
