package EnumDemo;

public class enumdemo {
    public static void main(String[] args) {
        TrafficLight t = new TrafficLight();
        System.out.println(t.change());
        System.out.println(t.change());
        System.out.println(t.change());
    }
}

class TrafficLight{
     lightcolour lc ;//表示lc这个变量的内容存在于lightcolour

    public TrafficLight(){
        lc = lc.red;
//        lc = lc.blue; // 报错，需要在enum中创建对应成员

    }

    public lightcolour change(){
        lc = lc.changecolor();//enum可以使用其自身的方法
        return lc;
    }
}