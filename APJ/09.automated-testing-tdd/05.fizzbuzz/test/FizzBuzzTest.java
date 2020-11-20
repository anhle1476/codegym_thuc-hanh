import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {

    @Test
    void testRun1() {
        int num = 1;
        String expect = "mot";

        String result = FizzBuzz.run(num);
        assertEquals(expect, result);
    }

    @Test
    void testRunNeg1() {
        int num = -1;
        String expect = "Unsupported number!";

        String result = FizzBuzz.run(num);
        assertEquals(expect, result);
    }

    @Test
    void testRun3() {
        int num = 3;
        String expect = "Fizz";

        String result = FizzBuzz.run(num);
        assertEquals(expect, result);
    }

    @Test
    void testRun5() {
        int num = 5;
        String expect = "Buzz";

        String result = FizzBuzz.run(num);
        assertEquals(expect, result);
    }

    @Test
    void testRun15() {
        int num = 15;
        String expect = "FizzBuzz";

        String result = FizzBuzz.run(num);
        assertEquals(expect, result);
    }

    @Test
    void testRun101() {
        int num = 101;
        String expect = "Unsupported number!";

        String result = FizzBuzz.run(num);
        assertEquals(expect, result);
    }

    @Test
    void testRun0() {
        int num = 0;
        String expect = "Unsupported number!";

        String result = FizzBuzz.run(num);
        assertEquals(expect, result);
    }

    @Test
    void testRun13() {
        int num = 13;
        String expect = "muoi ba";

        String result = FizzBuzz.run(num);
        assertEquals(expect, result);
    }

    @Test
    void testRun52() {
        int num = 52;
        String expect = "nam hai";

        String result = FizzBuzz.run(num);
        assertEquals(expect, result);
    }
}