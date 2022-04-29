package ReflectDemo;
/**
* java.util包下
* 资源绑定器ResourceBundle，用于获取配置文件即.properties文件。
* 在使用该方法时，配置文件必须放到类路径下，即src下
* */

import java.util.ResourceBundle;

public class ResourceBundleDemo {
    public static void main(String[] args) {

//       文件路径必须在类路径下，并且不能出现文件名后缀
//        ResourceBundle rb = ResourceBundle.getBundle("test");
//        注意，这里的路径是从src文件下开始的,若文件在子文件夹中，则需要如下所示
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
