package JavaseStudy.homework.Weapon2;

public class plane extends Weapon implements Moveable,Attack{
    @Override
    public void attack() {
        System.out.println("飞机开始攻击");
    }

    @Override
    public void move() {
        System.out.println("飞机开始移动");
    }
}
