package ThreadDemo.SychronizedDemo;

public class Account  {
    private String Actnum;
    private double Balance;

    public Account(String actnum, double balance) {
        Actnum = actnum;
        Balance = balance;
    }

    public String getActnum() {
        return Actnum;
    }

    public void setActnum(String actnum) {
        Actnum = actnum;
    }

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double balance) {
        Balance = balance;
    }

    public void withdraw(double money)
    {
//        t1和t2并发该方法
//        若在t1还没有执行完毕该方法的setbalance方法时，t2就抢到了时间片
//        那么此时act中的balance数据还没有更新，t2的getbalance方法调取的仍是10000；就会出现问题
//        会出现两者余额都返回5000的情况。
        double before = this.Balance;
        double after = before - money;
//        此处用sleep方法模拟网络延迟，那么程序一定会产生返回两个5000的错误
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//
        this.setBalance(after);
    }
}
