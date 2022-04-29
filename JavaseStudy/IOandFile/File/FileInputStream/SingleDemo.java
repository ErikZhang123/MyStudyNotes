package JavaseStudy.IOandFile.File.FileInputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/*
* FileInputStream最好使用demo2中的以数组为读取单位的方式，这样可以在设置好数组大小的前提下减少与内存的交互，提高效率
*
* */
public class SingleDemo {
        public static void main(String[] args) {
            FileInputStream fis = null;
            try {
                fis = new FileInputStream("C:\\Users\\10593\\Desktop\\新建文本文档.txt");
//            while(true)     用单个字符判断文本是否结束，其与内存交互太频繁，效率太低
//            {
//                int data = fis.read();
//                if(-1==data)
//                    break;
//                System.out.println(data);
//            }
//          改进while，虽然代码少了很多，但是与内存的交互并没有变少，因此效率依然很低
                int data = 0;//data作为中间变量，接收读取到的字节
                while ((data = fis.read()) != -1)//
                {
                    System.out.println(data);
                }
            } catch (FileNotFoundException e) {
                System.out.println("没有找到文件");
                ;
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
}
