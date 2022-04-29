package PloymorphicDemo;

/*
* instance of ???????????????ж????????????????
* ????
* boolean ?????? instanceof ?????
* true???????????????е????????????????
* false??????
*
* ???????????????????ClassCastException
* ???????????????????????????????????ж???????????????
* */
public class InstanceOfDemo {
    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal cat = new Cat();
        Animal a = dog;
        Animal b = cat;
        doSome(b);
//        b.CatchMouse();多态时无法使用子类的特有方法
    }
    public static void doSome(Animal animal)
    {
        if(animal instanceof Dog)
        {
            Dog dog = (Dog)animal;
            ((Dog) animal).bitebite();
        }
        if(animal instanceof Cat)
        {
            Cat cat = (Cat) animal;
//            ((Cat) animal).CatchMouse();
            cat.CatchMouse();
        }
    }
}