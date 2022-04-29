package homework.UserRegisterSystem;

public class UserRegisterSystem {
    public static void main(String[] args) {
        Userservice u = new Userservice();
        try {
            u.register("JohnZ", "zhang123");
        } catch (AccountLengthException e) {
            System.out.println(e.getMessage());
        }

        try {
            u.check("John");
        } catch (CannotFindUsername cannotFindUsername) {
            System.out.println(cannotFindUsername.getMessage());
        }
    }
}
