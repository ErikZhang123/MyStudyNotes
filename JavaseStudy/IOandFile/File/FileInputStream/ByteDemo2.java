package JavaseStudy.IOandFile.File.FileInputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ByteDemo2 {
    /**
     *
     * 字节流读取的改进版，以byte数组为读取单位
     * fis.read(byte[] b);返回读取到的数组长度
     * 使用String(byte[] b , int offset, int length)构造方法来转换数组到字符串，offset是从第几个字节开始读取。
     * 这里的byte设定为4，但是实际上可以根据情况扩大，以减少数组扩容的次数，提高效率
     *
     * */
        public static void main(String[] args) {
            FileInputStream fis = null;
            try {
                fis = new FileInputStream("C:\\Users\\10593\\Desktop\\新建文本文档.txt");
                byte[] b = new byte[4];
//                注意，每次读取数据的时候只读入byte[]数组大小的字节，多余的字节会从头将其他字节覆盖
//                因此在while循环中，使用datalength，来保证每次读取到几个字节就输出几个字节
                int datalength = 0;
                while ((datalength = fis.read(b)) != -1) {
                    System.out.print(new String(b, 0, datalength));
                    //若在输出的时候直接使用String(bytes)会导致数据错误，String(bytes)是将所有数据都转换，即全转换
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
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
