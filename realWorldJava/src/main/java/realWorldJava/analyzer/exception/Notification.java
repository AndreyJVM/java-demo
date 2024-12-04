package realWorldJava.analyzer.exception;

import java.util.ArrayList;
import java.util.List;

public class Notification {

    private final List<String> errors = new ArrayList<>();

    public void addError(final String massage) {
        errors.add(massage);
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    public String errorsMessage () {
        return errors.toString();
    }

    public List<String> getErrors() {
        return this.errors;
    }
}