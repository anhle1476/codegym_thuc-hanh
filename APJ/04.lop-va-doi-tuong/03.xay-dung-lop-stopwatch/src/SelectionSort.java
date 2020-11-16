public class SelectionSort {
    public static void sortAscending(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int currentMin = array[i];
            int minIndex = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < currentMin) {
                    currentMin = array[j];
                    minIndex = j;
                }
            }

            if (i != minIndex) {
                array[minIndex] = array[i];
                array[i] = currentMin;
            }
        }
    }
}
