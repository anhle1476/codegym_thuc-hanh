public class TriangleTest {
    public static void main(String[] args) {
        Triangle tri = new Triangle();
        System.out.println(tri);

        tri = new Triangle(3, 4, 5, "blue");
        System.out.println(tri.getArea());
        System.out.println(tri.getPerimeter());

        tri.setSide1(20);
        tri.setSide2(30);
        tri.setSide3(40);
        System.out.println(tri);
    }
}
