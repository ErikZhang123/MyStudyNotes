package ThreadDemo.WaitAndNotify;

import java.util.ArrayList;
import java.util.List;
/*
 * wait��notify������Thread���еķ�����������Object������
 * */
public class test {
    public static void main(String[] args) {
        List list = new ArrayList();
        Thread p = new Thread(new Producer(list));
        Thread c = new Thread(new Consumer(list));
        p.setName("�����ߣ�����������������>");
        c.setName("�����ߣ�����������������>");
        p.start();
        c.start();

    }

    /*�ó��򲻻��л�������ʱ��Ƭ�������������Ϊ��while��ѭ���б���ִ���ֱ꣬���ж����������waitΪֹ
     * ����һ�����������������������߲��ܽ������ѡ�
     * */
    static class Producer implements Runnable {
        private List list;
        static int i = 0;
        public Producer(List list) {
            this.list = list;
        }

        @Override//�����ߣ��ֿ�����Ϊ10
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

        @Override//������
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
