package ThreadDemo.SychronizedDemo;

public class SynchronizedAccount  {
    private String Actnum;
    private double Balance;
    Object obj = new Object();//实例变量，只有一个。
    public SynchronizedAccount(String actnum, double balance) {
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
        /*为了结局数据更新问题，以下代码必须是一个线程执行完后，另一个线程才能进来，不能并发
        使用sychronized关键字来使线程同步，sychronized语法是
        sycronized(){};()里面的内容非常重要
        希望哪些线程同步，就在()里面放入哪些线程共享的对象
        此处线程共享的对象是账户对象，即this
        */
//        synchronized (this)
                /*进阶知识点：
                ()中如果写上字符串，那么就是所有线程都同步，因为常量池是共享的，常量池中的字符串是唯一的
                在共享对象中的属性也是共享的，若在SychronizedAccount中新建一个全局变量OBJ
                此时OBJ也可以作为共享对象写在()中。
                * */
                synchronized (obj)
        {
            double before = this.Balance;
            double after = before - money;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.setBalance(after);
        }

    }
}