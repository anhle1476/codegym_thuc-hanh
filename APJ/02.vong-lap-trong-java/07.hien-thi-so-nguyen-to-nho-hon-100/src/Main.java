public class Main {
    public static void main(String[] args) {
        for (int i = 2; i < 100; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean isPrime(int num) {
        int limit = (int) Math.sqrt(num);
        for (int i = 2; i <= limit; i++) {
            if (num % i == 0) {return false;}
        }
        return true;
    }
}
