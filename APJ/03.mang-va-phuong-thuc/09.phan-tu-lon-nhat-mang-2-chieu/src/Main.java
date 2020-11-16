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
        scanner.close();

        int max = Integer.MIN_VALUE;
        for (int[] row : array) {
            for(int cell : row) {
                max = Math.max(max, cell);
            }
        }

        System.out.println("Max: " + max);
    }
}
