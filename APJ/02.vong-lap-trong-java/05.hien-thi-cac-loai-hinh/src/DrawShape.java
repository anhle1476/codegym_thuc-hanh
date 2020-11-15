import java.util.Scanner;

public class DrawShape {

    public static void main(String[] args) {
        final String menuMessage = "1. Print the rectangle\n" +
                "2. Print the square triangle\n" +
                "3. Print isosceles triangle\n" +
                "4. Exit\n" +
                "Enter your choice:";

        Scanner input = new Scanner(System.in);
        int choice = -1;

        while (choice != 4) {
            System.out.println(menuMessage);
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    drawRect();
                    break;
                case 2:
                    drawSquareTriangle();
                    break;
                case 3:
                    drawIsoscelesTriangle();
                    break;
                case 4:
                    System.out.println("Exit!");
                    break;
                default:
                    System.out.println("No choice!");
            }
        }
    }


    public static void drawRect() {
        System.out.println("Print the rectangle");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }

    public static void drawSquareTriangle() {
        System.out.println("Print the square triangle");

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }

    public static void drawIsoscelesTriangle() {
        System.out.println("Print the isosceles triangle");
        for (int i = 6; i >= 0; i--) {
            for (int j = 6 - i; j > 0; j--) {
                System.out.print(' ');
            }

            for (int k = 1; k <= i * 2 + 1; k++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }
}
