package JDBCtest;
//

import java.sql.*;
import java.util.ResourceBundle;

/**在写工具类的时候首先明确：所有方法都是通过类名调用，因此所有方法都是静态的
 * 工具类仅仅为了节约时间成本，通常要求外部输入参数而不使用内部属性
 * */

public class JDBCUtil {
    private JDBCUtil(){};//私有化了构造方法，用来放置new对象。
    static{
        //静态代码块，在类加载的时候执行
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection GetConnection(String username,String password,String url) throws SQLException {
        Connection c = DriverManager.getConnection(username, password, url);
        return c;
    }
    public static void close(ResultSet rs, PreparedStatement ps, Connection c)
    {
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
}
