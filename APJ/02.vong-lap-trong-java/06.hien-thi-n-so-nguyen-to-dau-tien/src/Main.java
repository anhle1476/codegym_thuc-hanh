import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of first prime numbers:");
        int size = scanner.nextInt();
        int printed = 0;

        int current = 2;
        while(printed < size) {
            if (isPrime(current)) {
                System.out.println(current);
                printed++;
            }
            current++;
        }
    }

    public static boolean isPrime(int num) {
        int limit = (int) Math.sqrt(num);
        for (int i = 2; i <= limit; i++) {
            if (num % i == 0) {return false;}
        }
        return true;
    }
}
