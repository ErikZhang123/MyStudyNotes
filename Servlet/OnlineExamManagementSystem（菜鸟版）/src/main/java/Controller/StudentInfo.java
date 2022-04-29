package Controller;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public  class StudentInfo {
        private int uid;
        private String uname;
        private String upassword;
        private String sex;
        private String email;

     public StudentInfo(int uid, String uname, String upassword, String sex, String email) {
         this.uname = uname;
         this.upassword = upassword;
         this.sex = sex;
         this.email = email;
     }

     public int add() throws SQLException {
         int result = 0;
         String sql="insert into USERINFO(UNAME,UPASSWORD,USEX,UEMAIL) values(?,?,?,?)";
         PreparedStatement ps = JDBCUtil.getConnection().prepareStatement(sql);
         //然而实际上此处的getConnection耗费了非常多的时间，因此需要用监听事件提前创建连接对象使用。
         //注册
         try {
             ps.setString(1, this.uname);
             ps.setString(2, this.upassword);
             ps.setString(3, this.sex);
             ps.setString(4, this.email);
             result=ps.executeUpdate();
             System.out.println("注册完成");
             //注册完成
         } catch (SQLException throwables) {
             throwables.printStackTrace();
         }finally
         {
             JDBCUtil.close(ps,null);
         }
         return result;
     }

     public int add(HttpServletRequest request) throws SQLException {
         int result = 0;
         String sql="insert into USERINFO(UNAME,UPASSWORD,USEX,UEMAIL) values(?,?,?,?)";
         Connection c =JDBCUtil.getConnection(request);
         PreparedStatement ps = c.prepareStatement(sql);
         //*********这里使用了优化后的JDBCUtil的getConnection方法，可以加快速度********
         //注册
         try {
             ps.setString(1, this.uname);
             ps.setString(2, this.upassword);
             ps.setString(3, this.sex);
             ps.setString(4, this.email);
             result=ps.executeUpdate();
             System.out.println("注册完成");
             //注册完成
         } catch (SQLException throwables) {
             throwables.printStackTrace();
         }finally
         {
             JDBCUtil.close(ps);
             JDBCUtil.close(ps,c);
         }
         return result;
     }

    public StudentInfo(Map<String,String> parametermap) {
         this.uname =  parametermap.get("UNAME");
         this.upassword = parametermap.get("UPASSWORD");
         this.sex=parametermap.get("sex");
         this.email=parametermap.get("email");

    }

    public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public String getUname() {
            return uname;
        }

        public void setUname(String uname) {
            this.uname = uname;
        }

        public String getUpassword() {
            return upassword;
        }

        public void setUpassword(String upassword) {
            this.upassword = upassword;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
