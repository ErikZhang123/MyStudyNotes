package mybatisDemo;

import mybatisDemo.DAO.StudentDAO;
import mybatisDemo.DAO.Mybatis_dao;
import mybatisDemo.Domain.Student;
import mybatisDemo.Domain.Student2;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Mytest {
    public static void main(String[] args) throws IOException {
        SqlSession sqlSession = Mybatis_dao.getSession(true);
        StudentDAO dao = sqlSession.getMapper(StudentDAO.class);
        Student s  = new Student(900,"关羽","niuzahaochi","m","guanyu@163.com");
//        int result = dao.insertStudent(s);
//        List<Student> students = dao.selectAll();
//        List<Student> students = dao.selectByIdAndName(1,"ZHANGSAN");
        //如果是insert，update，delete，语句，默认不是自动提交事务，需要手动提交。
//        List<Student> students = dao.selectTwo(s);
//        List<Student> students = dao.selectbyOtherName(s);
//        List<Student2> students = dao.resultMapTest();
          List<Student> students = dao.blurSelect("猫");
//        System.out.println(result);
        students.forEach(stu -> System.out.println(stu));
        sqlSession.close();

    }
}
