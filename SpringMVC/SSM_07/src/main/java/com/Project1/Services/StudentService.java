package com.Project1.Services;

import com.Project1.Domain.Student;

import java.util.List;

public interface StudentService {
    int addStudent(Student student);
    List<Student> selectStudent();
}
