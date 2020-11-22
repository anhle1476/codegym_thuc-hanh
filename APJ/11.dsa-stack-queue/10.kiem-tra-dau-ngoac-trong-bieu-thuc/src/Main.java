import java.util.Stack;

public class Main {
    private static final char LEFT_BRACKET = '(';
    private static final char RIGHT_BRACKET = ')';

    public static void main(String[] args) {
        String equation1 = "s * (s – a) * (s – b) * (s – c)";
        String equation2 = "(– b + (b2 – 4*a*c)^0.5) / 2*a";
        String equation3 = "s * (s – a) * (s – b * (s – c)";
        String equation4 = "s * (s – a) * s – b) * (s – c)";
        String equation5 = "(– b + (b^2 – 4*a*c)^(0.5/ 2*a))";

        System.out.println("Valid check:");
        System.out.println(equation1 + "  : " + isEquationValid(equation1));
        System.out.println(equation2 + "  : " + isEquationValid(equation2));
        System.out.println(equation3 + "  : " + isEquationValid(equation3));
        System.out.println(equation4 + "  : " + isEquationValid(equation4));
        System.out.println(equation5 + "  : " + isEquationValid(equation5));
    }

    public static boolean isEquationValid(String equation) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < equation.length(); i++) {
            switch (equation.charAt(i)) {
                case LEFT_BRACKET -> stack.push(LEFT_BRACKET);
                case RIGHT_BRACKET -> {
                    if (stack.isEmpty()) return false;
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}
