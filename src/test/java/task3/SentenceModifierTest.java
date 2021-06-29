package task3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SentenceModifierTest {

    private SentenceModifier sentenceModifier = new SentenceModifier();

    @Test
    void doRemakeSample1() {
        String sentence = "Cats are great pets.";
        String expected = "Atscay areway reatgay etspay.";
        String result = sentenceModifier.doRemake(sentence);

        Assertions.assertEquals(expected, result);
    }

    @Test
    void doRemakeSample2() {
        String sentence = "Tom got a small piece of pie.";
        String expected = "Omtay otgay away mallsay iecepay ofway iepay.";
        String result = sentenceModifier.doRemake(sentence);

        Assertions.assertEquals(expected, result);
    }

    @Test
    void doRemakeSample3() {
        String sentence = "He told us a very exciting tale.";
        String expected = "Ehay oldtay usway away eryvay excitingway aletay.";
        String result = sentenceModifier.doRemake(sentence);

        Assertions.assertEquals(expected, result);
    }

    @Test
    void doRemakeThrowException() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            sentenceModifier.doRemake(null);
        });
        assertEquals("The String either is null or is empty", exception.getMessage());
    }
}