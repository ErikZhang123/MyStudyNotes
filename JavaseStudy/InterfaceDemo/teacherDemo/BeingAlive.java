package InterfaceDemo.teacherDemo;

public interface BeingAlive {
//    int age;
    static int age =10;
    final double pie = 3.15;
/**接口中虽然不可以有变量，但是接口中可以存在静态变量（即static和final修饰的变量）*/

}

interface Sport {
    public abstract void play();
}

interface Sleep extends BeingAlive,Sport {
    public abstract void sleep();
}
