package JavaseStudy.IOandFile.File.FileInputStream;

import java.io.FileInputStream;
import java.io.IOException;

public class OtherClass {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("C:\\Users\\10593\\Desktop\\新建文本文档.txt");
            int a = fileInputStream.available();//File.available() 返回int类型，返回流中剩余的字节数。
//          常用于new byte[]数组的时候使用，以估算byte[]数组的合适大小
//          但不适用于大文件，因为byte[]数组本身有长度限制
            System.out.println(a);
            long skips=4;
            byte[] b =new byte[36];
            int datalength =0 ;
            fileInputStream.skip(skips);
//          File.skip(long n);跳过几个字节不读，一般用于跳过固定格式的文件
//            切记不可跳过奇数个字节！！否则会读取中文时出错
            while( (datalength = fileInputStream.read(b))!=-1)
            {
                System.out.println(new String(b,0,datalength));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
