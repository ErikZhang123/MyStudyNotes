package ReflectDemo;

import java.lang.*;
import java.lang.reflect.*;


/**
* 关于获取Field对象的一些属性，如数据类型，修饰符等
* 常用方法：
* 1、获取Field对象名：
*       Field.getName();
* 2、获取类型的方法：
*       Field.getType(); 返回Class类型
*       然后用Class类型的getSimpleName方法
*3、获取修饰符
*       Field.getModifier(); 返回int类型，每个int数字都是修饰符的代号
* 通过java.lang.reflect.Modifier的toString方法可以将其转换为字符串
*       Modifier.toString( int Field.getModifier());
* */
public class FiledDemo {
    public static void main(String[] args) {
        Student s = new Student();
        Class c = s.getClass();
        Field[] fields = c.getDeclaredFields();
        for (Field f: fields) {
            System.out.println("属性名称"+f.getName()+",数据类型"+f.getType()+",修饰符"+ Modifier.toString(f.getModifiers()));
        }
    }
}
