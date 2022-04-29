package ReflectDemo.methodDemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class test {
    public static void main(String[] args) {
        gongneng g = new gongneng1();
        InvocationHandler invocationHandler = new invocation1(g);

        gongneng proxy = (gongneng) Proxy.newProxyInstance(g.getClass().getClassLoader(),
                g.getClass().getInterfaces(),
                invocationHandler);
        System.out.println(proxy.hello("zhangsan"));
    }
}
