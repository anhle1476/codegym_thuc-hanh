import java.util.Scanner;

public class InterestCalculator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Money: ");
        double money = input.nextDouble();
        System.out.println("Time (month): ");
        int month = input.nextInt();
        System.out.println("Interest rate: ");
        double interestRate = input.nextDouble();
        double monthlyInterest = (interestRate / 100) / 12;

        double totalInterest = 0;
        for (int i = 0; i < month; i++) {
            totalInterest += money * monthlyInterest * month;
        }

        System.out.println("Total interset: " + totalInterest);
    }
}