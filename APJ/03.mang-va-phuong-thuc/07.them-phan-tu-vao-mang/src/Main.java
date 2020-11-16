import java.util.Arrays;
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

        System.out.println("Value to insert:");
        int value = scanner.nextInt();

        int index = -1;
        while (index < 0 || index > size) {
            System.out.println("Index:");
            index = scanner.nextInt();
        }

        System.out.println("Before: " + Arrays.toString(numbers));
        int prevValue = numbers[index];
        int currentValue;
        numbers[index] = value;
        for (int i = index + 1; i < size; i++) {
            currentValue = numbers[i];
            numbers[i] = prevValue;
            prevValue = currentValue;
        }

        System.out.println("After : " + Arrays.toString(numbers));
    }
}
