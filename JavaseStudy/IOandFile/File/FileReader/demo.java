package JavaseStudy.IOandFile.File.FileReader;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class demo {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("�½��ı��ļ�2.txt");
        char[] chr = new char[36];
        int num;
//      FileReader.read()��ȡ���������ݵ�ASCII�룬������Ҫǿ��ת�����ַ�char�������
        num = fileReader.read();//һ�ζ�ȡһ���ַ�
        System.out.println((char) num );
//      FileReader.read(char[] cbuf)�÷������ص��Ƕ�ȡ�ļ���ʣ����ַ�������

//  ע�⣺��δ�ر���������£����ǰ���Ѿ���ȡ��һ�������ַ����ǽ���������ŴӺ�������������ͷ��ʼ��
//        һ�ζ�ȡһ���ַ���
        int readnum;
        while((readnum = fileReader.read(chr))!=-1)
        {
            System.out.println(new String(chr,0,readnum));
        }
        fileReader.read(chr);
        fileReader.close();
    }
}
