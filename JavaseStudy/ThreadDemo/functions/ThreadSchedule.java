package ThreadDemo.functions;
/*
* java中常见的线程调度模型有：
* 1、均分式
* 2、抢夺式：线程优先级越高，抢到CUP时间片的概率就越高
* 即，使线程处于运行状态时的时间会多一些
*
* 线程调度的相关方法有
* 1、void setPriority(int newPriority) 设置线程优先级，最低为1，默认为5，最高为10
* 2、int getPriority();获取优先级当前正在执行的线程，并执
* 3、static void yield();让位方法，暂停行其他线程
* 让位方法是使线程从“运行状态”回到"就绪状态"，但并不是进入阻塞状态
* 是有可能再次抢到时间片的，而阻塞状态的下一次抢夺必定无法抢夺到时间片
*
* * */
public class ThreadSchedule {
    public static void main(String[] args) {
        Thread t1 = new MyThread2();
        Thread t2 = new MyThread2();
        t1.setName("Priority");
        t2.setName("t2");
//        t1.setPriority(10);
        t1.start();
        t2.start();
//        System.out.println("t1"+t1.getPriority());
//        System.out.println("t2"+t2.getPriority());


    }
}
class MyThread2 extends Thread
{
    @Override
    public void run() {
//        for(int i=0;i<10000;i++)
        System.out.println(Thread.currentThread().getName()+"——————>");

    }
}

