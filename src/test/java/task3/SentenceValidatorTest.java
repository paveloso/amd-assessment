package task3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import task1.ArrayValidator;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for {@link SentenceValidator}
 */
class SentenceValidatorTest {

    @Test
    void isValidWhenNotNullAndNotEmpty() {
        String sentence = "This is sentence";
        boolean result = SentenceValidator.isValid(sentence);

        Assertions.assertTrue(result);
    }

    @Test
    void isNotValidWhenEmpty() {
        String sentence = "";
        boolean result = SentenceValidator.isValid(sentence);

        Assertions.assertFalse(result);
    }

    @Test
    void isNotValidWhenNull() {
        String sentence = null;
        boolean result = SentenceValidator.isValid(sentence);

        Assertions.assertFalse(result);
    }
}