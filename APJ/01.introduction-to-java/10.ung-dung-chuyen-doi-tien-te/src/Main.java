import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int rate = 23000;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Amount of USD: ");
        double usd = scanner.nextDouble();
        System.out.println("In VND: " + (usd *rate));
    }
}
