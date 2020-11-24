import java.util.Scanner;

public class AlgorithmComplexityTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String inputString = scanner.nextLine();

        int[] frequentChar = new int[255];                  // {1}  O(1)
        for (int i = 0; i < inputString.length(); i++) {    // {2}  O(n)
            int ascii = (int) inputString.charAt(i);        // {3}  O(1)
            frequentChar[ascii] += 1;                       // {4}  O(1)
        }
        int max = 0;                                        // {5}  O(1)
        char character = (char) 255;                        // {6}  O(1)
        for (int j = 0; j < 255; j++) {                     // {7}  O(n)
            if (frequentChar[j] > max) {                    // {8}  O(1)
                max = frequentChar[j];                      // {9}  O(1)
                character = (char) j;                       // {10} O(1)
            }
        }
        //   O(max(C1, (C2n * max(C3, C4)), C5, C6, (C7n * max(C8, C9, C10)))
        //=> O(max(O1, On, O1, O1, On)
        //=> O(n)
        System.out.println("The most appearing letter is '" + character + "' with a frequency of " + max + " times");
    }
}