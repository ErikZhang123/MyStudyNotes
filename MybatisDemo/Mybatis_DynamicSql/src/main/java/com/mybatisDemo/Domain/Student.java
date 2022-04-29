package com.mybatisDemo.Domain;

public class Student {
    private int uid;
    private String uname;
    private String upassword;
    private String usex;
    private String uemail;

    public Student(int uid, String uname, String upassword, String usex, String uemail) {
        this.uid = uid;
        this.uname = uname;
        this.upassword = upassword;
        this.usex = usex;
        this.uemail = uemail;
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

    public String getUsex() {
        return usex;
    }

    public void setUsex(String usex) {
        this.usex = usex;
    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }

    @Override
    public String toString() {
        return "Student{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", upassword='" + upassword + '\'' +
                ", usex='" + usex + '\'' +
                ", uemail='" + uemail + '\'' +
                '}';
    }

}
