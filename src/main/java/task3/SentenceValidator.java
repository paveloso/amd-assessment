package task3;

/**
 * SentenceValidator class help to validate an incoming string
 */
public class SentenceValidator {

    /**
     * a method helps to validate a String if it empty or null
     * @param sentence incoming string to be validated
     * @return boolean value if the string is valid
     */
    public static boolean isValid(String sentence) {
        return sentence != null && !sentence.isEmpty();
    }
}
