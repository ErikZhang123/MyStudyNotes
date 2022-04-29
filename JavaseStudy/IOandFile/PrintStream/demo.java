package IOandFile.PrintStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/*
* 标准字节输出流
* 默认输出到控制台，该流不需要手动关闭
* 可用于log日志工具的实现
* */
public class demo
{
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream printStream = new PrintStream(new FileOutputStream("log.txt"));
        System.setOut(printStream);//用System.setOut(PrintStream);方法，将输出的方向改为log文件；
//        即修改了println输出的目的地，再输出
        System.out.println("张三");
    }
}
