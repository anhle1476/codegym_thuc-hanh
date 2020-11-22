import java.util.Stack;

public class ReverseStringArr {
    public static void main(String[] args) {
        String original = "Lorem ipsum dolor sit amet!";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < original.length(); i++) {
            stack.push(original.charAt(i));
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < original.length(); i++) {
            result.append(stack.pop());
        }
        System.out.println(result.toString());
    }
}
