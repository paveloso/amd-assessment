package task1;

import task1.ArrayValidator;

import java.util.Arrays;

public class DigitFinder {

    private static final String RESULT_POS = "Found";
    private static final String RESULT_NEG = "there is no 7 in the array";

    public static String findSeven(int[] numbers) {
        int digitToFind = 7;
        if (ArrayValidator.isValid(numbers)) {
            return Arrays.stream(numbers).anyMatch(number -> containsDigit(number, digitToFind)) ? RESULT_POS : RESULT_NEG;
        }

        return RESULT_NEG;
    }

    private static boolean containsDigit(int number, int digit) {
        while (number > 0) {
            if (number % 10 == digit) {
                return true;
            }
            number = number / 10;
        }
        return false;
    }
}
