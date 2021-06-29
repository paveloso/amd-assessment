package task3;

import javax.xml.transform.stream.StreamSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class SentenceModifier {
    private static String APPEND_VOWEL = "way";
    private static String APPEND_CONS = "ay";
    private List<Character> vowelsList = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

    public String doRemake(String sentence) {

        if (!SentenceValidator.isValid(sentence)) {
            throw new IllegalArgumentException("The String either is null or is empty");
        }

        String[] words = sentence.split(" ");

        for (int i = 0; i < words.length; i++) {
            words[i] = modify(words[i]);
        }

        return String.join(" ", words);
    }

    private String modify(String word) {
        boolean isCapital = Character.isUpperCase(word.charAt(0));
        boolean isVowel = vowelsList.contains(word.charAt(0));
        boolean nonLetterLastSymbol = word.endsWith(".") || word.endsWith(",");

        StringBuilder resultBuilder = new StringBuilder("");
        if (isVowel) {
            if (nonLetterLastSymbol) {
                resultBuilder.append(word.substring(0, word.length() - 2).toLowerCase()).append(APPEND_VOWEL).append(word.charAt(word.length() - 1));
            } else {
                resultBuilder.append(word.toLowerCase()).append(APPEND_VOWEL);
            }
        } else {
            if (nonLetterLastSymbol) {
                resultBuilder.append(word.substring(1, word.length() - 1).toLowerCase()).append(Character.toString(word.charAt(0)).toLowerCase()).append(APPEND_CONS).append(word.charAt(word.length() - 1));
            } else {
                resultBuilder.append(word.substring(1).toLowerCase()).append(Character.toString(word.charAt(0)).toLowerCase()).append(APPEND_CONS);
            }
        }

        if (isCapital) {
            resultBuilder.replace(0, 1, resultBuilder.substring(0, 1).toUpperCase());
        }

        return resultBuilder.toString();
    }
}
