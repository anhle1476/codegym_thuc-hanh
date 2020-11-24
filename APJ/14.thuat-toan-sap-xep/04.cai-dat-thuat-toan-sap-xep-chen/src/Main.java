import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {2, 5, 1, 3, 6, 9, 7, 10, 4, 8};
        insertionSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void insertionSort(int[] array) {
        int completeBlock = 0;
        for (int elementIndex = completeBlock + 1; elementIndex < array.length; elementIndex++) {
            for (int completedIndex = 0; completedIndex <= completeBlock; completedIndex++) {
                if (array[elementIndex] < array[completedIndex]) {
                    insertElement(array, elementIndex, completedIndex);
                    break;
                }
            }
            completeBlock++;
        }
    }

    public static void insertElement(int[] array, int fromIndex, int insertIndex) {
        int holder = array[fromIndex];
        if (fromIndex - insertIndex >= 0)
            System.arraycopy(array, insertIndex, array, insertIndex + 1, fromIndex - insertIndex);
        array[insertIndex] = holder;
    }
}
