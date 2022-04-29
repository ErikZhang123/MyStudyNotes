package com.mybatisDemo.DAO;


import com.mybatisDemo.Domain.Student;

import java.util.List;

public interface StudentDAO {
    //Mybatis在使用动态代理的时候会根据给出的接口自动创建一个实现类
    public abstract List<Student> selectOne(Student s);
    public abstract List<Student> selectTwo(Student s);
    public abstract List<Student> selectThree(List<Integer> students);
    public abstract int insertStudent(Student student);
}
