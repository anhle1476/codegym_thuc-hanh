public class SquareTest {
    public static void main(String[] args) {
        Square square = new Square();
        System.out.println(square);

        Shape[] shapes = new Shape[] {new Rectangle(), new Square(), new Shape()};
        for (Shape shape : shapes) {
            if (shape instanceof Colorable) {
                ((Colorable) shape).howToColor();
            }
        }
    }
}
