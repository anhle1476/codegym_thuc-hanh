import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] array = new int[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.println("Index " + i + "-" + j + ": ");
                array[i][j] = scanner.nextInt();
            }
        }

        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += array[i][i];
        }

        System.out.println("Sum of diagonal: " + sum);
    }
}