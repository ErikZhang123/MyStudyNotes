import DAO.StudentLogin;
import Domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.ResourceBundle;

public class test {


    @Test
    public void test01() throws IOException {
        int id = 1;
        String config = "Mybatis_Mysql_Property.xml";
        InputStream inputStream = Resources.getResourceAsStream(config);
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sessionFactory.openSession();
        StudentLogin login = sqlSession.getMapper(StudentLogin.class);
        Student s = login.select(1);


        System.out.println(s.getId()+" "+s.getName()+" "+s.getBalance());
    }
}
