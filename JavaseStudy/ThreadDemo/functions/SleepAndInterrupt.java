package ThreadDemo.functions;
/*
* //   5、Thread.sleep(long millis)方法，使当前线程放弃时间片并进入就绪状态，millis表示使其睡眠的时间
//        注意：不论对象是谁，调用sleep的时候都会转为Thread.sleep
//        比如：t1.sleep与t3.sleep并没有区别，因为都是对当前线程执行的，不会因为调用对象而产生变化

//   6、t.interrupt()唤醒该线程对象
//        t.interrupt();
* */
public class SleepAndInterrupt {
    public static void main(String[] args) {
        Thread t1 = new MyThread();
        t1.setName("t1");
        t1.start();

        for(int i=0;i<10;i++)
        {
            System.out.println(Thread.currentThread().getName()+"————————>"+i);
        }
        try {
            Thread.sleep(1000*5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//      interrupt方法会报出异常信息，如果不想让他报异常信息，那么就将MyThread的catch中的报异常信息的代码删掉
//        让哪个醒，就删除哪个里面的报异常信息代码
        t1.interrupt();//java.lang.InterruptedException: sleep interrupted

    }
}
class MyThread extends Thread
{
    @Override
    public void run() {
        try {
            Thread.sleep(1000*60*60*24);
        } catch (InterruptedException e) {
//            e.printStackTrace();
        }
    }
}
