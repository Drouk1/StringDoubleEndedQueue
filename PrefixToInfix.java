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

    private static String convertToInfix(String prefix) {
        GenericDoubleEndedQueueImpl<String> queue = new GenericDoubleEndedQueueImpl<>();

        // Iterate over the prefix expression from right to left
        for (int i = prefix.length() - 1; i >= 0; i--) {
            char ch = prefix.charAt(i);

            // Check if the character is a digit or an alphabetic operand
            if (Character.isDigit(ch) || isAlphabeticOperand(ch)) {
                // Add operands to the front of the queue
                queue.addFirst(String.valueOf(ch));
            } else if (isOperator(ch)) {
                // Handle operators
                try {
                    // Pop two operands from the front of the queue
                    String operand1 = queue.removeFirst();
                    String operand2 = queue.removeFirst();
                    // Form a sub-expression and add it back to the queue
                    String subExpr = "(" + operand1 + ch + operand2 + ")";
                    queue.addFirst(subExpr);
                } catch (NoSuchElementException e) {
                    // Throw an exception if there are not enough operands
                    throw new IllegalArgumentException("Invalid prefix expression.");
                }
            } else if (!Character.isWhitespace(ch)) {
                // Throw an exception for invalid characters
                throw new IllegalArgumentException("Invalid character '" + ch + "'");
            }
        }

        // Check if the queue contains exactly one element, which is the full infix expression
        if (queue.size() != 1) {
            throw new IllegalArgumentException("Invalid prefix expression.");
        }

        // Return the infix expression
        return queue.removeFirst();
    }

    // Helper method to check if a character is an operator
    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    // Helper method to check if a character is an alphabetic operand
    private static boolean isAlphabeticOperand(char ch) {
        return (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z');
    }
}
