package abstractdemo.teacherdemo;

public class  EnglishTeacher extends teacher{
	
	private int bonus;

	public EnglishTeacher(String name, int age, String sex) {
		super(name, age, sex);
	}

	public int getBonus() {
		return bonus;
	}
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	public void teach()
	{
		System.out.println(getName()+getAge()+"Ëê"+"½ÌÓ¢Óï"+"½±½ğ"+getBonus());
	}
}

