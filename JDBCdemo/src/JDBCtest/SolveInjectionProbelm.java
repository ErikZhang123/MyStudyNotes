package JDBCtest;

import java.sql.*;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 *     c = DriverManager.getConnection(url,username,password);
 *             s = c.createStatement();
 *             sql="select * from userinfo where username='"+uname+"' and password='"+upassword+"'";
 *            比如：
 *             /**请输入用户名：
 *              123
 *              请输入密码：
 *              123' or '1'='1  由于此处查询密码的字符串，但他在此处写入了一个sql内容
 *                             因此通过ResultSet处理的时候就改变了sql的原本作用，使其失效
 *                             这种问题就叫做sql的注入问题
 *              为了解决注入问题，要用到java.sql.PreparedStatement预先对sql语句框架编译
 *              然后传入的内容只会被认为是"值"而不会被认为是sql语句的一部分
 *              rs=s.executeQuery(sql);* */
public class SolveInjectionProbelm {
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
        PreparedStatement ps = null;
        Connection c = null;
        ResultSet rs = null;
        String sql;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String uname = scanner.nextLine();
        System.out.println("请输入密码：");
        String upassword = scanner.nextLine();

        try {
            c = DriverManager.getConnection(url,username,password);

            c.setAutoCommit(false);

            sql="select * from userinfo where username=? and password=?";
            ps=c.prepareStatement(sql);

            ps.setString(1,uname);
            ps.setString(2,upassword);

            ps.executeQuery();
            //或者ps.excuteUpdate();

            rs =ps.getResultSet();
            if(rs.next()){
                System.out.println("登录成功");
            }else
            {
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
            if(ps!=null){
                try {
                    ps.close();
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
