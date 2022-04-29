package ThreadDemo.ThreadDemo;

public class Threadtest {
    public static void main(String[] args) {
        /*注意线程和进程的区别
         * 进程是一个应用程序/一个软件
         * 线程是一个进程中的执行场景/执行单元
         *一个进程可以启动多个线程
         *  */
        ThreadDemo1 t1 = new ThreadDemo1();
        t1.start();
        //注意：实现Runnable接口的对象需要被封装成一个线程对象才可以作为线程启动
//        否则和main中直接调用方法是一样的，并不会启动线程
        Runnable t2 = new ThreadDemo2();
        Thread T2 = new Thread(t2);
//      这里t2.run();就是直接调用方法而没有创建线程，只有T2.start();是开启线程的
        t2.run();
        T2.start();

//        匿名内部类,与使用Runnable接口类似
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
            }
        });

        for (int i = 0; i < 1000; i++) {
            System.out.println("main Thread————>" + i);
        }

    }
}
    //实现线程的三种方式
    //1、继承Thread
     class ThreadDemo1 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++)
                System.out.println("subThread————>" + i);
        }
    }

    //2、实现Runnable接口，在建立对象的时候将其封装成一个线程对象
    class ThreadDemo2 implements Runnable {

        @Override
        public void run() {
//        run方法中的异常是不能throws的，只能try..catch
//            FileInputStream fis = null;
//            FileOutputStream fos = null;
//            byte[] b = new byte[1024*1024];
//            int readCount;
//                fis = new FileInputStream("C:\\Users\\10593\\Desktop\\文件\\出国资料\\ucla资料.zip");
//                fos = new FileOutputStream("E:\\copy\\ucla资料.zip");

        }
    }

