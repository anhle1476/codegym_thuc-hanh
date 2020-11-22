import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String str1 = "Able was I ere I saw Elba";
        String str2 = "Lorem ipsum dolor sit amet";

        System.out.println("Palindrome test:");
        System.out.println(str1 + " : " + isPalindrome(str1));
        System.out.println(str2 + " : " + isPalindrome(str2));
    }

    public static boolean isPalindrome(String str) {
        String formatted = str.toUpperCase();
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < formatted.length(); i++) {
            char current = formatted.charAt(i);
            stack.push(current);
            queue.offer(current);
        }

        while (!stack.isEmpty()) {
            if (stack.pop() != queue.poll()) return false;
        }
        return true;
    }
}
