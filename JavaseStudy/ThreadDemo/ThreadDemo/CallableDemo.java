package ThreadDemo.ThreadDemo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/*
*   3��Callable�ӿ�ʵ���߳�
      �÷������ص��ǣ����Ի�ȡ�̵߳ķ���ֵ����Runnable��Thread�ķ�ʽ�޷���ȡ����ֵ
    Callable��Runnable������
    * ��Ҫ�������ڣ�call()���������׳��쳣����run()���������׳��쳣
* */
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//      ������Ҫ����һ����δ�����񡱶���
        FutureTask task = new FutureTask(new Callable() {
            @Override
//            ����ʹ�������ڲ���ķ�ʽ�����������call�����������൱��run��������
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
//        ʹ��get()������ȡ����ֵ�����Ǹ÷�������call����������������״̬��Ч�ʽϵ�
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