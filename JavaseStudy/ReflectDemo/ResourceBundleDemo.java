package ReflectDemo;
/**
* java.util����
* ��Դ����ResourceBundle�����ڻ�ȡ�����ļ���.properties�ļ���
* ��ʹ�ø÷���ʱ�������ļ�����ŵ���·���£���src��
* */

import java.util.ResourceBundle;

public class ResourceBundleDemo {
    public static void main(String[] args) {

//       �ļ�·����������·���£����Ҳ��ܳ����ļ�����׺
//        ResourceBundle rb = ResourceBundle.getBundle("test");
//        ע�⣬�����·���Ǵ�src�ļ��¿�ʼ��,���ļ������ļ����У�����Ҫ������ʾ
        ResourceBundle rb = ResourceBundle.getBundle("ReflectDemo/Classinfo");

        String classname = rb.getString("className");
        try {
            Class c = Class.forName(classname);
            System.out.println(c.getSimpleName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(classname);
    }
}
