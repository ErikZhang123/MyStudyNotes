package JavaseStudy.homework.Weapon;

public class CannotAttackException extends Exception {
    public CannotAttackException() {
    }

    public CannotAttackException(String message) {
        super(message);
    }
}
