package com.Project1.DAO;

import com.Project1.Domain.Student;

import java.util.List;

public interface StudentTransaction {
    int addStudent(Student student);
    List<Student> selectStudent();
}
