package com.mybatisDemo;

import com.mybatisDemo.Domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Mytest {
    public static void main(String[] args) throws IOException {
        //访问mybatis-[[读取student数据
        //1.定义mybatis主配置文件名称,从类路径的根开始（target/classes）
        String config="mybatisProperty.xml";
        //2.读取该xml文件
        InputStream in = Resources.getResourceAsStream(config);
        //3.创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //4.创建SqlSessionFactory对象
        SqlSessionFactory sessionFactory = builder.build(in);
        //5.【重要】从SqlSessionFactory中获取SqlSession对象
        SqlSession sqlSession = sessionFactory.openSession();
//        SqlSession sqlSession = sessionFactory.openSession(true);//用该构造方法可以将事务设为自动提交

        //6.指定要执行的sql语句的标识，格式为：
        //   sql mapper 中的namespace.标签id
        String sqlId1 = "com.mybatisDemo.DAO.StudentDAO"+"."+"selectAll";
        String sqlId2 = "com.mybatisDemo.DAO.StudentDAO"+"."+"insertStudent";

        //7. 通过sqlId来找到要执行的sql语句
        List<Student> students = sqlSession.selectList(sqlId1);
        int result = sqlSession.insert(sqlId2,new Student(199,"关羽","niuzahaochi","m","guanyu@163.com"));
        //如果是insert，update，delete，语句，默认不是自动提交事务，需要手动提交。
        sqlSession.commit();
        //8.输出结果
//        students.forEach(stu -> System.out.println(stu));
        System.out.println(result);
        //9.关闭SqlSession对象
        sqlSession.close();
    }
}
