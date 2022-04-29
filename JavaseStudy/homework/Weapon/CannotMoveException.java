package JavaseStudy.homework.Weapon;

public class CannotMoveException extends Exception{
    public CannotMoveException() {
    }

    public CannotMoveException(String message) {
        super(message);
    }
}
