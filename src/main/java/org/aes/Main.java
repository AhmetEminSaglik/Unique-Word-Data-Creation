package org.aes;

import org.aes.model.FileLocation;
import org.aes.model.Word;
import org.aes.utillity.TimeCalculation;
import org.ahmeteminsaglik.ReadableFormat;
import org.ahmeteminsaglik.fileoperation.entities.concretes.FileFundamental;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static TimeCalculation timeCalculation = new TimeCalculation();
    static FileOperation fileOperation = new FileOperation();

    public static void main(String[] args) {
        /*
         * Read lines from txt
         * split words by space character
         * trim words
         * deleted words that involves joker characters
         * if word has alphabetic chracters than get it.
         * */

        testDBSaveProcess();
        System.exit(0);
        FileLocation fileLocation = new FileLocation();
        List<FileFundamental> fileFundList = fileLocation.getBookFileFundementalList();
        WordDataOperation wordDataOperation = new WordDataOperation();
//        wordDataOperation.createUniqueWords(fileFundList);
//        wordDataOperation.printUniqeDataToTxtFile();
        List<String> dataListInFile = wordDataOperation.getWordListFromFile(fileFundList.get(0));
        System.out.println(ReadableFormat.getStringValue(dataListInFile.size()));
        List<Word> wordList = new ArrayList<>();
//        DBConnection dbConnection = new DBConnection(Word.class);
        dataListInFile.forEach(e -> wordList.add(new Word(e)));
        saveAll(wordList);

    }

    public static void saveAll(List<Word> wordList) {
        timeCalculation.start();
        DBConnection dbConnection = new DBConnection(Word.class);
        dbConnection.saveAll(wordList);
        timeCalculation.stop();
        String msg = "saveAll : " + ReadableFormat.getStringValue(wordList.size()) + " :: " + timeCalculation.getStringFormatElapsedTime();
        fileOperation.appendDBProcessTime(msg);
    }

    public static void testDBSaveProcess() {
        DBConnection dbCon = new DBConnection(Word.class);

        for (int i = 0; i < 10; i++) {
            Word word = new Word("test " + i);
            dbCon.save(word);
        }
    }
}