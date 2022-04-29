package ReflectDemo.methodDemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class invocation1 implements InvocationHandler {
    private Object target;

    public invocation1(Object target) {
        this.target = target;
    }
    Object res = null;
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        res = method.invoke(target,"zhangsan");
        return res.toString();
    }
}
