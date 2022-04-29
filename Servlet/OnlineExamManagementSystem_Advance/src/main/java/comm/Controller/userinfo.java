package comm.Controller;

import comm.JDBCUtil;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class userinfo {
    private String username;
    private String password;
    private HttpServletRequest request;

    public userinfo(HttpServletRequest request) {
        this.request = request;
        this.username = request.getParameter("username");
        this.password = request.getParameter("password");
    }

    public boolean search(){
        boolean flag = false;
        Connection c = JDBCUtil.getConnection(request);

        String sql = "select * from USERINFO where UNAME=? and UPASSWORD=?";
        try {
            PreparedStatement ps = JDBCUtil.getPreparedStatement(c,sql);
            ps.setString(1,username);
            ps.setString(2,password);

            ResultSet rs = JDBCUtil.getResultSet(ps);

            if(rs.next()) flag=true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return flag;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
