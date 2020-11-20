import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleClassifierTest {

    @Test
    @DisplayName("Testing 2_2_2")
    void testClassifying1() {
        int a = 2;
        int b = 2;
        int c = 2;
        String result = TriangleClassifier.classifying(a, b, c);

        String expected = TriangleClassifier.EQUILATERAL_TRIANGLE;
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Testing 2_2_3")
    void testClassifying2() {
        int a = 2;
        int b = 2;
        int c = 3;
        String result = TriangleClassifier.classifying(a, b, c);

        String expected = TriangleClassifier.ISOSCELES_TRIANGLE;
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Testing 3_4_5")
    void testClassifying3() {
        int a = 3;
        int b = 4;
        int c = 5;
        String result = TriangleClassifier.classifying(a, b, c);

        String expected = TriangleClassifier.NORMAL_TRIANGLES;
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Testing 8_2_3")
    void testClassifying4() {
        int a = 8;
        int b = 2;
        int c = 3;
        String result = TriangleClassifier.classifying(a, b, c);

        String expected = TriangleClassifier.NOT_A_TRIANGLE;
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Testing -1_2_1")
    void testClassifying5() {
        int a = -1;
        int b = 2;
        int c = 1;
        String result = TriangleClassifier.classifying(a, b, c);

        String expected = TriangleClassifier.NOT_A_TRIANGLE;
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Testing 0_1_1")
    void testClassifying6() {
        int a = 0;
        int b = 1;
        int c = 1;
        String result = TriangleClassifier.classifying(a, b, c);

        String expected = TriangleClassifier.NOT_A_TRIANGLE;
        assertEquals(expected, result);
    }
}