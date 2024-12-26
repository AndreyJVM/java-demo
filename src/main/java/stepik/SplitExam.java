package stepik;

import jakarta.validation.constraints.NotNull;

import java.util.Objects;
import java.util.Scanner;

public class SplitExam {
    public static void main(String[] args) {
        String[] inputMessages = readInput();
        String message1, message2;

        message1 = inputMessages[0];
        message2 = inputMessages[1];

        String result = message1 + " " + message2;

        System.out.println(result);
    }

    public static String[] readInput() {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        scanner.close();

        return inputLine.split(" \\| ");
    }

    public static String[] readInput(@NotNull String inputLine) {
        if (Objects.equals(inputLine, "")) {
            throw new IllegalArgumentException("Input line must not be empty.");
        }
        return inputLine.split(" \\| ");
    }
}