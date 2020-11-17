import java.util.Arrays;

public class Point2DTest {
    public static void main(String[] args) {
        Point2D point2D = new Point2D();
        System.out.println(point2D);
        System.out.println(Arrays.toString(point2D.getXY()));

        point2D = new Point2D(3, 5);
        System.out.println(point2D);
        System.out.println(Arrays.toString(point2D.getXY()));

        point2D.setXY(10, 10);
        System.out.println(point2D);
    }
}
