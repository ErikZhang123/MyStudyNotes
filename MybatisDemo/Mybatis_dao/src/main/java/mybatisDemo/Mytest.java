package mybatisDemo;

import mybatisDemo.DAO.StudentDAO;
import mybatisDemo.DAO.dao;
import mybatisDemo.Domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Mytest {
    public static void main(String[] args) throws IOException {
        SqlSession sqlSession = dao.getSession(true);

//        String selectall = "mybatisDemo.DAO.StudentDAO.selectAll";
//        String instudent = "mybatisDemo.DAO.StudentDAO.insertStudent";
        //通过使用Mybatis的动态代理，可以不用写以上的字符串，直接获取字节码文件
        StudentDAO dao = sqlSession.getMapper(StudentDAO.class);

//        List<Student> students = sqlSession.selectList(selectAll);
        Student s  = new Student(900,"关羽","niuzahaochi","m","guanyu@163.com");
        int result = dao.insertStudent(s);
        List<Student> students = dao.selectAll();
        //如果是insert，update，delete，语句，默认不是自动提交事务，需要手动提交。
//        sqlSession.commit();
        students.forEach(stu -> System.out.println(stu));
        sqlSession.close();

    }
}
