package JavaseStudy.IOandFile.File.FileOutPutStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class demo {
    /*
�ֽ����������д���ļ������ڵ�ʱ����Զ��½�һ����Ӧ���ֵ��ļ�
д���Ժ�һ��ע����Ҫˢ���ļ����Է���������Ȼ��ͨ���ڣ�������ݶ�ʧ
*/
        public static void main(String[] args) {
            //���췽��1��fos = new FileOutputStream(String name)
            //�����ַ�ʽ����ʹ�ã���Ϊ���ڴ����ļ���ʱ��Ὣԭ�ļ����
//      ���췽��2
//      FileOutputStream fileOutputStream = new FileOutputStream(String name,boolean append)
//      �÷�����appendΪtrueʱ�������ļ�ĩβ��д�룬��������ȷ�����Ḳ��ԭ�ļ�
            FileOutputStream fileOutputStream = null;
            try {
                fileOutputStream = new FileOutputStream("C:\\Users\\10593\\Desktop\\�½��ı��ĵ�.txt", true);
                String str = "����dsiugadf";
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
