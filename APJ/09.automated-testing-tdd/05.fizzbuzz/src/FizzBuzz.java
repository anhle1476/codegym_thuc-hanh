public class FizzBuzz {
    private static final String[] DIGITS = {"", "mot", "hai", "ba", "bon", "nam", "sau", "bay", "tam", "chin"};

    public static String run(int num) {
        if (num <= 0 || num > 100) return "Unsupported number!";
        boolean canDivideBy3 = num % 3 == 0;
        boolean canDivideBy5 = num % 5 == 0;

        if (canDivideBy3 && canDivideBy5) return "FizzBuzz";
        if (canDivideBy3) return "Fizz";
        if (canDivideBy5) return "Buzz";
        return getStringFromNumber(num);
    }

    private static String getStringFromNumber(int num) {
        int ones = num % 10;
        int tens = num / 10;
        return ((tens == 1 ? "muoi" : DIGITS[tens]) + " " + DIGITS[ones]).trim();
    }
}
