import java.util.Scanner;
import java.util.NoSuchElementException;

public class PrefixToInfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Prompt the user to enter a prefix expression
        System.out.println("Enter a prefix expression:");
        String prefix = scanner.nextLine();

        try {
             // Convert the prefix expression to an infix expression
            String infix = convertToInfix(prefix);
            // Display the converted infix expression
            System.out.println("Infix expression: " + infix);
        } catch (IllegalArgumentException e) {
            // If an invalid expression is encountered, display an error message
            System.out.println("Invalid expression: " + e.getMessage());
        }
    }
}
