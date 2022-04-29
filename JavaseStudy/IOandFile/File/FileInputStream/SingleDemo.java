package JavaseStudy.IOandFile.File.FileInputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/*
* FileInputStream���ʹ��demo2�е�������Ϊ��ȡ��λ�ķ�ʽ���������������ú������С��ǰ���¼������ڴ�Ľ��������Ч��
*
* */
public class SingleDemo {
        public static void main(String[] args) {
            FileInputStream fis = null;
            try {
                fis = new FileInputStream("C:\\Users\\10593\\Desktop\\�½��ı��ĵ�.txt");
//            while(true)     �õ����ַ��ж��ı��Ƿ�����������ڴ潻��̫Ƶ����Ч��̫��
//            {
//                int data = fis.read();
//                if(-1==data)
//                    break;
//                System.out.println(data);
//            }
//          �Ľ�while����Ȼ�������˺ܶ࣬�������ڴ�Ľ�����û�б��٣����Ч����Ȼ�ܵ�
                int data = 0;//data��Ϊ�м���������ն�ȡ�����ֽ�
                while ((data = fis.read()) != -1)//
                {
                    System.out.println(data);
                }
            } catch (FileNotFoundException e) {
                System.out.println("û���ҵ��ļ�");
                ;
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
