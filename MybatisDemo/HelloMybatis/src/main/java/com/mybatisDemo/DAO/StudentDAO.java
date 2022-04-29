package com.mybatisDemo.DAO;

import com.mybatisDemo.Domain.Student;

import java.util.List;

public interface StudentDAO {
    //查询student表所有数据,对应sql的执行，sql写在sql映射文件中
    // xml文件,与dao接口放在统一目录下。文件名称与接口保持一致
    //目的是为了Mybatis在使用动态代理的时候会根据给出的接口自动创建一个实现类，
    public abstract List<Student> selectAll();
    public abstract int insertStudent();
}
