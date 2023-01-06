package org.aes;

import org.aes.utillity.SpecialCharacter;
import org.ahmeteminsaglik.ReadableFormat;
import org.ahmeteminsaglik.fileoperation.entities.concretes.FileFundamental;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordDataOperation {
    private HashSet totalWordSet = new HashSet();
    private FileOperation fileOperation = new FileOperation();

    public void createUniqueWords(List<FileFundamental> list) {
        int fileNumber = 0;
        for (FileFundamental tmpFilefund : list) {
            System.out.println("Process File :  " + ReadableFormat.getStringValue((fileNumber + 1)) + " | " +ReadableFormat.getStringValue(list.size()) + " | " + " file : " + list.get(fileNumber).getCompletePath());
            List<String> readDataList = readFile(tmpFilefund);
            System.out.println("Total Line in file : " + ReadableFormat.getStringValue(readDataList.size()));
            Set bookWordSet = new HashSet();
            for (String tmpStringLine : readDataList) {
                String stringLine = clearLineFromPunctuation(tmpStringLine);
                String[] wordArr = splitWordFromText(stringLine);
                List wordList = removeMeaninglessWordsInWordArray(wordArr);
                wordList = removeWordsNotBelongsToEnglish(wordList);
//                System.out.println(wordList);
                bookWordSet.addAll(wordList);


            }
            totalWordSet.addAll(bookWordSet);
//            System.out.println(hashSet);

            System.out.println("hashSet : " + ReadableFormat.getStringValue(bookWordSet.size()));
            System.out.println("bookWordSet : " + ReadableFormat.getStringValue(totalWordSet.size()));
            System.out.println("-------------------------------");
//            List<String> uniqeWordList = new ArrayList<>(hashSet);

//            System.exit(0);
            fileNumber++;

//            if (fileNumber >= 1000) {
//                System.exit(0);
//            }
            fileOperation.clearList();
        }

    }

    private List<String> readFile(FileFundamental fileFundamental) {
        return fileOperation.read(fileFundamental);
    }

    public List<String> getWordListFromFile(FileFundamental fileFundamental) {
        return readFile(fileFundamental);
    }

    public List<String> getUniqueData() {
        return new ArrayList<String>(totalWordSet);
    }

    public void printUniqeDataToTxtFile() {
        List<String> uniqueWordList = new ArrayList<String>(totalWordSet);
        fileOperation.writeFile(uniqueWordList);
    }

    private String clearLineFromPunctuation(String text) {

        return SpecialCharacter.removePunctuationCharactersInSentence(text);
    }

    private String[] splitWordFromText(String text) {
        String[] wordArr = text.split(" ");
        return wordArr;
    }

    private List<String> removeMeaninglessWordsInWordArray(String[] wordArr) {
        return SpecialCharacter.removeWordHasMeaninglessPunctuation(wordArr);
    }

    private List<String> removeWordsNotBelongsToEnglish(List<String> wordList) {
        return SpecialCharacter.removeWordsNotBelongsToEnglish(wordList);
    }

}
