package mybatisDemo.Domain;

public class Student2 {
    private int id;
    private String name;
    private String password;
    private String sex;
    private String email;

    public Student2(int uid, String uname) {
        this.id = uid;
        this.name = uname;
    }

    public int getUid() {
        return id;
    }

    public void setUid(int uid) {
        this.id = uid;
    }

    public String getUname() {
        return name;
    }

    public void setUname(String uname) {
        this.name = uname;
    }

    public String getUpassword() {
        return password;
    }

    public void setUpassword(String upassword) {
        this.password = upassword;
    }

    public String getUsex() {
        return sex;
    }

    public void setUsex(String usex) {
        this.sex = usex;
    }

    public String getUemail() {
        return email;
    }

    public void setUemail(String uemail) {
        this.email = uemail;
    }

    @Override
    public String toString() {
        return "Student{" +
                "uid=" + id +
                ", uname='" + name + '\'' +
                ", upassword='" + password + '\'' +
                ", usex='" + sex + '\'' +
                ", uemail='" + email + '\'' +
                '}';
    }

}
