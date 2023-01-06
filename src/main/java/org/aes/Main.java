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

        DBConnection dbCon= new DBConnection(Word.class);

        for(int i=0;i<10;i++){
        Word word= new Word("test "+i);
        dbCon.save(word);
        }

        System.exit(0);
        FileLocation fileLocation = new FileLocation();
        List<FileFundamental> fileFundList = fileLocation.getBookFileFundementalList();
        WordDataOperation wordDataOperation = new WordDataOperation();
//        wordDataOperation.createUniqueWords(fileFundList);
//        wordDataOperation.printUniqeDataToTxtFile();
        List<String> dataListInFile = wordDataOperation.getWordListFromFile(fileFundList.get(0));
        System.out.println(ReadableStringFormat.getReadableValueIntToString(dataListInFile.size()));
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
        String msg = "saveAll : " + ReadableStringFormat.getReadableValueIntToString(wordList.size()) +" :: " + timeCalculation.getStringFormatElapsedTime();
        fileOperation.appendDBProcessTime(msg);
    }

//    public  static  void

}