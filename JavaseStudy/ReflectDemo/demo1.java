package JavaseStudy.ReflectDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
/**
*
*ͨ���������ʵ��������
*
* 1��Class.newInstance();  �÷����Ѿ���ʱ
*   �÷������ҽ�������Խ�����޲ι��췽��
*   ������ֻ�����вι����û���޲ι���ʱ�ᱨ��
*
* ʹ�÷������ʵ���������ԭ���ǣ�
* 1������� �ڲ��ı�java����������ͨ���ı������ļ�����ʹ�䴴����ͬ���͵�java����
* ����OCP ������ԭ�򣺶���չ���ţ����޸Ĺر�
*/
public class demo1 {
    public static void main(String[] args) {
//        1��IO��ȡ�����ļ�
        try {
            FileInputStream fis = new FileInputStream("D:\\IDEA\\src\\JavaseStudy\\ReflectDemo\\Classinfo.properties");
//        2���������������Map
            Properties pro = new Properties();
//        3������I/O��
            pro.load(fis);
//        4���ر���
            fis.close();
//        5��ͨ��key��ȡvalue
            String className = pro.getProperty("className");
//        6��ͨ��������ƻ�ȡClass��ͨ��Classʵ��������
//            Class c = Class.forName("JavaseStudy.ReflectDemo.User");
            Class c = Class.forName(className);
            Object obj = c.newInstance();
//            ֱ�������������+��ֵַ�����������ļ��еĶ������Ϳ��Ա��������������͡�
            System.out.println(obj);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

}
