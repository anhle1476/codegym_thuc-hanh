import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("The application reverses the element of the array");
        Scanner scanner = new Scanner(System.in);

        int size;
        do {
            System.out.print("Enter a size: ");
            size = scanner.nextInt();
            if (size > 20) System.out.println("Size can not exceed 20");
        } while (size > 20);

        int[] array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.print("Enter element " + (i + 1) + " :");
            array[i] = scanner.nextInt();
            i++;
        }

        System.out.printf("%-20s%s", "Elements in array: ", "");
        for (int value : array) {
            System.out.print(value + "\t");
        }

        // array reverse
        for (int j = 0; j < array.length / 2; j++) {
            int temp = array[j];
            array[j] = array[size - 1 - j];
            array[size - 1 - j] = temp;
        }

        System.out.printf("%n%-20s%s", "Reverse array: ", "");
        for (int k : array) {
            System.out.print(k + "\t");
        }
    }
}
