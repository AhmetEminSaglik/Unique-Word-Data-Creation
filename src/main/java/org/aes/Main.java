package org.aes;

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
        FileOperation fileOperation = new FileOperation();
        fileOperation.createUniqeWords();
    }

}