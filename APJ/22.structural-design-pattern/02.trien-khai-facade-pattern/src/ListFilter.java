import java.util.ArrayList;

public class ListFilter {
    public Integer[] filterOdd(Integer[] list) {
        ArrayList<Integer> filtered = new ArrayList<>();
        for (int num : list) {
            if (num % 2 == 0)
                filtered.add(num);
        }
        return filtered.toArray(new Integer[0]);
    }
}
