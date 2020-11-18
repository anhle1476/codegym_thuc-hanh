import java.util.Arrays;

public class MovablePointTest {
    public static void main(String[] args) {
        MovablePoint movablePoint= new MovablePoint();
        System.out.println(movablePoint);
        System.out.println(Arrays.toString(movablePoint.getXY()));
        System.out.println(Arrays.toString(movablePoint.getSpeed()));

        movablePoint = new MovablePoint(3, 5, 10, 10);
        System.out.println(movablePoint);

        movablePoint.setSpeed(15, 20);
        System.out.println(movablePoint);

        System.out.println(movablePoint.move());
    }
}
