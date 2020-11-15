import java.util.Scanner;

public class GreatestCommonFactor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first number: ");
        int a = Math.abs(scanner.nextInt());
        System.out.println("Enter the second number: ");
        int b = Math.abs(scanner.nextInt());

        if (a == 0 || b == 0) {
            System.out.println("No greatest common factor");
            return;
        }

        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }

        System.out.println("Greatest common factor: " + a);

    }
}
