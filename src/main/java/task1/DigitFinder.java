package task1;

import task1.ArrayValidator;

import java.util.Arrays;

/**
 * Class that contains a method which help to find a digit within the array of numbers
 */

public class DigitFinder {

    private static final String RESULT_POS = "Found";
    private static final String RESULT_NEG = "there is no 7 in the array";

    /**
     * Method help to find a digit 7 within the array of numbers
     * @param numbers array of numbers to search in
     * @return a String which contains a message about result of operation
     */
    public static String findSeven(int[] numbers) {
        int digitToFind = 7;
        if (ArrayValidator.isValid(numbers)) {
            return Arrays.stream(numbers).anyMatch(number -> containsDigit(number, digitToFind)) ? RESULT_POS : RESULT_NEG;
        }

        return RESULT_NEG;
    }

    /**
     * Utility method which check if the number contains a digit
     * @param number an integer number which will be inspected for a certain digit
     * @param digit an integer which is needed to be found in number
     * @return
     */
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
