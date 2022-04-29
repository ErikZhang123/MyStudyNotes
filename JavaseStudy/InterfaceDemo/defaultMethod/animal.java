package InterfaceDemo.defaultMethod;

public interface animal {
//jdk8以后的新特性，在接口中可以存在default修饰的实例方法，子类可以直接使用接口中的default方法。
//    default方法可以被重写。
//    但是，如果子类同时实现了两个接口，且两个接口中有同名的default方法，则子类必须重写该方法
    public default void talking(){
        System.out.println("hello");
    }
}
interface life {
//    public default void talking(){
//        System.out.println("hello");
//    }
}

class dog implements animal,life{
    public static void main(String[] args) {
        dog d = new dog();
        d.talking();
    }
//由于此时life和animal中都有default方法，且同名，因此dog中必须重写default方法
//    @Override
//    public void talking() {
//
//    }
}
