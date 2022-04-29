package ThreadDemo.SychronizedDemo;
/*
* 线程安全在并发的时候是非常重要的。
* 虽然sychronized方法已经过时，但在javase期间仍然使用其作为线程安全的保证
* 虽然他的效率比较低。
*
* */
public class test {
    public static void main(String[] args) {
//        Account act = new Account("act-001",10000); 用没有sychronized的对象会产生一些错误，因此在sychronized后可以保证数据安全
        SynchronizedAccount sact = new SynchronizedAccount("act-001",10000);
//        SynchronizedAccount sact2 = new SynchronizedAccount("act-001",10000);

        Thread t1 = new AccountThread(sact);
        t1.setName("t1");
        Thread t2 = new AccountThread(sact);
        t2.setName("t2");

//        Thread t3 = new AccountThread(sact2);//t3和t1就不同步了，因为sact2与sact并不一样
//        t3.setName("t3");
        t1.start();
        t2.start();
//        t3.start();
    }
}
