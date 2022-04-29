package ReflectDemo;

import java.lang.reflect.Method;
import java.util.ResourceBundle;

/**
 * ���䷽��(Method)
 * ��Ҫ�õ�Class�еķ�����
 * 1��Class.getDeclaredMethods() ����һ��Methods[]���飻
 * ע�⣺�÷����Ὣ�������еķ������оٳ���������Object�����Դ��ķ���
 * �磺wait��notify��hashCode��Ĭ�Ϸ���Ҳ�ᱻ�����
 *
 * ��Ҫʹ��Method���еķ���
 * 1��Method.getReturnType();     ����int����
 * ��Ҫ��Method.getReturnType.getSimpleName();ת����Ϊ�ַ���
 *
 * 2��Method.getName();           ����String���ͣ����ط�������
 *
 * 3��Method.getParameterTypes();    ����һ��Class[]���飬���ȿ���Ϊ0���������б����Ϊ0��
 *  ��Ҫ��Method.ParameterTypes().getSimpleName();���������
 * */
public class ReflectMethod {
    public static void main(String[] args) {
        ResourceBundle rb = ResourceBundle.getBundle("JavaseStudy.ReflectDemo.Classinfo");
        try {
            Class c = Class.forName(rb.getString("className"));
            Method[] m = c.getMethods();
            for (Method method:m
                 ) {
                System.out.println("��������Ϊ"+method.getName());
                System.out.println("�����ķ�������Ϊ��"+method.getReturnType().getSimpleName());
                System.out.println("�����б�����Ϊ��");
                for (Class c2 :method.getParameterTypes()
                     ) {
                    System.out.println(c2.getSimpleName());
                }
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
