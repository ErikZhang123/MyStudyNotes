package abstractdemo.teacherdemo;

public class MathTeacher extends teacher {

	public MathTeacher(String name, int age, String sex) {
		super(name, age, sex);
	}

	public void teach()
	{
		System.out.println(getName()+getAge()+"ห๊"+"ฝฬสýัง");
	}


}
