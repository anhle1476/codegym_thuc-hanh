public class Main {
    public static void main(String[] args) {
        int []arr = {4, 12, 7, 8, 1, 6, 9};
        System.out.println("The smallest element in the array is: " + minValue(arr));
    }
    
    public static int minValue(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int num : arr) {
            min = Math.min(num, min);
        }
        return min;
    }
}
