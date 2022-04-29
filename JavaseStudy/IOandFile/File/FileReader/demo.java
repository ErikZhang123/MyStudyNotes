package JavaseStudy.IOandFile.File.FileReader;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class demo {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("新建文本文件2.txt");
        char[] chr = new char[36];
        int num;
//      FileReader.read()读取到的是内容的ASCII码，所以需要强制转换成字符char类型输出
        num = fileReader.read();//一次读取一个字符
        System.out.println((char) num );
//      FileReader.read(char[] cbuf)该方法返回的是读取文件中剩余的字符数量。

//  注意：在未关闭流的情况下，如果前面已经读取了一定量的字符，那接下来会接着从后面读，而不会从头开始读
//        一次读取一个字符串
        int readnum;
        while((readnum = fileReader.read(chr))!=-1)
        {
            System.out.println(new String(chr,0,readnum));
        }
        fileReader.read(chr);
        fileReader.close();
    }
}
