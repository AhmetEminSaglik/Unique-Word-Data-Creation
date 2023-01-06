package org.aes.utillity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SpecialCharacter {
    private static final char[] REMOVE_PUNCTUATION = ",.!\"—’\'…".toCharArray();
    private static final int[][] MEANINGLESS_PUNCTION_VALUE_RANGE_ARRAY = {{32, 64}, {91, 96}, {123, 126}};
    private static final int[][] ENGLISH_CHAR_RANGE = {{65, 90}, {97, 122}};

    public static String removePunctuationCharactersInSentence(String text) {
        for (char tmp : REMOVE_PUNCTUATION) {
            text.replace(tmp, ' ');
        }

        return text;
    }

//: [32,64],[91,96],[123,126]

    /**
     * @ if word does not have any meaningless punctuation then it is a suitable word*/
    public static List<String> removeWordHasMeaninglessPunctuation(String word[]) {
        List cleanWordList = new ArrayList();
        for (String tmp : word) {
            tmp = tmp.trim();
            boolean result = isContainedMeaninglessPunction(tmp);
            if (!result) {
                if (tmp.length() > 1) {
                    cleanWordList.add(tmp);
                }
            }
        }
        return cleanWordList;
    }

    public static List<String> removeWordsNotBelongsToEnglish(List<String> wordList) {
        //65-90  97-122

        List<String> englishWordList = new ArrayList<>();

        for (String tmp : wordList) {
            tmp = tmp.trim();
            boolean resultLowerCase = isContainedOnlyGivenLanguageChar(tmp, ENGLISH_CHAR_RANGE[0]);
            boolean resultUpperCase = isContainedOnlyGivenLanguageChar(tmp, ENGLISH_CHAR_RANGE[1]);

            if (resultLowerCase || resultUpperCase) {
                englishWordList.add(tmp);
            }
        }

        return englishWordList;
     /*   for (String tmp : wordList) {
            tmp = tmp.trim();

        }*/
    }

    //*          DELETE words involves : [32,64],[91,96],[123,126]
    private static boolean isContainedMeaninglessPunction(String word) {
        for (int i = 0; i < MEANINGLESS_PUNCTION_VALUE_RANGE_ARRAY.length; i++) {
            boolean result = isTextInCharRange(word, MEANINGLESS_PUNCTION_VALUE_RANGE_ARRAY[i]);
            if (result) {
                return true;
            }
        }
        return false;
    /*    char[] chars = word.toCharArray();
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
        return false;*/
    }

    private static boolean isContainedOnlyGivenLanguageChar(String word, int[] languageRange) {
        return isTextInCharRange(word, languageRange);
    }

    /**
     * @return true if the given text in given rangeArray
     */
    private static boolean isTextInCharRange(String text, int[] rangeArr) {
        char[] chars = text.toCharArray();
        for (char tmp : chars) {
            int charASCII = tmp;
            int min, max;
            for (int i = 0; i < rangeArr.length; i++) {
                min = rangeArr[0];
                max = rangeArr[1];
                boolean result = isBetweenOrEquals(charASCII, min, max);
                if (!result) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isBetweenOrEquals(int number, int min, int max) {
        if (min <= number && number <= max) {
            return true;
        }
        return false;
    }
}
