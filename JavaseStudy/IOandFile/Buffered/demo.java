package IOandFile.Buffered;

import java.io.*;

public class demo {
    /*
    * �����������й���
    * BufferedReader.ReadLine��һ�ζ�ȡһ�У�������ȡ���з���ѭ����ֹ��������Ϊ��=null
    * BufferedWriter.newLine��дһ�����з���������з���ϵͳ����
    * ��Ϊ��ͬϵͳ�Ļ��з���һ����
    * windows��\r\n
    * linux:\n
    * mac:\r
    *
    * */
    public static void main(String[] args) throws IOException {
        BufferedWriter BufferWriter = new BufferedWriter(new FileWriter("�½��ļ���.txt"));
        String str = "����";
        BufferWriter.write(str);
        BufferWriter.newLine();
        BufferWriter.write("����");
        BufferWriter.flush();
        BufferWriter.close();

        BufferedReader bufferedReader = new BufferedReader(new FileReader("�½��ļ���.txt"));
        System.out.println(bufferedReader.readLine());

        bufferedReader.close();

    }
}
