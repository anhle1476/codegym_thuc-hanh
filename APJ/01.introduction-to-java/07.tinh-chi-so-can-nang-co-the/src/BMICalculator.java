import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Your weight (in kilogram):");
        double weight = scanner.nextDouble();

        System.out.print("Your height (in meter):");
        double height = scanner.nextDouble();

        double bmi = weight / Math.pow(height, 2);
        System.out.printf("%-20s%s", "bmi", "Interpretation\n");
        System.out.printf(
                "%-20.2f%s", bmi, bmi < 18
                        ? "Underweight"
                        : bmi < 25.0
                        ? "Normal"
                        : bmi < 30.0
                        ? "Overweight"
                        : "Obese"
        );
    }
}