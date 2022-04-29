package JavaseStudy.ReflectDemo;

import java.lang.reflect.Field;
import java.util.ResourceBundle;

/**
 * ͨ��������Ʒ��ʶ�������
 * ����ȡ�޸Ķ������Ե�ֵ
 *
 * ������
 * Field.set(Object obj , Object value)
 * Field.get(Object obj)
 * ���Ǹ÷������ܶ�private�������ᱨ��
 *
 * �����Ҫ����private�����ԣ�����ʹ�ã�
 * Field.setAccessible(true);
 * �÷���ʵ�������úͽ��÷��ʰ�ȫ���Ŀ���,������Ϊtrue���ܷ���Ϊfalse�Ͳ��ܷ���
 *
 * Field.isAccessible();�÷�������true��false������ζ�ŷ�����������Ƿ��ܱ�����
 * ֵΪtrue��ζ��ָʾ����Ķ�����ʹ��ʱӦ��ȡ�� Java ���Է��ʼ�顣ֵΪ false ��ָʾ����Ķ���Ӧ��ʵʩ Java ���Է��ʼ�顣
 * ����JDK�İ�ȫ����ʱ�϶�.����ͨ��setAccessible(true)�ķ�ʽ�رհ�ȫ���Ϳ��Դﵽ���������ٶȵ�Ŀ��
 */
public class GetandSetThroughReflection {
    public static void main(String[] args) {
            ResourceBundle rb = ResourceBundle.getBundle("ReflectDemo/Classinfo");
        try {
            Class c = Class.forName(rb.getString("className"));
            Object obj = c.newInstance();
//         �ڶ����Խ��в�����ʱ������Ҫ�������ļ�ʵ��������
            Field[] fields=c.getDeclaredFields();
            for (Field f:fields
                 ) {
                if(f.getName().equals("age"))
                {
//                  Ҳ������Class.getDeclaredFields("")ֱ�ӻ�ȡҪ����������
                    f.set(obj,55);
                    System.out.println("����Ϊ��"+f.get(obj));
                }
            }
            for (Field field:fields
                 ) {
                System.out.println(field.getName()+" is "+field.isAccessible());
                if(!field.isAccessible()) {
                    field.setAccessible(true);
                    System.out.println(field.getName()+"===="+field.get(obj));
                }
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
