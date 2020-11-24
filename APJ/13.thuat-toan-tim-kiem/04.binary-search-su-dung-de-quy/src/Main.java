public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};

        System.out.println(binarySearch(arr, 4));
        System.out.println(binarySearch(arr, 1));
        System.out.println(binarySearch(arr, 11));
        System.out.println(binarySearch(arr, 0));
    }

    public static int binarySearch(int[] arr, int value) {
        return binarySearchRecursion(arr, 0, arr.length - 1, value);
    }

    public static int binarySearchRecursion(int[] arr, int left, int right, int value) {
        if (left > right) return -1;
        if (left == right) return arr[left] == value ? left : -1;

        int mid = left + (right - left) / 2;

        if (arr[mid] == value) return mid;
        if (arr[mid] < value) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
        return binarySearchRecursion(arr, left, right, value);
    }
}
