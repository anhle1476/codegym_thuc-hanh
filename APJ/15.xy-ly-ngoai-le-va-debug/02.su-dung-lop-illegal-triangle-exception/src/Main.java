import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Canh A:");
            double a = scanner.nextDouble();
            System.out.println("Canh B:");
            double b = scanner.nextDouble();
            System.out.println("Canh C:");
            double c = scanner.nextDouble();

            if (a <= 0 || b <= 0 || c <= 0) {
                throw new IllegalTriangleException("Canh be hon hoac bang 0!");
            }
            if (a > b + c || b > a + c || c > b + a) {
                throw new IllegalTriangleException("Canh lon hon tong 2 canh con lai");
            }
            System.out.printf("Tam giac voi ba canh a:%.2f b:%.2f c:%.2f hop le", a, b, c);
        } catch (IllegalTriangleException e) {
            e.printStackTrace();
        }
    }
}
