package comm;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class JDBCUtil {
    /**JDBC工具类*/
    String url="jdbc:mysql://localhost:3306/STUDENTUSERINFO";
    String username="root";
    String upassword="zhang123";
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection(HttpServletRequest request)  {
        Connection c = null;
        ServletContext sc = request.getServletContext();
        Map collections = (HashMap)sc.getAttribute("connections");
        //通过监听对象已经创建好了很多歌connection对象，只需要获取可用的对象即可
        Iterator iterator = collections.keySet().iterator();

       while(iterator.hasNext()){
           if( (boolean)collections.get(iterator.next()) ){
               c= (Connection) iterator.next();
           }
       }
        return  c;
    }
    public static PreparedStatement getPreparedStatement(Connection c,String sql) throws SQLException {
        PreparedStatement ps = c.prepareStatement(sql);
        return ps;
    }
    public static ResultSet getResultSet(PreparedStatement ps) throws SQLException {
        ResultSet rs =  ps.executeQuery();
        return rs;
    }
    public static void  close(Connection c,HttpServletRequest request){
        if(c!=null){
            ServletContext sc = request.getServletContext();
            Map collections = (HashMap)sc.getAttribute("collections");
            collections.replace(c,true);
        }
   }
    public static void close(PreparedStatement ps){
       try {
           ps.close();
       } catch (SQLException throwables) {
           throwables.printStackTrace();
       }
   }
    public static void close(ResultSet rs){
       try {
           rs.close();
       } catch (SQLException throwables) {
           throwables.printStackTrace();
       }
   }
}
