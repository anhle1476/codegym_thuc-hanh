public class Main {
    public static void main(String[] args) {
        String str = "aksvb askvbas voa ckasibc a";
        char value = 'a';

        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == value) count++;
        }
        System.out.println(count);
    }
}
