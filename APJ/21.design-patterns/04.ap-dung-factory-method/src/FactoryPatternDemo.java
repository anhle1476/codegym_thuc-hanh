public class FactoryPatternDemo {
    public static void main(String[] args) {
        System.out.println("test circle:");
        Shape testCircle = ShapeFactory.getShape("circle");
        testCircle.draw();

        System.out.println("test square:");
        Shape testSquare = ShapeFactory.getShape("square");
        testSquare.draw();

        System.out.println("test rectangle:");
        Shape testRect = ShapeFactory.getShape("rectangle");
        testRect.draw();

    }
}
