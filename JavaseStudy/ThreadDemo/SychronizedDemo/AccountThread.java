package ThreadDemo.SychronizedDemo;

public class AccountThread extends Thread  {
//    保证两个线程共享一个账户对象
    private SynchronizedAccount act;
//    通过构造方法传递账户对象。
    /*实际上由于在test中建线程的时候使用的类都是是AccountThread
    所以线程共享AccountThread
    而AccountThread中又将SychronizedAccount作为其的一个属性
    所以线程同样共享SychronizedAccount，其中的属性也是共享的

    * */
    public AccountThread(SynchronizedAccount act) {

        this.act = act;
    }

    public void run() {
//        假设取款5000

        double money=5000;
        act.withdraw(money);
        System.out.println("账户"+Thread.currentThread().getName()+"取款成功,剩余余额："+act.getBalance()+"元");
    }

}
