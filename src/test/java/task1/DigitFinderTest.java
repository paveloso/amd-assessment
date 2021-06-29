package task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Unit test for {@link DigitFinder}
 */
public class DigitFinderTest {

    private static final String RESULT_POS = "Found";
    private static final String RESULT_NEG = "there is no 7 in the array";

    @Test
    public void findSevenMethodPositiveResult() {
        int[] numbers = {12, 6, 71, 55};

        String result = DigitFinder.findSeven(numbers);

        Assertions.assertEquals(RESULT_POS, result);
    }

    @Test
    public void findSevenMethodNegativeResult() {
        int[] numbers = {122, 6, 1, 55};

        String result = DigitFinder.findSeven(numbers);

        Assertions.assertEquals(RESULT_NEG, result);
    }
}
