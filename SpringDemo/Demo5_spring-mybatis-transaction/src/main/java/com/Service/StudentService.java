package com.Service;

import com.Student.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentService {
    int insert(Student student);
    List<Student> select();
    Student selectById(Integer id);
    int Recharge(Integer id,
                 Double amount);

    int Consume(Integer id,
                Double amount);
}
