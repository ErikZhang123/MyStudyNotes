package abstractdemo.abstractdemo;
/*
 * �ؼ��֣�abstract
 * �����ࣺû�з�����ķ������䷽���ǿ�����ʵ�ֵ�
 * */
public class abstractdemo {
	public static void main(String[] args) {
	//	Animal a = new Animal(); �������޷���������
		Animal a = new dog();
		a.age();
	}
}

abstract class Animal
{
	//����ӵ���Լ������Ժͷǳ��󷽷�
	int age=18;
	final double Pi=3.14;
	abstract public void eat();
	abstract public void age();
	public void sex()//�����еķǳ��󷽷���������������д
	{ }
}

//�������Ϊ�����࣬��ô�Ӵ���Ҫ��д�����е���������
class dog extends Animal 
{
	public void eat()
	{
		System.out.println("����ʺ");
	}
	public void age()
	{
		System.out.println(age);
	}
}

abstract class cat extends Animal //�������ҲΪ�����࣬������д�����еĳ��󷽷�
{
	int age=20;
	public void eatfish()
	{
		System.out.println("è����");
	}
}