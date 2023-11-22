import java.util.Scanner;

public class DNAPalindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Prompt the user to input a DNA sequence
        System.out.println("Enter a DNA sequence:");
        String dna = scanner.nextLine();

        // Check if the provided DNA sequence is valid
        if (!isValidDNA(dna)) {
            System.out.println("Invalid DNA sequence.");
            return;
        }

        // Initialize a double-ended queue to store the DNA characters
        GenericDoubleEndedQueueImpl<Character> queue = new GenericDoubleEndedQueueImpl<>();
        for (int i = 0; i < dna.length(); i++) {
            // Add each character of the DNA sequence to the end of the queue
            queue.addLast(dna.charAt(i));
        }

        // Check if the DNA sequence is a Watson-Crick complemented palindrome
        if (isWatsonCrickPalindrome(queue)) {
            System.out.println("The DNA sequence is a Watson-Crick complemented palindrome.");
        } else {
            System.out.println("The DNA sequence is NOT a Watson-Crick complemented palindrome.");
        }
    }

    // Method to validate if the input string is a valid DNA sequence
    private static boolean isValidDNA(String dna) {
        // Check if the DNA string contains only the characters A, T, C, and G
        return dna.matches("[ATCG]*");
    }

    // Method to determine if a DNA sequence is a Watson-Crick complemented palindrome
    private static boolean isWatsonCrickPalindrome(GenericDoubleEndedQueueImpl<Character> queue) {
        while (!queue.isEmpty()) {
            // Remove and get the character from the front of the queue
            char front = queue.removeFirst();
            // Remove and get the complement of the character from the end of the queue
            char back = complement(queue.removeLast());

            // If the front character and the complement of the back character do not match, the sequence is not a palindrome
            if (front != back) {
                return false;
            }
        }
        // If all characters match with their complements, the sequence is a palindrome
        return true;
    }

    // Method to get the Watson-Crick complement of a nucleotide
    private static char complement(char nucleotide) {
        switch (nucleotide) {
            case 'A': return 'T';
            case 'T': return 'A';
            case 'C': return 'G';
            case 'G': return 'C';
            default: throw new IllegalArgumentException("Invalid nucleotide: " + nucleotide);
        }
    }
}
