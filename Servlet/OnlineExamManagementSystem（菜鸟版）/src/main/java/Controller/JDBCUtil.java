package Controller;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.*;

public class JDBCUtil {
     static String url ="jdbc:mysql://localhost:3306/STUDENTUSERINFO";
     static String username="root";
     static String password="zhang123";
    //JDBC工具类
//    static{
//        //注册驱动
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }

    public JDBCUtil() {
        JDBCUtil.getConnection();
    }

     static Connection getConnection() {
//        ResourceBundle rb = ResourceBundle.getBundle(properties);
//        String sqlname=rb.getString("username");
//        String sqlpass=rb.getString("password");
//        String sqlurl=rb.getString("url");

        Connection c = null;
        try {
            c = DriverManager.getConnection(url,username,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
//        System.out.println("数据库连接已创建");
        return c;
    }
    /*********对getConnection方法进行了优化，其调用已经创建的connection对象，而不是重新创建Connection对象*************/
    public static Connection getConnection(HttpServletRequest request) {
        ServletContext sc = request.getServletContext();
        Map map = (Map)sc.getAttribute("connections");
        Connection connection = null;
        Iterator iterator = map.keySet().iterator();
        while(iterator.hasNext()){
            connection = (Connection) iterator.next();
            boolean flag = (boolean) map.get(connection);
            if(flag){
                map.replace(connection,false);
                break;
            }
        }
        return connection;
    }

    public static void close(ResultSet rs, PreparedStatement ps, Connection c){
        try {
            rs.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            c.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("数据库连接已关闭");
    }
    public static void close(PreparedStatement ps ,Connection c){
        try {
            if(ps != null)
            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if(c!=null)
                c.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void close(PreparedStatement ps){
        if(ps!=null){
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    public static void close(Connection connection,HttpServletRequest request){
        ServletContext sc = request.getServletContext();
        Map map = (Map)sc.getAttribute("connections");
        map.replace(connection,true);
    }
}
