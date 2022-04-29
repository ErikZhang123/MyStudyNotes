package ReflectDemo.methodDemo;

public class gongneng1 implements gongneng{
    @Override
    public String hello(String name) {
        System.out.println("hello"+name);
        return name;
    }
    public void nihao(String name){
        System.out.println("nihao"+name);
    }
}
