package JavaseStudy.IOandFile.File.FileWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class demo {
    public static void main(String[] args) throws IOException {
        FileWriter fileWriter = new FileWriter(new File("新建文本文件2.txt"),true);
        //该构造方法使用来允许在文件后附加写入，而并非清空文件后写入
        fileWriter.write("张三");
        fileWriter.flush();//flush会刷新缓冲区，将流中的数据全部输出。
        fileWriter.close();//close会直接关闭流，可能导致数据丢失。

    }
}
