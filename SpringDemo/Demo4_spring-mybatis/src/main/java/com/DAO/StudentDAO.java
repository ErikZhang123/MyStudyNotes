package com.DAO;

import com.Student.Student;

import java.util.List;

public interface StudentDAO {
     List<Student> selectStudent();
     int insertStudent(Student student);
     Student selectStudentByID(Integer id);

}
