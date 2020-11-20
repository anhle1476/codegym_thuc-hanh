public class TriangleClassifier {
    public static final String NOT_A_TRIANGLE = "Khong phai tam giac";
    public static final String NORMAL_TRIANGLES = "Tam giac binh thuong";
    public static final String ISOSCELES_TRIANGLE = "Tam giac can";
    public static final String EQUILATERAL_TRIANGLE = "Tam giac deu";

    public static String classifying(int side1, int side2, int side3) {
        if (isInvalidTriangle(side1, side2, side3)) return NOT_A_TRIANGLE;
        if (side1 == side2 && side1 == side3) return EQUILATERAL_TRIANGLE;
        if (side1 == side2 || side1 == side3 || side2 == side3) return ISOSCELES_TRIANGLE;
        return NORMAL_TRIANGLES;
    }

    private static boolean isInvalidTriangle(int side1, int side2, int side3) {
        if (side1 <= 0 || side2 <= 0 || side3 <= 0) return true;
        return (side1 > side2 + side3 || side2 > side1 + side3 || side3 > side1 + side3);
    }
}
