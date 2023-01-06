package org.aes;

import org.aes.model.FileLocation;
import org.aes.model.Word;
import org.aes.utillity.ReadableStringFormat;
import org.aes.utillity.TimeCalculation;
import org.ahmeteminsaglik.fileoperation.entities.concretes.FileFundamental;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static TimeCalculation timeCalculation = new TimeCalculation();
    static FileOperation fileOperation = new FileOperation();

    public static void main(String[] args) {
        /*
        TODO branch : -clear-created-unique-word
        *  Created +7_038_822 must be clear from the characters that do not belong to the English
        * */

        /*
         * Read lines from txt
         * split words by space character
         * trim words
         * deleted words that involves joker characters
         * if word has alphabetic chracters than get it.
         * */

        /*
        * File operationda file okuma, file location bilgileri olmali
        * uniqe word olusturma ile ilgili baska bir class olmali ve bu class'taki fonksiyon cagrilirken
          her seferinde fileFund gonderilmeli
        * islem bitince getUniqeWord ile liste seklinde alinmali
        * Sonra Word objesine cevrilmeli
        * Sonra db'ye kaydeidlmeli
        *
        * */
//        FileOperation fileOperation = new FileOperation();
//        List<FileFundamental> fileFundList = fileOperation.getBookFileFundementalList();
//        WordDataOperation wordDataOperation= new WordDataOperation();
//        wordDataOperation.createUniqeWords(fileFundList);

        //40_881, before clear broken books
        //38_709,  after deleted broken books.
        /*System.out.println((int)'«');
        System.out.println((int)'‘');
        System.out.println((int)'”');
        System.out.println((int)'»');
        System.out.println((int)'«');
        System.out.println((int)'…');
        System.exit(0);*/
//        String text="別笑話我．你這個姐姐他极孝順我，不象我那大太太一味怕老爺，婆婆跟前不過";
//        for(char tmp : text.toCharArray()){
//            System.out.println((int)tmp);
//        }
//        System.out.println((int)'‘');
//        System.out.println((int)'’');
//        System.exit(0);
        FileLocation fileLocation = new FileLocation();
        List<FileFundamental> fileFundList = fileLocation.getBookFileFundementalList();
        WordDataOperation wordDataOperation = new WordDataOperation();
//        wordDataOperation.createUniqueWords(fileFundList);
//        wordDataOperation.printUniqeDataToTxtFile();
        List<String> dataListInFile = wordDataOperation.getWordListFromFile(fileFundList.get(0));
//        List<String> wordList =new ArrayList<>();
        System.out.println(ReadableStringFormat.getReadableValueIntToString(dataListInFile.size()));
        List<Word> wordList = new ArrayList<>();
//        DBConnection dbConnection = new DBConnection(Word.class);
//        dataListInFile.forEach(e -> wordList.add(new Word(e)));
        for (int i = 0; i < 10_000; i++) {
            wordList.add(new Word(dataListInFile.get(i)));
        }
//        saveAll(wordList);
        TimeCalculation timeCalculation2 = new TimeCalculation();
        timeCalculation2.start();

        int[] sleepMSArr = {1_000/*,1, 1000, 5000*/};
        int[] batchArr = {/*5, 10,*/ /*20*//*, 30,*/ 50/*, 100*/};
        for (int j = 0; j < sleepMSArr.length; j++) {
            for (int i = 0; i < batchArr.length; i++) {

//                saveNormal(wordList, batchArr[i]);
//                sleep(sleepMSArr[j]);
//                savePersist(wordList, batchArr[i]);
//                sleep(sleepMSArr[j]);
                saveOrUpdate(wordList, batchArr[i]);
//                sleep(sleepMSArr[j]);
//                saveOneByOne(wordList);
            }
        }

        timeCalculation2.stop();
        timeCalculation2.printElapsedTime();
//        saveNormal(wordList, 20);
//        savePersist(wordList, 20);
//        saveOrUpdate(wordList, 20);
//        saveNormal(wordList, 50);
//        savePersist(wordList, 50);
//        saveOrUpdate(wordList, 50);
//        saveNormal(wordList, 100);
//        savePersist(wordList, 100);
//        saveOrUpdate(wordList, 100);

//        saveOneByOne(wordList);
//        dbConnection.save(wordList);

//        wordList.forEach(e -> {
//            dbConnection.save(new Word(e));
//        });

//        List<String> uniqueList = wordDataOperation.getUniqueData();
//        wordDataOperation.printUniqeDataToTxtFile();


//        uniqueList.forEach(e->{
//            System.out.println("tmp : "+e);
//        });
//        List<Word> wordList = new ArrayList<>();
//        uniqeList.stream().allMatch(e->wordList.add(new Word(e)));
//        DBConnection dbConnection = new DBConnection(Word.class);
//        dbConnection.save(wordList);
//        dbConnection.save(new Word("ABC"));

    }

    public static void saveNormal(List<Word> wordList, int batchSize) {
        timeCalculation.start();
        DBConnection dbConnection = new DBConnection(Word.class);
        dbConnection.saveNormal(wordList, batchSize);
        timeCalculation.stop();
        String msg = "saveNormal : " + ReadableStringFormat.getReadableValueIntToString(wordList.size()) + " batchSize :: " + batchSize + " :: " + timeCalculation.getStringFormatElapsedTime();
        fileOperation.appendDBProcessTime(msg);
    }

    public static void savePersist(List<Word> wordList, int batchSize) {
        timeCalculation.start();
        DBConnection dbConnection = new DBConnection(Word.class);
        dbConnection.savePersist(wordList, batchSize);
        timeCalculation.stop();
        String msg = "savePersist : " + ReadableStringFormat.getReadableValueIntToString(wordList.size()) + " batchSize :: " + batchSize + " :: " + timeCalculation.getStringFormatElapsedTime();
        fileOperation.appendDBProcessTime(msg);
    }

    public static void saveOrUpdate(List<Word> wordList, int batchSize) {
        timeCalculation.start();
        DBConnection dbConnection = new DBConnection(Word.class);
        dbConnection.saveOrUpdate(wordList, batchSize);
        timeCalculation.stop();
        String msg = "saveOrUpdate : " + ReadableStringFormat.getReadableValueIntToString(wordList.size()) + " batchSize :: " + batchSize + " :: " + timeCalculation.getStringFormatElapsedTime();
        fileOperation.appendDBProcessTime(msg);
    }

    public static void saveOneByOne(List<Word> wordList) {
        timeCalculation.start();
        DBConnection dbConnection = new DBConnection(Word.class);
        wordList.forEach(e -> dbConnection.save(e));
        timeCalculation.stop();
        String msg = "saveOneByOne : " + ReadableStringFormat.getReadableValueIntToString(wordList.size()) + " :: " + timeCalculation.getStringFormatElapsedTime();
        fileOperation.appendDBProcessTime(msg);
    }

    /*    public static void saveOneByOne(List<Word> wordList) {
            timeCalculation.start();
            DBConnection dbConnection = new DBConnection(Word.class);
    //        wordList.forEach(dbConnection::save);
            wordList.forEach(e -> dbConnection.save(e));
            timeCalculation.stop();
            String msg = "SaveAll : " + ReadableStringFormat.getReadableValueIntToString(wordList.size()) + " : " + timeCalculation.getStringFormatElapsedTime();
            fileOperation.appendDBProcessTime(msg);
        }*/
    static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}