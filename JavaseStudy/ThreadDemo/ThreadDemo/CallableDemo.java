package ThreadDemo.ThreadDemo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/*
*   3、Callable接口实现线程
      该方法的特点是：可以获取线程的返回值，而Runnable和Thread的方式无法获取返回值
    Callable与Runnable的区别：
    * 主要区别在于，call()方法可以抛出异常，而run()方法不能抛出异常
* */
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//      首先需要创建一个“未来任务”对象
        FutureTask task = new FutureTask(new Callable() {
            @Override
//            这里使用匿名内部类的方式创建，这里的call（）方法就相当于run（）方法
            public Object call() throws InterruptedException {
                System.out.println("this is a thread.");
                int sum=0;
                for(int i=0;i<1000000;i++)
                {
                    sum=sum+i;
                }
                Thread.sleep(1000*1);
                System.out.println("Callable is end");
                return sum;
            }
        });

        Thread t = new Thread(task);
        t.start();
//        使用get()方法获取返回值，但是该方法会让call（）方法进入阻塞状态，效率较低
        Object obj = task.get();
        System.out.println(obj);
        System.out.println("Main Thread is end");
    }
}
class demo implements Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(1000*10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class demo2 implements Callable
{

    @Override
    public Object call() throws Exception {
        Thread.sleep(1000);
        return 0;
    }
}