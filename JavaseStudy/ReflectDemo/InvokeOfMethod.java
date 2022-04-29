package ReflectDemo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ResourceBundle;

/**
 * 使用反射机制调用方法：
 * Class.getDeclaredMethod(String name,CLASS ... ParameterType)
 *
 *
 * */
public class InvokeOfMethod
{
    public static void main(String[] args) {
        ResourceBundle rb = ResourceBundle.getBundle("ReflectDemo.Classinfo");
        try {
            Class c = Class.forName(rb.getString("className"));
            Object obj = c.newInstance();
            Method[] m = c.getMethods();
            for (Method method:m
                 ) {
                if(method.getName().equals("doSome"))
                {
                    Method m2 = c.getDeclaredMethod("doSome",method.getParameterTypes());
                    Object ret = m2.invoke(obj,"zhangsan",18,"playfootball");
                    System.out.println(ret);
                }
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
