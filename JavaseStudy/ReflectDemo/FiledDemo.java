package ReflectDemo;

import java.lang.*;
import java.lang.reflect.*;


/**
* ���ڻ�ȡField�����һЩ���ԣ����������ͣ����η���
* ���÷�����
* 1����ȡField��������
*       Field.getName();
* 2����ȡ���͵ķ�����
*       Field.getType(); ����Class����
*       Ȼ����Class���͵�getSimpleName����
*3����ȡ���η�
*       Field.getModifier(); ����int���ͣ�ÿ��int���ֶ������η��Ĵ���
* ͨ��java.lang.reflect.Modifier��toString�������Խ���ת��Ϊ�ַ���
*       Modifier.toString( int Field.getModifier());
* */
public class FiledDemo {
    public static void main(String[] args) {
        Student s = new Student();
        Class c = s.getClass();
        Field[] fields = c.getDeclaredFields();
        for (Field f: fields) {
            System.out.println("��������"+f.getName()+",��������"+f.getType()+",���η�"+ Modifier.toString(f.getModifiers()));
        }
    }
}
