package PloymorphicDemo;
/*
* 多态的前提：
* 子类继承父类
* 方法重写
* 父类引用指向子类对象
*
* 向上/下转向
* */
public class PloymorphicDemo {
    public static void main(String[] args) {
        Animal a = new Dog();//向上转型，即将右边的子类暂时升级为父类
        //java会读取左边父类中的方法，对象等，因此子类中特有的方法不能被调用
        a.doSome();
        System.out.println(a.tpye);
        Dog d = (Dog)a;//向下转型，即将右边的父类暂时转为子类
        //向下转型有风险。当转型双方并没有继承关系的时候会报错ClassCastException
//        如：Cat c = (Cat) a;

    }
}

