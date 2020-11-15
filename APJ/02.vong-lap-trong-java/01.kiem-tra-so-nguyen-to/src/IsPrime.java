import java.util.Scanner;

public class IsPrime {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = input.nextInt();

        int i = 2;
        boolean check = true;
        while (i <= Math.sqrt(number)) {
            if (number % i++ == 0) {
                check = false;
                break;
            }
        }

        System.out.println(number + (check ? " is" : " is not") + " a prime.");
    }
}