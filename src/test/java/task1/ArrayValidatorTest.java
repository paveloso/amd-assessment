package task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import task1.ArrayValidator;

public class ArrayValidatorTest {

    @Test
    public void arrayValidatorMethodArrayIsNotValidWhenNull() {
        int[] array = null;

        boolean result = ArrayValidator.isValid(array);

        Assertions.assertFalse(result);
    }

    @Test
    public void arrayValidatorMethodArrayIsNotValidWhenEmpty() {
        int[] array = new int[0];

        boolean result = ArrayValidator.isValid(array);

        Assertions.assertFalse(result);
    }

    @Test
    public void arrayValidatorMethodArrayIsValid() {
        int[] array = {3, 6, 9};

        boolean result = ArrayValidator.isValid(array);

        Assertions.assertTrue(result);
    }
}
