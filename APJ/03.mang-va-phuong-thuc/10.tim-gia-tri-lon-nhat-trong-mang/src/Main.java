import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = 10;
        int[] numbers = new int[size];

        System.out.println("Enter numbers:");
        for (int i = 0; i < size; i++) {
            System.out.println("Index " + i + ": ");
            numbers[i] = scanner.nextInt();
        }

        int min = numbers[0];
        for (int i = 1; i < size; i++) {
            if (numbers[i] < min) min = numbers[i];
        }

        System.out.println("Min: " + min);
    }
}
