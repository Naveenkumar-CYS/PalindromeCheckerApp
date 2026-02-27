import java.util.Scanner;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        System.out.println("=====================================");
        System.out.println("   WELCOME TO PALINDROME CHECKER");
        System.out.println("   Version: 1.0");
        System.out.println("=====================================");

        // Create Scanner object
        Scanner scanner = new Scanner(System.in);

        // Ask user input
        System.out.print("Enter a word to check: ");
        String word = scanner.nextLine();

        // Reverse string
        String reversed = "";

        for (int i = word.length() - 1; i >= 0; i--) {
            reversed += word.charAt(i);
        }

        // Palindrome check
        if (word.equals(reversed)) {
            System.out.println(word + " is a Palindrome.");
        } else {
            System.out.println(word + " is NOT a Palindrome.");
        }

        System.out.println("Program Completed.");

        scanner.close();
    }
}
