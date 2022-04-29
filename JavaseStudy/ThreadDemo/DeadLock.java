package ThreadDemo;
/*
 * 死锁：
 * 即在使用线程同步的同时使用线程嵌套，则非常容易出现死锁.
 * 有时候就是这么神奇。。。第一次死锁没锁住，重写了一遍锁住了
 * 神奇，却是神奇
 * */
public class DeadLock {
    public static void main(String[] args) {
        Object obj1 = new Object();
        Object obj2 = new Object();
        Thread t1 = new MyThread1(obj1,obj2);
        Thread t2 = new MyThread2(obj1,obj2);

        t1.start();
        t2.start();
    }
}
class MyThread1 extends Thread
{
    Object obj1;
    Object obj2;

    public MyThread1(Object obj1, Object obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    @Override
    public void run() {
        synchronized (obj1)
        {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (obj2)
            {

            }
        }
    }
}
class MyThread2 extends Thread
{
    Object obj1;
    Object obj2;

    public MyThread2(Object obj1, Object obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    @Override
    public void run() {
        synchronized (obj2)
        {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (obj1)
            {

            }
        }
    }
}
