package task1;

/**
 * a class that contains method to validate the array
 */
public class ArrayValidator {

    /**
     * method helps to validate the array
     * @param array to check for validation
     * @return boolean result of array inspection
     */
    public static boolean isValid(int[] array) {
        return array != null && array.length > 0;
    }
}
