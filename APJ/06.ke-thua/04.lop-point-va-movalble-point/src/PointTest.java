import java.util.Arrays;

public class PointTest {
    public static void main(String[] args) {
        Point point = new Point();
        System.out.println(point);
        System.out.println(Arrays.toString(point.getXY()));

        point = new Point(3, 5);
        System.out.println(point);
        System.out.println(Arrays.toString(point.getXY()));

        point.setXY(10, 10);
        System.out.println(point);
    }
}
