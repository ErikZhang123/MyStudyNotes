package JavaseStudy.IOandFile.File.FileOutPutStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class demo {
    /*
字节输出流，当写入文件不存在的时候会自动新建一个对应名字的文件
写完以后一定注意需要刷新文件，以防有数据仍然在通道内，造成数据丢失
*/
        public static void main(String[] args) {
            //构造方法1：fos = new FileOutputStream(String name)
            //但这种方式很少使用，因为他在创建文件的时候会将原文件清空
//      构造方法2
//      FileOutputStream fileOutputStream = new FileOutputStream(String name,boolean append)
//      该方法再append为true时可以在文件末尾处写入，这样可以确保不会覆盖原文件
            FileOutputStream fileOutputStream = null;
            try {
                fileOutputStream = new FileOutputStream("C:\\Users\\10593\\Desktop\\新建文本文档.txt", true);
                String str = "张三dsiugadf";
                fileOutputStream.write(str.getBytes());
                fileOutputStream.flush();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
