package ReflectDemo;

import java.lang.reflect.Field;

/**
* ��ȡField�������ԣ������е��ֶΣ���Ա
* �磺private int age; ���ж�����Field����
* ����˵Field������������η����������ͣ��������Ƶȴ�������ʱ��Ԫ��
* ������
* 1��Class.getFields()                   /            Class.getField("������")
*  �����鷽ʽ��ȡ����������public���ε�����    /            �Ե���Ԫ�ط�ʽ��ȡ����������public���ε�����
*
* 2��Class.getDeclaredFields()         /           Class.getDeclaredField()
* *  �����鷽ʽ��ȡ������������            /            �Ե���Ԫ�ط�ʽ��ȡ������������
*
* 3��Class.getName()                 /           Class.getSimpleName()
*       ��ȡ��ȫ��                   /             ��ȡ��ļ�����
 *  */
public class getField {
    public static void main(String[] args) {
        student1 s = new student1();
        Class c = s.getClass();
        for (Object object:  c.getFields()  ) {
            System.out.println(object);
//        ֻ�����public���ε�����
////        public java.lang.String JavaseStudy.ReflectDemo.student.name
        }
        for (Field field:  c.getDeclaredFields() ) {
            System.out.println(field.getName());
        }
//        ȫ�������,��getFields()������϶���Ϣ����getDeclaredFields()ֻ���������Ϣ
//        ��Ҫ����toString������д�Ĳ�һ��
//        name
//        age
        System.out.println(c.getName());
        System.out.println(c.getSimpleName());
//        getName�Ὣ�����и����һ�������JavaseStudy.ReflectDemo.student
//        ��getSimpleNameֻ�����������student
    }
}
class student1{
    public String name="����";
    private int age=18;
}
