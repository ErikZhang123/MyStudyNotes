package ThreadDemo.functions;

public class FunctionsDemo {
    public static void main(String[] args) {
//   1、获取/修改线程对象的名字
        Thread t1 = new Thread(new Thread1());
        t1.getName();
//   2、  默认线程名字为 Thread-i；i从0开始随线程对象增加
        t1.setName("t1");
        System.out.println(t1.getName());
//   3、 获取当前线程
        t1.start();
        Thread.currentThread();//返回的是一个Thread对象
        Thread t2 = Thread.currentThread();
        System.out.println( Thread.currentThread());
//   4、测试t1与main抢夺时间片
        for(int i=0;i<10;i++)
        {
            System.out.println(Thread.currentThread().getName()+"==========>"+i);
        }
    }

    static class Thread1 implements Runnable
    {
        public void run()
        {
            for(int i=0;i<5;i++)
            {
                System.out.println(Thread.currentThread().getName()+"——————>"+i);
            }
        }
    }
}