package ReflectDemo;

import java.lang.reflect.Field;

/**
* 获取Field反射属性，即类中的字段，成员
* 如：private int age; 整行都属于Field对象
* 可以说Field对象包含了修饰符，数据类型，变量名称等创建变量时的元素
* 方法：
* 1、Class.getFields()                   /            Class.getField("属性名")
*  以数组方式获取类中所有用public修饰的属性    /            以单个元素方式获取类中所有用public修饰的属性
*
* 2、Class.getDeclaredFields()         /           Class.getDeclaredField()
* *  以数组方式获取类中所有属性            /            以单个元素方式获取类中所有属性
*
* 3、Class.getName()                 /           Class.getSimpleName()
*       获取类全名                   /             获取类的简单名称
 *  */
public class getField {
    public static void main(String[] args) {
        student1 s = new student1();
        Class c = s.getClass();
        for (Object object:  c.getFields()  ) {
            System.out.println(object);
//        只输出有public修饰的属性
////        public java.lang.String JavaseStudy.ReflectDemo.student.name
        }
        for (Field field:  c.getDeclaredFields() ) {
            System.out.println(field.getName());
        }
//        全都输出了,但getFields()会输出较多信息，而getDeclaredFields()只会输出简单信息
//        主要在于toString方法重写的不一样
//        name
//        age
        System.out.println(c.getName());
        System.out.println(c.getSimpleName());
//        getName会将其所有父类包一起输出：JavaseStudy.ReflectDemo.student
//        而getSimpleName只会输出类名：student
    }
}
class student1{
    public String name="张三";
    private int age=18;
}
