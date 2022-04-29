package ThreadDemo;

import java.util.ArrayList;
import java.util.List;

/*
 * 消费者生产者模式输出
 * t1输出奇数，t2输出偶数，要求数字共享，每次对数字进行++操作
 * */
public class ProducerAndConsumer {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(0,0);
        /*
        注意：
        共享对象不可以为Integer
        * */
        Thread t1 = new Thread(new Producer(list));
        Thread t2 = new Thread(new Consumer(list));

        t1.setName("Producer");
        t2.setName("Consumer");

        t1.start();
        t2.start();
    }

    static class Producer implements Runnable {
        private List list;

        public Producer(List list) {
            this.list = list;
        }
        //输出奇数
        @Override
        public void run() {
            synchronized (list) {
                while (true) {
                    if ((int)list.get(0)%2==0) {
                        try {
                            list.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    else
                    {
                        System.out.println(Thread.currentThread().getName() + "————————>" +list.get(0).toString());
                        list.set(0, (int)list.get(0)+1);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        list.notifyAll();
                    }
                }
            }
        }
    }
    static class Consumer implements Runnable
    {
        private List list;

        public Consumer(List list) {
            this.list = list;
        }
        //      输出偶数
        @Override
        public void run() {
            synchronized (list)
            {
                while(true)
                {
                    if(((int)list.get(0)%2)!=0)
                    {
                        try {
                            list.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    else
                    {
                        System.out.println(Thread.currentThread().getName()+"————————>"+list.get(0).toString());
                        list.set(0 ,(int)list.get(0)+1);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        list.notifyAll();
                    }

                }
            }
        }
    }
}