package AnonymousDemoAndLambdas;
//只有一个抽象方法的interface叫做functional interface
interface funtional_interface {
    void talking();
    public default void speaking(){
        talking();
        //default中可以用抽象方法，但在使用lambdas时不能在函数体中使用default方法
    }
}

class test {
    public static void main(String[] args) {
        funtional_interface a = () -> {
        //函数体
            System.out.println("hello");
        };
        a.talking();
    }
}
