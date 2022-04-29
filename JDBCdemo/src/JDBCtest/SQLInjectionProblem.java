package JDBCtest;

import java.sql.*;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 *
 * SQL存在注入问题（Injection Problem）
 * 即，当在使用sql语句时，如果需要用户输入信息
 * 那么通过输入特定的信息，可以非法改变程序中sql语句的作用，使其失效
 * 例如'用户登录系统'
 */
public class SQLInjectionProblem {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ResourceBundle rb  = ResourceBundle.getBundle("userinfo");

        String url = rb.getString("url");
        String username = rb.getString("username");
        String password = rb.getString("password");
        Statement s = null;
        Connection c = null;
        ResultSet rs = null;
        String sql = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String uname = scanner.nextLine();
        System.out.println("请输入密码：");
        String upassword = scanner.nextLine();

        try {
            c = DriverManager.getConnection(url,username,password);
//            关闭自动提交事务的功能
            c.setAutoCommit(false);
            s = c.createStatement();
            sql="select * from userinfo where username='"+uname+"' and password='"+upassword+"'";
            c.commit();
//           比如：
            /**请输入用户名：
             123
             请输入密码：
             123' or '1'='1  由于此处查询密码的字符串，但他在此处写入了一个sql内容
                            因此通过ResultSet处理的时候就改变了sql的原本作用，使其失效
                            这种问题就叫做sql的注入问题
             为了解决注入问题，要用到java.sql.PreparedStatement预先对sql语句框架编译
             然后传入的内容只会被认为是"值"而不会被认为是sql语句的一部分
             * */
            rs = s.executeQuery(sql);
            if(rs.next()){
                System.out.println("登录成功");
            }
            else{
                System.out.println("登录失败");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(s!=null){
                try {
                    s.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(c!=null){
                try {
                    c.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            System.out.println("数据库已关闭");
        }
    }
}
