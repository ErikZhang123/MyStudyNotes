package Service;

public class Service01 implements MyService{
    public Service01(){
        System.out.println("Constructor of Service01 is working.");
    }
    //通过在MyTest中，人为主动调用
    public void doSome(){
        System.out.println("Service01 is working.");
    }
}
