package com.mybatisDemo.DAO;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class dao {
    //可以使用一个工具类完成SqlSessionFactorybuilder，以及SqlSessionFactory的构建
    static SqlSessionFactoryBuilder sqlSessionFactoryBuilder  = null;
    static SqlSessionFactory sqlSessionFactory = null;
    static{
        String config="Mybatis_Mysql_Property.xml";
        sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        try {
            InputStream in = Resources.getResourceAsStream(config);
            sqlSessionFactory = sqlSessionFactoryBuilder.build(in);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSession(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }
//  如果构造方法中又一个boolean类型，true则自动提交事务，false则关闭自动提交事务
    public static SqlSession getSession(boolean ifAutoCommit){
        SqlSession sqlSession = sqlSessionFactory.openSession(ifAutoCommit);
        return sqlSession;
    }
}
