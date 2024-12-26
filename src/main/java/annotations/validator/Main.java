package annotations.validator;

public class Main {
    public static void main(String[] args) {

        try {
            User user = new User("");
            Validator.validate(user);
        } catch (Exception e) {
            System.out.println("Validation error: " + e.getMessage());
        }
    }
}