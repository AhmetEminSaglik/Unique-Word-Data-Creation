package org.aes.utillity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SpecialCharacter {
    private static final char[] REMOVE_PUNCTUATION = ",.!\"".toCharArray();
    private static final int[][] MEANINGLESS_PUNCTION_VALUE_RANGE_ARRAY = {{32, 64}, {91, 96}, {123, 126}};

    public static String removePunctuationCharactersInSentence(String text) {
        for (char tmp : REMOVE_PUNCTUATION) {
            text.replace(tmp, ' ');
        }

        return text;
    }

//: [32,64],[91,96],[123,126]

    public static List<String> removeWordHasMeaninglessPunctuation(String word[]) {
        List cleanWordList = new ArrayList();
        for (String tmp : word) {
            tmp = tmp.trim();
            boolean result = isContainedMeaninglessPunction(tmp);
            if (!result) {
                cleanWordList.add(tmp);
            }
        }
        return cleanWordList;
    }

    //*          DELETE words involves : [32,64],[91,96],[123,126]
    private static boolean isContainedMeaninglessPunction(String word) {
        char[] chars = word.toCharArray();
        for (char tmp : chars) {
            int charASCII = tmp;
            int min, max;
            for (int i = 0; i < MEANINGLESS_PUNCTION_VALUE_RANGE_ARRAY.length; i++) {
                min = MEANINGLESS_PUNCTION_VALUE_RANGE_ARRAY[i][0];
                max = MEANINGLESS_PUNCTION_VALUE_RANGE_ARRAY[i][1];
                boolean result = isBetweenOrEquals(charASCII, min, max);
                if (result == true) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isBetweenOrEquals(int number, int min, int max) {
        if (min <= number && number <= max) {
            return true;
        }
        return false;
    }
}
