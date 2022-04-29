package com.Service;

import com.Student.Student;

import java.util.List;

public interface StudentService {
    int insert(Student student);
    List<Student> select();
    Student selectById(Integer id);
}
