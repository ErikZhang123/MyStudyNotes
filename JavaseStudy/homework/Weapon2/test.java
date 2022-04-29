package JavaseStudy.homework.Weapon2;

public class test {
    public static void main(String[] args) {
        Army a = new Army(10);
        Weapon w = new Weapon();
        plane p = new plane();
        Gun g = new Gun();
        Tank t= new Tank();

        try {
            a.AddWeapon(t);
            a.AddWeapon(p);
            a.AddWeapon(g);
        } catch (AddBeyoundBoundaryException e) {
            System.out.println(e.getMessage());
        }
        a.AttackAll();
        try {
            a.MoveAll();
        } catch (CannotMoveException e) {
            System.out.println(e.getMessage());
        }
    }
}
