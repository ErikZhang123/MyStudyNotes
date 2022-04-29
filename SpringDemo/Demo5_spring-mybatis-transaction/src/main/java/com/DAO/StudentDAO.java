package com.DAO;

import com.Student.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDAO {
     List<Student> selectStudent();
     int insertStudent(Student student);
     Student selectStudentByID(Integer id);

     int Recharge(@Param("id")Integer id,
                  @Param("amount")Double amount);

     int Consume(@Param("id")Integer id,
                 @Param("amount")Double amount);

}
