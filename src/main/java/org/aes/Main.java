package org.aes;

import org.aes.model.FileLocation;
import org.ahmeteminsaglik.fileoperation.entities.concretes.FileFundamental;

import java.util.List;
import java.util.logging.Logger;

public class Main {


    public static void main(String[] args) {
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
        FileLocation fileLocation = new FileLocation();
        List<FileFundamental> fileFundList = fileLocation.getBookFileFundementalList();

        WordDataOperation wordDataOperation = new WordDataOperation();
        wordDataOperation.createUniqeWords(fileFundList);
    }

}