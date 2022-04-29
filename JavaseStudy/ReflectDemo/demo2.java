package ReflectDemo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 Thread.currentThread().getContextClassLoader().getResourceAsStream
* 写路径的通用方式，直接以流的形式返回
* 以后写路径都用这个方法
 * 因为这种方法比较通用，因为使用CopyPath的方法只能在windows下使用，但是该方法是所有系统通用的
 * 但前提是这个文件必须在类路径下，即src下
 * Thread.currentThread()获取当前对象
 * .getContextClassLoader() 当前对象的方法们可以获取当前线程的类加载器对象
 * .getResourceAsStream(String string)获取资源，类加载器对象的方法，当前线程的类加载器默认从类的根路径下加载资源
*/
public class demo2 {
    public static void main(String[] args) {
        InputStream reader = Thread.currentThread().getContextClassLoader().getResourceAsStream
                ("JavaseStudy/ReflectDemo/Classinfo.properties");
//        该代码实际上是获取了文件的绝对路径
        Properties properties = new Properties();
        try {
            properties.load(reader);
            reader.close();
            System.out.println(properties.getProperty("className"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
