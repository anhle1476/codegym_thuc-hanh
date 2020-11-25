import java.util.Scanner;

public class CLIScanner {
    private static final Scanner scanner = new Scanner(System.in);
    public static int getInteger(String message, int limit) {
        int option;
        do {
            System.out.println(message);
            option = getAndParseInteger();
        } while (option < 0 || option > limit);
        return option;
    }

    public static String getString(String message) {
        System.out.println(message);
        String str;
        do {
            str = scanner.nextLine().trim();
        } while (str.length() == 0);
        return str;
    }

    private static int getAndParseInteger() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("You must enter an integer greater than 0");
            return -1;
        }
    }
}
