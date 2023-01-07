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

//        testDBSaveProcess();
//        System.exit(0);



        /*FileLocation fileLocation = new FileLocation();
        List<FileFundamental> fileFundList = fileLocation.getBookFileFundementalList();
        WordDataOperation wordDataOperation = new WordDataOperation();
        FileFundamental fileFundamental = fileFundList.get(0);
//        wordDataOperation.createUniqueWords(fileFundList);
        List<String> txtList = wordDataOperation.getWordListFromFile(fileFundamental);
        List<Word> wordList = convertStringListToWordList(txtList);
        saveAll(wordList);*/
        getWordById(10);
        getWordById(30);





//        wordDataOperation.createNewWordDataFromExistingDatas(wordDataOperation.getUniqueDataList());
//        wordDataOperation.createNewWordDataFromExistingDatas(fileFundamental,1);

      /*  wordDataOperation.createNewWordDataFromExistingDatas(fileFundamental, 2);
        wordDataOperation.createNewWordDataFromExistingDatas(fileFundamental, 3);
        wordDataOperation.createNewWordDataFromExistingDatas(fileFundamental, 5);
        wordDataOperation.createNewWordDataFromExistingDatas(fileFundamental, 10);
        wordDataOperation.createNewWordDataFromExistingDatas(fileFundamental, 20);
        wordDataOperation.createNewWordDataFromExistingDatas(fileFundamental, 30);
        wordDataOperation.createNewWordDataFromExistingDatas(fileFundamental, 50);
        wordDataOperation.createNewWordDataFromExistingDatas(fileFundamental, 100);
        wordDataOperation.createNewWordDataFromExistingDatas(fileFundamental, 200);
        wordDataOperation.createNewWordDataFromExistingDatas(fileFundamental, 500);
        wordDataOperation.createNewWordDataFromExistingDatas(fileFundamental, 1000);*/
//        wordDataOperation.createUniqueWords(fileFundList);
//        wordDataOperation.printUniqeDataToTxtFile();
//        List<String> dataListInFile = wordDataOperation.getWordListFromFile(fileFundList.get(0));
//        System.out.println(ReadableFormat.getStringValue(dataListInFile.size()));
//        List<Word> wordList = new ArrayList<>();
//        DBConnection dbConnection = new DBConnection(Word.class);
//        dataListInFile.forEach(e -> wordList.add(new Word(e)));
//        saveAll(wordList);

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

    static List<Word> convertStringListToWordList(List<String> txtList) {
        List<Word> wordList = new ArrayList<>();
        txtList.forEach(e -> wordList.add(new Word(e)));
        return wordList;
    }

    static Word getWordById(int id) {
        DBConnection connection = new DBConnection(Word.class);
        Word word = (Word) connection.getById(id);
        System.out.println(word);
        return word;
    }
}