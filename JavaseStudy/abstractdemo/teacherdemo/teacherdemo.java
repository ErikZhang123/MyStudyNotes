package abstractdemo.teacherdemo;

public class teacherdemo {
public static void main(String[] args) {
	MathTeacher mt = new MathTeacher("z",18,"f");
	mt.setName("����");
	mt.setAge(25);
	
	mt.teach();
	EnglishTeacher et = new EnglishTeacher("z",18,"f");
	et.setName("����");
	et.setAge(20);
	et.setBonus(1000);
	et.teach();
}
}
