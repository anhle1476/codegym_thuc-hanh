import java.util.Arrays;
import java.util.Stack;

public class NumberConverter {
    private static final char[] DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private static int parseDigit(char digit) {
        for (int i = 0; i < DIGITS.length; i++) {
            if (digit == DIGITS[i]) return i;
        }
        return -1;
    }

    public static String fromDecimalToBinary(int decimal) {
        return fromDecimal(decimal, 2);
    }

    public static String fromDecimalToHex(int decimal) {
        return fromDecimal(decimal, 16);
    }

    private static String fromDecimal(int decimal, int radix) {
        if (decimal < 0) return "Unsupported";
        if (decimal == 0) return "0";
        Stack<Character> stack = new Stack<>();
        while (decimal > 0) {
            stack.push(DIGITS[decimal % radix]);
            decimal /= radix;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static int fromBinaryToDecimal(String binary) {
        return toDecimal(binary, 2);
    }

    public static int fromHexToDecimal(String hex) {
        return toDecimal(hex, 16);
    }

    private static int toDecimal(String number, int radix) {
        int result = 0;
        int len = number.length();
        for (int i = len; i > 0; i--) {
            int charValue = parseDigit(number.charAt(i - 1));
            double power = Math.pow(radix, len - i);
            result += charValue * power;
        }
        return result;
    }
}
