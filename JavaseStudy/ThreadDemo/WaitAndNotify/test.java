package ThreadDemo.WaitAndNotify;

import java.util.ArrayList;
import java.util.List;
/*
 * wait和notify并不是Thread特有的方法，他们是Object方法。
 * */
public class test {
    public static void main(String[] args) {
        List list = new ArrayList();
        Thread p = new Thread(new Producer(list));
        Thread c = new Thread(new Consumer(list));
        p.setName("生产者：————————>");
        c.setName("消费者：————————>");
        p.start();
        c.start();

    }

    /*该程序不会有互相抢夺时间片的情况发生，因为在while死循环中必须执行完，直到判断条件满足后wait为止
     * 所以一定是生产者生产满后消费者才能进行消费。
     * */
    static class Producer implements Runnable {
        private List list;
        static int i = 0;
        public Producer(List list) {
            this.list = list;
        }

        @Override//生产者，仓库容量为10
        public void run() {
            synchronized (list) {
                while (true) {
                    if (list.size() > 100) {
                        try {
                            list.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    Object obj = i++;
                    if (i >2) i = 0;
                    list.add(obj);
                    System.out.println(Thread.currentThread().getName() + obj);
                    list.notifyAll();
                }
            }
        }
    }

    static class Consumer implements Runnable {
        private List list;

        public Consumer(List list) {
            this.list = list;
        }

        @Override//消费者
        public void run() {
            synchronized (list) {
                while (true) {
                    if (list.size() == 0) {
                        try {
                            list.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    Object removename = list.remove(list.size()-1);
                    System.out.println(Thread.currentThread().getName() + removename.toString());
                    list.notifyAll();
                }
            }
        }
    }
}
