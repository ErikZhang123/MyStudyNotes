package JavaseStudy.ReflectDemo;

import java.lang.reflect.Field;
import java.util.ResourceBundle;

/**
 * 通过反射机制访问对象属性
 * 即获取修改对象属性的值
 *
 * 方法：
 * Field.set(Object obj , Object value)
 * Field.get(Object obj)
 * 但是该方法不能对private操作，会报错
 *
 * 如果非要访问private的属性，可以使用：
 * Field.setAccessible(true);
 * 该方法实际上启用和禁用访问安全检查的开关,并不是为true就能访问为false就不能访问
 *
 * Field.isAccessible();该方法返回true和false并非意味着反射对象属性是否能被访问
 * 值为true意味着指示反射的对象在使用时应该取消 Java 语言访问检查。值为 false 则指示反射的对象应该实施 Java 语言访问检查。
 * 由于JDK的安全检查耗时较多.所以通过setAccessible(true)的方式关闭安全检查就可以达到提升反射速度的目的
 */
public class GetandSetThroughReflection {
    public static void main(String[] args) {
            ResourceBundle rb = ResourceBundle.getBundle("ReflectDemo/Classinfo");
        try {
            Class c = Class.forName(rb.getString("className"));
            Object obj = c.newInstance();
//         在对属性进行操作的时候首先要用配置文件实例化对象
            Field[] fields=c.getDeclaredFields();
            for (Field f:fields
                 ) {
                if(f.getName().equals("age"))
                {
//                  也可以用Class.getDeclaredFields("")直接获取要操作的属性
                    f.set(obj,55);
                    System.out.println("年龄为："+f.get(obj));
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
