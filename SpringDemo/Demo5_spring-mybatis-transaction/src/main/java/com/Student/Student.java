package com.Student;

public class Student {
    private Integer sid;
    private String name;
    private Double balance;

    public Student() {
    }

    public Student(int sid, String name, Double balance) {
        this.sid = sid;
        this.name = name;
        this.balance = balance;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
