import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("a: ");
        int a = scanner.nextInt();

        System.out.println("b: ");
        int b = scanner.nextInt();

        System.out.println("c: ");
        int c = scanner.nextInt();

        QuadraticEquation equation = new QuadraticEquation(a, b, c);

        double delta = equation.getDiscriminant();
        if (delta > 0) {
            System.out.println("Root 1: " + equation.getRoot1() + " Root 2: " + equation.getRoot2());
        } else if (delta == 0) {
            System.out.println("Root: " + equation.getRoot1());
        } else {
            System.out.println("The equation has no roots");
        }

    }
}
