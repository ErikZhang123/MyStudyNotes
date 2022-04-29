package com.mybatisDemo;

import java.io.IOException;
import java.util.*;

import com.github.pagehelper.PageHelper;
import com.mybatisDemo.DAO.StudentDAO;
import com.mybatisDemo.DAO.dao;
import com.mybatisDemo.Domain.Student;
import org.apache.ibatis.session.SqlSession;

public class Mytest {
    public static void main(String[] args) throws IOException {
        SqlSession sqlSession = dao.getSession(true);
        StudentDAO dao = sqlSession.getMapper(StudentDAO.class);
        Student s = new Student(7,"","123","m","123@qq.com");
//        List<Student> students = dao.selectTwo(s);
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        ids.add(4);
        ids.add(5);
        ids.add(6);
        PageHelper.startPage(1,3);//起到limit的作用
        List<Student> students = dao.selectThree(ids);
        for (Student student:students) {
            System.out.println(student);
        }
        sqlSession.close();

    }
}
