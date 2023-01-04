package org.aes;

import org.aes.model.FileLocation;
import org.aes.utillity.ReadableStringFormat;
import org.aes.utillity.SpecialCharacter;
import org.ahmeteminsaglik.fileoperation.entities.concretes.FileFundamental;

import javax.swing.*;
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
            System.out.println("Process File :  " + ReadableStringFormat.getReadableValueIntToString((fileNumber + 1)) + " | " + ReadableStringFormat.getReadableValueIntToString(list.size()) + " | " + " file : " + list.get(fileNumber).getCompletePath());
            List<String> readDataList = fileOperation.read(tmpFilefund);
            System.out.println("Total Line in file : " + ReadableStringFormat.getReadableValueIntToString(readDataList.size()));
            Set bookWordSet = new HashSet();
            for (String tmpStringLine : readDataList) {
                String stringLine = clearLineFromPunctuation(tmpStringLine);
                String[] wordArr = splitWordFromText(stringLine);

                List wordList = removeMeaninglessWordsInWordArray(wordArr);
//                System.out.println(wordList);
                bookWordSet.addAll(wordList);


            }
            totalWordSet.addAll(bookWordSet);
//            System.out.println(hashSet);

            System.out.println("hashSet : " + ReadableStringFormat.getReadableValueIntToString(bookWordSet.size()));
            System.out.println("bookWordSet : " + ReadableStringFormat.getReadableValueIntToString(totalWordSet.size()));
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

    public List<String> getUniqueData() {
        List<String> uniqueWordList = new ArrayList<String>(totalWordSet);
        for (String tmp : uniqueWordList) {
            fileOperation.appendFile(tmp);
        }
        System.out.println("total printed word size : " + uniqueWordList.size());
        return new ArrayList<String>(totalWordSet);
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


}
