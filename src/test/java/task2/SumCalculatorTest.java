package task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Unit test for {@link SumCalculator}
 */
class SumCalculatorTest {

    @Test
    void digitSumSingleDigitInput() {
        int expected = 7;
        int result = SumCalculator.digitSum(7);

        Assertions.assertEquals(result, expected);
    }

    @Test
    void digitSumMultipleDigitInput() {
        int expected = 8;
        int result = SumCalculator.digitSum(89245682);

        Assertions.assertEquals(result, expected);
    }

    @Test
    void digitSumThreeDigitInput() {
        int expected = 9;
        int result = SumCalculator.digitSum(234);

        Assertions.assertEquals(result, expected);
    }

    @Test
    void digitSumFourDigitInput() {
        int expected = 1;
        int result = SumCalculator.digitSum(1234);

        Assertions.assertEquals(result, expected);
    }
}