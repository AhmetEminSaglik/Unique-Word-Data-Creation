package org.aes;

import org.aes.model.FileLocation;
import org.aes.model.Word;
import org.aes.utillity.TimeCalculation;
import org.ahmeteminsaglik.ReadableFormat;
import org.ahmeteminsaglik.fileoperation.entities.concretes.FileFundamental;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    static TimeCalculation timeCalculation = new TimeCalculation();
    static FileOperation fileOperation = new FileOperation();
    static Random random = new Random();

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


        FileLocation fileLocation = new FileLocation();
        List<FileFundamental> fileFundList = fileLocation.getBookFileFundementalList();
        WordDataOperation wordDataOperation = new WordDataOperation();
        FileFundamental fileFundamental = fileFundList.get(0);
//        wordDataOperation.createUniqueWords(fileFundList);
//        List<String> txtList = wordDataOperation.getWordListFromFile(fileFundamental);
//        List<Word> wordList = convertStringListToWordList(txtList);
//        saveAll(wordList);

//        getWordById(10);
//        getWordById(30);


//        wordDataOperation.createNewWordDataFromExistingDatas(wordDataOperation.getUniqueDataList());
//        wordDataOperation.createNewWordDataFromExistingDatas(fileFundamental,1);

        List<String> list = wordDataOperation.getWordListFromFile(fileFundamental);
        System.out.println("list size : " + list.size());
        wordDataOperation.setTotalWordSet(list);
//        wordDataOperation.createNewWordDataFromExistingDatas(fileFundamental, 1, 50);
//        wordDataOperation.createNewWordDataFromExistingDatas(fileFundamental, 1, 100);
//        wordDataOperation.createNewWordDataFromExistingDatas(fileFundamental, 1, 250);
//        wordDataOperation.createNewWordDataFromExistingDatas(fileFundamental, 1, 500);
//        wordDataOperation.createNewWordDataFromExistingDatas(fileFundamental, 1, 1_000);
//        wordDataOperation.createNewWordDataFromExistingDatas(fileFundamental, 1, 1_500);
//        wordDataOperation.createNewWordDataFromExistingDatas(fileFundamental, 1, 3_000);
//        wordDataOperation.createNewWordDataFromExistingDatas(fileFundamental, 1, 5_000);
//        wordDataOperation.createNewWordDataFromExistingDatas(fileFundamental, 1, 7_500);
//        wordDataOperation.createNewWordDataFromExistingDatas(fileFundamental, getRandom(), 10_000);
//        wordDataOperation.createNewWordDataFromExistingDatas(fileFundamental, getRandom(), 15_000);
//        wordDataOperation.createNewWordDataFromExistingDatas(fileFundamental, getRandom(), 20_000);
//        wordDataOperation.createNewWordDataFromExistingDatas(fileFundamental, getRandom(), 25_000);
//        wordDataOperation.createNewWordDataFromExistingDatas(fileFundamental, getRandom(), 35_000);
//        wordDataOperation.createNewWordDataFromExistingDatas(fileFundamental, getRandom(), 40_000);
//        wordDataOperation.createNewWordDataFromExistingDatas(fileFundamental, getRandom(), 50_000);
//        wordDataOperation.createNewWordDataFromExistingDatas(fileFundamental, getRandom(), 100_000);
//        wordDataOperation.createNewWordDataFromExistingDatas(fileFundamental, getRandom(), 150_000);
//        wordDataOperation.createNewWordDataFromExistingDatas(fileFundamental, getRandom(), 200_000);
//        wordDataOperation.createNewWordDataFromExistingDatas(fileFundamental, getRandom(), 250_000);
//        wordDataOperation.createNewWordDataFromExistingDatas(fileFundamental, getRandom(), 300_000);
//        wordDataOperation.createNewWordDataFromExistingDatas(fileFundamental, getRandom(), 450_000);
//        wordDataOperation.createNewWordDataFromExistingDatas(fileFundamental, getRandom(), 500_000);
//        wordDataOperation.createNewWordDataFromExistingDatas(fileFundamental, getRandom(), 750_000);
//        wordDataOperation.createNewWordDataFromExistingDatas(fileFundamental, getRandom(), 1_000_000);
//        wordDataOperation.createNewWordDataFromExistingDatas(fileFundamental, getRandom(), 1_500_000);
//        wordDataOperation.createNewWordDataFromExistingDatas(fileFundamental, 1, 2_000_000);
//        wordDataOperation.createNewWordDataFromExistingDatas(fileFundamental, 1, 3_000_000);


//        wordDataOperation.createUniqueWords(fileFundList);
//        wordDataOperation.printUniqeDataToTxtFile();
//        List<String> dataListInFile = wordDataOperation.getWordListFromFile(fileFundList.get(0));
//        System.out.println(ReadableFormat.getStringValue(dataListInFile.size()));
//        List<Word> wordList = new ArrayList<>();
//        DBConnection dbConnection = new DBConnection(Word.class);
//        dataListInFile.forEach(e -> wordList.add(new Word(e)));
//        saveAll(wordList);

    }

    private static int getRandom() {
        return random.nextInt(2) +1;
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