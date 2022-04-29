package JavaseStudy.homework.Weapon;

public class test {
    public static void main(String[] args) {
        Army a = new Army(5);
        Weapon tank = new Weapon("Tank", false, true);
        Weapon plane = new Weapon("plane", true, false);
        Weapon gun = new Weapon("gun", true, true);
        Weapon boat = new Weapon("boat", false, false);
        a.addweapon(tank);
        a.addweapon(plane);
        a.addweapon(gun);
        a.addweapon(boat);
        a.AttackAll();
        a.MoveAll();

    }
}
