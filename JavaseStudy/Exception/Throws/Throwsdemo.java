package JavaseStudy.Exception.Throws;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Throwsdemo {
    public static void main(String[] args) {
        FileInputStream f = null;//声明放在try的外面是为了在finally中可以调用，以关闭输入流
        try {
            f = new FileInputStream("E:\\新建文本文档.txt");
            //开始读文件
            String s ;
            s = null;
            s.toString();//此处一定会出现空指针异常，但是因为其属于运行时异常，所以在编写程序的时候可以不用处理
            //此处出现空指针异常以后，直接跳转至catch中执行
            //IO流在使用完以后必须关闭IO流，不然会造成内存的资源占用
            //而放在此处的话会无法关闭IO流。所以使用finally语句来执行IO的关闭
            System.out.println("HelloWorld");//该行代码不会执行

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (NullPointerException e)
        {
            e.printStackTrace();
        }
        finally {
            if(f != null)
            {
                try {
                    System.out.println("准备关闭");
                    f.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
}
}
