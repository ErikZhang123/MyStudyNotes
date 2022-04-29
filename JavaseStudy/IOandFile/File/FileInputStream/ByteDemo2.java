package JavaseStudy.IOandFile.File.FileInputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ByteDemo2 {
    /**
     *
     * �ֽ�����ȡ�ĸĽ��棬��byte����Ϊ��ȡ��λ
     * fis.read(byte[] b);���ض�ȡ�������鳤��
     * ʹ��String(byte[] b , int offset, int length)���췽����ת�����鵽�ַ�����offset�Ǵӵڼ����ֽڿ�ʼ��ȡ��
     * �����byte�趨Ϊ4������ʵ���Ͽ��Ը�����������Լ����������ݵĴ��������Ч��
     *
     * */
        public static void main(String[] args) {
            FileInputStream fis = null;
            try {
                fis = new FileInputStream("C:\\Users\\10593\\Desktop\\�½��ı��ĵ�.txt");
                byte[] b = new byte[4];
//                ע�⣬ÿ�ζ�ȡ���ݵ�ʱ��ֻ����byte[]�����С���ֽڣ�������ֽڻ��ͷ�������ֽڸ���
//                �����whileѭ���У�ʹ��datalength������֤ÿ�ζ�ȡ�������ֽھ���������ֽ�
                int datalength = 0;
                while ((datalength = fis.read(b)) != -1) {
                    System.out.print(new String(b, 0, datalength));
                    //���������ʱ��ֱ��ʹ��String(bytes)�ᵼ�����ݴ���String(bytes)�ǽ��������ݶ�ת������ȫת��
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
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
