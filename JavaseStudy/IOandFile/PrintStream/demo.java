package IOandFile.PrintStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/*
* ��׼�ֽ������
* Ĭ�����������̨����������Ҫ�ֶ��ر�
* ������log��־���ߵ�ʵ��
* */
public class demo
{
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream printStream = new PrintStream(new FileOutputStream("log.txt"));
        System.setOut(printStream);//��System.setOut(PrintStream);������������ķ����Ϊlog�ļ���
//        ���޸���println�����Ŀ�ĵأ������
        System.out.println("����");
    }
}
