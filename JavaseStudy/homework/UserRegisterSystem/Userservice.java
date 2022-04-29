package homework.UserRegisterSystem;

public class Userservice {
    private String username;
    private String password;
    private Object[] userinfo;
    int i=0;
    public Userservice() {
        this.userinfo=new Object[1024];
    }

    public void register (String username ,String password) throws AccountLengthException {
        /*编码经验：
        1、引用==null的情况最好放在所有判断的最前面，防止空指针异常；
        2、可以将username==null写成null=username；主要防止将“==”写成“=”；
        * */
        if(username == null || username.length()>14 || username.length()<6)
        {
            throw new AccountLengthException("用户名长度错误，必须在【6~14】之间");
        }
            userinfo[i]=username;//双数索引为用户名
            userinfo[i+1]=password;//单数索引为密码
            System.out.println("注册成功");
            i++;
    }
    public void check(String username) throws CannotFindUsername {
        boolean flag= true;
        for(i = 0;i<userinfo.length&userinfo[i]!=null;i++)
       {
            if(userinfo[i].equals(username)){
               flag = true;
               break;
            }
           flag = false;
       }
       if(flag) {
            System.out.println("已查询到用户名");
           i++;
            System.out.println("对应密码为：" + userinfo[i]);
       }
        else
        {
            throw new CannotFindUsername("不存在该用户");
        }
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
