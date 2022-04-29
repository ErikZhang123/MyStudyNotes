package abstractdemo.abstractdemo;
/*
 * 关键字：abstract
 * 抽象类：没有方法体的方法，其方法是靠子类实现的
 * */
public class abstractdemo {
	public static void main(String[] args) {
	//	Animal a = new Animal(); 抽象类无法创建对象
		Animal a = new dog();
		a.age();
	}
}

abstract class Animal
{
	//可以拥有自己的属性和非抽象方法
	int age=18;
	final double Pi=3.14;
	abstract public void eat();
	abstract public void age();
	public void sex()//父类中的非抽象方法不用在子类中重写
	{ }
}

//如果父代为抽象类，那么子代需要重写父代中的所有子类
class dog extends Animal 
{
	public void eat()
	{
		System.out.println("狗吃屎");
	}
	public void age()
	{
		System.out.println(age);
	}
}

abstract class cat extends Animal //如果子类也为抽象类，则不用重写父类中的抽象方法
{
	int age=20;
	public void eatfish()
	{
		System.out.println("猫吃鱼");
	}
}