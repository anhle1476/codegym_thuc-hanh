import java.util.Scanner;

public class DrawingMenu {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice = -1;

        while (choice != 0) {
            System.out.println("Menu\n" +
                    "1. Draw the triangle\n" +
                    "2. Draw the square\n" +
                    "3. Draw the rectangle\n" +
                    "0. Exit\n" +
                    "Enter your choice:");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    drawTriangle();
                    break;
                case 2:
                    drawSquare();
                    break;
                case 3:
                    drawRect();
                    break;
                case 0:
                    choice = 0;
                default:
                    System.out.println("No choice!");
            }
        }
    }

    public static void drawTriangle() {
        System.out.println("Draw the triangle\n" +
                "******\n" +
                "*****\n" +
                "****\n" +
                "***\n" +
                "**\n" +
                "*");
    }

    public static void drawRect() {
        System.out.println("Draw the rectangle\n" +
                "* * * * * *\n" +
                "* * * * * *\n" +
                "* * * * * *");
    }

    public static void drawSquare() {
        System.out.println("Draw the square\n" +
                "* * * * * *\n" +
                "* * * * * *\n" +
                "* * * * * *\n" +
                "* * * * * *\n" +
                "* * * * * *\n" +
                "* * * * * *");
    }
}
