package JavaseStudy.homework.Weapon2;

public class Tank extends Weapon implements Attack{
    @Override
    public void attack() {
        System.out.println("坦克开始攻击");
    }
}
