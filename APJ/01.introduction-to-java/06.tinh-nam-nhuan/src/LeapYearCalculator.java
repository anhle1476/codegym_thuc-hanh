import java.util.Scanner;

public class LeapYearCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a year: ");
        int year = scanner.nextInt();

        boolean isLeapYear = year % 100 == 0 ? year % 400 == 0 : year % 4 == 0;
        System.out.printf("%d is %sa leap year", year, isLeapYear ? "" : "NOT ");
    }
}