package ReflectDemo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 Thread.currentThread().getContextClassLoader().getResourceAsStream
* д·����ͨ�÷�ʽ��ֱ����������ʽ����
* �Ժ�д·�������������
 * ��Ϊ���ַ����Ƚ�ͨ�ã���Ϊʹ��CopyPath�ķ���ֻ����windows��ʹ�ã����Ǹ÷���������ϵͳͨ�õ�
 * ��ǰ��������ļ���������·���£���src��
 * Thread.currentThread()��ȡ��ǰ����
 * .getContextClassLoader() ��ǰ����ķ����ǿ��Ի�ȡ��ǰ�̵߳������������
 * .getResourceAsStream(String string)��ȡ��Դ�������������ķ�������ǰ�̵߳��������Ĭ�ϴ���ĸ�·���¼�����Դ
*/
public class demo2 {
    public static void main(String[] args) {
        InputStream reader = Thread.currentThread().getContextClassLoader().getResourceAsStream
                ("JavaseStudy/ReflectDemo/Classinfo.properties");
//        �ô���ʵ�����ǻ�ȡ���ļ��ľ���·��
        Properties properties = new Properties();
        try {
            properties.load(reader);
            reader.close();
            System.out.println(properties.getProperty("className"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
