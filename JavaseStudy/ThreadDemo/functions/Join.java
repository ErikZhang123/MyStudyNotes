package ThreadDemo.functions;
/*
* 4、void join();
 * t.join()合并线程:当前线程进入阻塞状态，t线程开始执行，直至t线程结束，其他线程才开始执行
 * 在内存上是两个栈之间发生了等待关系。
 * */
public class Join {
    public static void main(String[] args) {
        System.out.println("main begin");
        Thread t = new MyThread3();
        Thread t2 = new MyThread4();
        t.setName("t");
        t2.setName("t2");
        t.start();

        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();//在顺序执行的线程之前使用join就可以强迫后启动的线程后执行
        System.out.println("main over");
    }
}
class MyThread3 extends  Thread
{
    @Override
    public void run() {
        for(int i=0;i<10;i++)
        {
            System.out.println(Thread.currentThread().getName()+"————————>"+i);
        }
    }
}

class  MyThread4 extends Thread
{
    public void run()
    {
        System.out.println("t2 over");
    }
}
