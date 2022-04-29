package JDBCtest;
import java.sql.*;
import java.util.ResourceBundle;

public class ConnTest {
    public static void main(String[] args) {
        Statement s = null;
        ResultSet rs = null;
        Connection c = null;
//        用ResourceBundle以便于客户应用，同时让程序更灵活
        ResourceBundle rb = ResourceBundle.getBundle("userinfo");
        String url = rb.getString("url");
        String username = rb.getString("username");
        String password = rb.getString("password");

        try {
            Class.forName("com.mysql.jdbc.Driver");
//          在仅java项目的时候可以不用注册，但是在web项目下必须注册才能使用
//          第一步：建立连接
            c = DriverManager.getConnection(url,username,password);
//          第二部：创建连接对象
            s = c.createStatement();
//            第三部：写sql语句
            String sql="select * from dept";
//            第四步：处理sql语句
            rs = s.executeQuery(sql);//用来处理DQL语句
//          s.executeUpdate用来处理DML语句
//            第五步：遍历处理结果集
            while(rs.next())
            {
                System.out.println(rs.getString("DEPTNO")+rs.getString("DNAME"));
            }
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
//        第六步：关闭连接
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally{
            if(s!=null){
                try {
                    s.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            System.out.println("Statement已关闭");
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            System.out.println("ResultSet已关闭");
            if(c!=null)
            {
                try {
                    c.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
