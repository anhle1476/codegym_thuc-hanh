public class RandomList {
    public Integer[] generateList(int size) {
        if (size <= 0) return null;
        Integer[] list = new Integer[size];
        for (int i = 0; i < size; i++) {
            list[i] = (int) (Math.random() * 1000);
        }
        return list;
    }
}
