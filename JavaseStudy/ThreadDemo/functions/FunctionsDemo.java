package ThreadDemo.functions;

public class FunctionsDemo {
    public static void main(String[] args) {
//   1����ȡ/�޸��̶߳��������
        Thread t1 = new Thread(new Thread1());
        t1.getName();
//   2��  Ĭ���߳�����Ϊ Thread-i��i��0��ʼ���̶߳�������
        t1.setName("t1");
        System.out.println(t1.getName());
//   3�� ��ȡ��ǰ�߳�
        t1.start();
        Thread.currentThread();//���ص���һ��Thread����
        Thread t2 = Thread.currentThread();
        System.out.println( Thread.currentThread());
//   4������t1��main����ʱ��Ƭ
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
                System.out.println(Thread.currentThread().getName()+"������������>"+i);
            }
        }
    }
}