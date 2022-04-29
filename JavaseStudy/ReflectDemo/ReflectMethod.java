package ReflectDemo;

import java.lang.reflect.Method;
import java.util.ResourceBundle;

/**
 * 反射方法(Method)
 * 需要用到Class中的方法：
 * 1、Class.getDeclaredMethods() 返回一个Methods[]数组；
 * 注意：该方法会将类中所有的方法都列举出来，包括Object类中自带的方法
 * 如：wait，notify，hashCode等默认方法也会被查出来
 *
 * 需要使用Method类中的方法
 * 1、Method.getReturnType();     返回int类型
 * 需要用Method.getReturnType.getSimpleName();转换成为字符串
 *
 * 2、Method.getName();           返回String类型，返回方法名称
 *
 * 3、Method.getParameterTypes();    返回一个Class[]数组，长度可能为0，即参数列表个数为0；
 *  需要用Method.ParameterTypes().getSimpleName();输出参数名
 * */
public class ReflectMethod {
    public static void main(String[] args) {
        ResourceBundle rb = ResourceBundle.getBundle("JavaseStudy.ReflectDemo.Classinfo");
        try {
            Class c = Class.forName(rb.getString("className"));
            Method[] m = c.getMethods();
            for (Method method:m
                 ) {
                System.out.println("方法名称为"+method.getName());
                System.out.println("方法的返回类型为："+method.getReturnType().getSimpleName());
                System.out.println("参数列表类型为：");
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
