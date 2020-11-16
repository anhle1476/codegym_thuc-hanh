import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("The Application to count the number of students pass.");

        int size;
        do {
            System.out.print("Enter a size: ");
            size = scanner.nextInt();
            if (size > 30)
                System.out.println("Size does not exceed 30");
        } while (size > 30);

        int[] array = new int[size];
        ;
        for (int i = 0; i < array.length; i++) {
            System.out.print("Enter a mark for student " + (i + 1) + " :");
            array[i] = scanner.nextInt();
        }

        int count = 0;
        System.out.print("List of mark: ");
        for (int mark : array) {
            System.out.print(mark + "\t");
            if (mark >= 5 && mark <= 10) count++;
        }
        System.out.print("\nThe number of students passing the exam is " + count);
    }
}
