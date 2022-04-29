package JavaseStudy.homework.Weapon2;

public class CannotMoveException extends Exception{
    public CannotMoveException() {
    }

    public CannotMoveException(String message) {
        super(message);
    }
}
