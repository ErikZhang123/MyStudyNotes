package JavaseStudy.IOandFile.File.FileInputStream;

import java.io.FileInputStream;
import java.io.IOException;

public class OtherClass {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("C:\\Users\\10593\\Desktop\\�½��ı��ĵ�.txt");
            int a = fileInputStream.available();//File.available() ����int���ͣ���������ʣ����ֽ�����
//          ������new byte[]�����ʱ��ʹ�ã��Թ���byte[]����ĺ��ʴ�С
//          ���������ڴ��ļ�����Ϊbyte[]���鱾���г�������
            System.out.println(a);
            long skips=4;
            byte[] b =new byte[36];
            int datalength =0 ;
            fileInputStream.skip(skips);
//          File.skip(long n);���������ֽڲ�����һ�����������̶���ʽ���ļ�
//            �мǲ��������������ֽڣ���������ȡ����ʱ����
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
