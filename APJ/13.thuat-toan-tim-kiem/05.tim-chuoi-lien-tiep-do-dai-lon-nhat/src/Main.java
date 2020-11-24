import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String string = input.nextLine();

        LinkedList<Character> max = new LinkedList<>();

        for (int i = 0; i < string.length(); i++) { // O(n)
            LinkedList<Character> list = new LinkedList<>(); // O(1)
            list.add(string.charAt(i)); // O(1)
            for (int j = i + 1; j < string.length(); j++) { // O(n)
                if (string.charAt(j) < list.getLast()) break; // O(1)
                list.add(string.charAt(j)); // O(1)
            }

            if (list.size() > max.size()) { // O(1)
                max.clear();
                max.addAll(list);
            }
        }
        // => O(n) * O(n) => O(n^2)


        for (Character ch : max) { // O(n)
            System.out.print(ch);
        }
        System.out.println();
    }
    //    O(n^2) + O(n) => O(n^2)
}