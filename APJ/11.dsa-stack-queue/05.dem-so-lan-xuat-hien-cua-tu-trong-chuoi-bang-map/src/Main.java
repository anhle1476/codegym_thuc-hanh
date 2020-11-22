import java.util.Set;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        String str = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
        TreeMap<Character, Integer> map = new TreeMap<>();
        String formattedString = str.toUpperCase();
        for (int i = 0; i < str.length(); i++) {
            char current = formattedString.charAt(i);
            map.put(current, map.containsKey(current) ? map.get(current) + 1 : 1);
        }

        Set<Character> keys = map.keySet();
        for (Character key : keys) {
            System.out.printf("%s:%d%n", key, map.get(key));
        }
    }
}
