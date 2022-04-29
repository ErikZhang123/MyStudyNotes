package InnerClass;

public class InnerClassTest {
    public static void main(String[] args) {
        int a =10;
//        创建匿名内部类对象
        demo1 d = new demo1();
        demo1.eat g = d.new eat();
        String.valueOf("");
    }
}
class demo1
{

    private int b=100;
    private String name = "张三";
    class eat//内部类，其.class文件被$与外部类名称所标记
    {
        public void eating()
        {
            System.out.println(name+b);//内部类可以调用外部类当中的成员，无论是否为private
        }
    }
}
