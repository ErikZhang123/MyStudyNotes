package AnonymousDemoAndLambdas.EvenOrOdd;
interface t{
    public abstract boolean isEven(int a);
    default boolean isOdd(int a){
        return  !isEven(a);//接口的default方法可以使用抽象方法。
    }
}
public class EvenOrOdd {
    public static void main(String[] args) {
//        t t1 = (a) -> {
//            return a%2==0;
//        };
        t t1 = a -> a%2 ==0;//仍然需要通过lambda实现其抽象方法
        //当lambda中只有一个变量的时候可以不用写括号
        System.out.println(t1.isEven(4));
        System.out.println(t1.isEven(5));
        System.out.println(t1.isEven(10));
        System.out.println(t1.isOdd(21));
    }
}
