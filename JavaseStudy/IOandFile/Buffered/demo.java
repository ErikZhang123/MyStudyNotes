package IOandFile.Buffered;

import java.io.*;

public class demo {
    /*
    * 缓冲流的特有功能
    * BufferedReader.ReadLine：一次读取一行，但不读取换行符，循环终止条件可以为！=null
    * BufferedWriter.newLine：写一个换行符，这个换行符由系统决定
    * 因为不同系统的换行符不一样：
    * windows：\r\n
    * linux:\n
    * mac:\r
    *
    * */
    public static void main(String[] args) throws IOException {
        BufferedWriter BufferWriter = new BufferedWriter(new FileWriter("新建文件夹.txt"));
        String str = "张三";
        BufferWriter.write(str);
        BufferWriter.newLine();
        BufferWriter.write("李四");
        BufferWriter.flush();
        BufferWriter.close();

        BufferedReader bufferedReader = new BufferedReader(new FileReader("新建文件夹.txt"));
        System.out.println(bufferedReader.readLine());

        bufferedReader.close();

    }
}
