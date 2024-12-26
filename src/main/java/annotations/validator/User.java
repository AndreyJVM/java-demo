package annotations.validator;

public class User {

    @NotEmpty(message = "User can`t be empty")
    private String name;

    public User(String name) {
        this.name = name;
    }
}