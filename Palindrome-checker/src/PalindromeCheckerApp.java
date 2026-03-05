import java.util.Scanner;
import java.util.Stack;
import java.util.Deque;
import java.util.ArrayDeque;

public class PalindromeCheckerApp {

    public static boolean stackPalindrome(String input) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        String reversed = "";
        while (!stack.isEmpty()) {
            reversed += stack.pop();
        }

        return input.equals(reversed);
    }

    public static boolean dequePalindrome(String input) {
        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            deque.addLast(input.charAt(i));
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }

        return true;
    }

    public static boolean recursivePalindrome(String str, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }
        return recursivePalindrome(str, start + 1, end - 1);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        long startTime1 = System.nanoTime();
        boolean stackResult = stackPalindrome(input);
        long endTime1 = System.nanoTime();

        long startTime2 = System.nanoTime();
        boolean dequeResult = dequePalindrome(input);
        long endTime2 = System.nanoTime();

        long startTime3 = System.nanoTime();
        boolean recursiveResult = recursivePalindrome(input, 0, input.length() - 1);
        long endTime3 = System.nanoTime();

        System.out.println("Stack Result: " + stackResult + " Time: " + (endTime1 - startTime1) + " ns");
        System.out.println("Deque Result: " + dequeResult + " Time: " + (endTime2 - startTime2) + " ns");
        System.out.println("Recursive Result: " + recursiveResult + " Time: " + (endTime3 - startTime3) + " ns");

        scanner.close();
    }
}

