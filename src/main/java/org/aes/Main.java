package org.aes;

import org.aes.db.DBService;
import org.aes.model.*;
import org.aes.utillity.TimeCalculation;
import org.aes.db.DBConnection;
import org.ahmeteminsaglik.ReadableFormat;
import org.ahmeteminsaglik.fileoperation.entities.concretes.FileFundamental;

import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    static TimeCalculation timeCalculation = new TimeCalculation();
    static FileOperation fileOperation = new FileOperation();
    static Random random = new Random();
    static int counter = 0;


    static <T /*extends WordGroupService*/> void testDBService(T t) {
        DBService<T> dbService = new DBService<T>(t.getClass());
        List<WordGroupService> list = (List<WordGroupService>) dbService.getAll();
        System.out.println(" -- > " + t.getClass());
        for (WordGroupService tmp : list) {
            System.out.println(tmp.getId() + " : " + tmp.getPoolId());
        }
    }

    public static void main(String[] args) {
//        DBService dbService = new DBService<WordPool>(WordPool.class);
//        List<WordPool> list = null;
//        list = dbService.getAll();
//        System.out.println("WordPool.class : " + ReadableFormat.getStringValue(list.size()));
//        dbService = new DBService<Word_50>(Word_50.class);
//        list = dbService.getAll();
//        System.out.println("WordGroup.class : " + ReadableFormat.getStringValue(list.size()));
//
//        dbService = new DBService<Word_10_000>(Word_10_000.class);
//        list = dbService.getAll();
//        System.out.println("WordGroup.class : " + ReadableFormat.getStringValue(list.size()));
//        testDBService(new WordGroup());
//        testDBService(new WordGroup());
//        testDBService(new WordGroup());
//        DBService<WordGroup> dbService = new DBService<WordGroup>(WordGroup.class);
//        List<WordGroup> list = (List<WordGroup>) dbService.getAll();
//        for (WordGroup tmp : list) {
//            System.out.println(tmp.getId() + " : " + tmp.getPoolId());
//        }
//
//
//        System.exit(0);
//        String text = "En son 'word data' daki 500_000 luk kelimeyi eslestirip DB'e eklemeye calisliyordum." +
//                "Aslinda numberli eklemek yerine direk kelimeyi de ekleyebiliriz daha kisa surer" +
//                "aynen yarin bu sekilde gidisati degistireyim cunku bu cok uzuayacak. Uzerinde dusunup" +
//                "zaman kaybetmek de istemiyorum ";
//        JOptionPane.showMessageDialog(null," en son id ler yazdirildi simdi onlar db ye kaydedilecek");
        /*
         * Read lines from txt
         * split words by space character
         * trim words
         * deleted words that involves joker characters
         * if word has alphabetic chracters than get it.
         * */

//        testDBSaveProcess();
//        System.exit(0);


//        System.out.println(testList.size());
//        System.out.println(testList.get(0));
//
//        System.exit(0);
        //        wordDataOperation.createUniqueWords(fileFundList);
//        List<String> txtList = wordDataOperation.getWordListFromFile(fileFundamental);
//        List<WordPool> wordList = convertStringListToWordList(txtList);
//        saveAll(wordList);

//        getWordById(10);
//        getWordById(30);


//        wordDataOperation.createNewWordDataFromExistingDatas(wordDataOperation.getUniqueDataList());
//        wordDataOperation.createNewWordDataFromExistingDatas(fileFundamental,1);



        /*        FileLocation fileLocation = new FileLocation();
        List<FileFundamental> fileFundList = fileLocation.getBookFileFundementalList();
        WordDataOperation wordDataOperation = new WordDataOperation();
        FileFundamental fileFundamental = fileFundList.get(0);

        List<String> list = wordDataOperation.getWordListFromFile(fileFundamental);
        System.out.println("list size : " + list.size());
        List<WordPool> dbList = getWordListFromDB();
        List<Integer> idList = new ArrayList<>();
        for (WordPool tmp : dbList) {
            list.forEach(e -> {
                if (tmp.getWord().equals(e)) {
                    System.out.println(tmp.getId() + " : " + tmp.getWord());
                    idList.add(tmp.getId());
                }
            });
        }
        System.out.print('[');
        idList.forEach(e -> {
            System.out.print(e + ",");
        });
        System.out.print(']');
        System.exit(0);*/

//        System.out.println(getWordById(4));
//        System.exit(0);


//        getWordById(3);

//        int[] idArr = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51};
//        saveWordGroupToDB(idArr);


//        saveAll(wordGroupList, WordGroup.class);


//        System.exit(0);
        FileLocation fileLocation = new FileLocation();
        List<FileFundamental> fileFundList = fileLocation.getBookFileFundementalList();
        WordDataOperation wordDataOperation = new WordDataOperation();
        FileFundamental fileFundamental = fileFundList.get(0);
        List<String> stringList = wordDataOperation.getWordListFromFile(fileFundamental);
//        List<WordPool> wordPoolList = getWordListFromDB();

//        List<String> list = wordDataOperation.getWordListFromFile(fileFundamental);
//        System.out.println(fileFundamental.getPath());
//        System.out.println(fileFundamental.getFileName());
//        System.out.println(fileFundamental.getExtension());
//        System.exit(0);

        /*stringList.forEach(e -> {

            if (e.length() <= 2) {
                counter++;
            }

        });
        System.out.println(counter);

        System.out.println(stringList.size());*/


// wordDataOperation.createNewWordDataFromExistingDatas(getRandom() + 5, 50);
//        wordDataOperation.createNewWordDataFromExistingDatas(getRandom() + 5, 100);
//        wordDataOperation.createNewWordDataFromExistingDatas(2, 250);
//        wordDataOperation.createNewWordDataFromExistingDatas(getRandom(), 500);
//        wordDataOperation.createNewWordDataFromExistingDatas(5, 1_500);

//        wordDataOperation.createNewWordDataFromExistingDatas(5, 3_000);
//        wordDataOperation.createNewWordDataFromExistingDatas(5, 5_000);
//        wordDataOperation.createNewWordDataFromExistingDatas(5, 7_500);
//        wordDataOperation.createNewWordDataFromExistingDatas(10, 10_000);
//        wordDataOperation.createNewWordDataFromExistingDatas(10, 15_000);
//        wordDataOperation.createNewWordDataFromExistingDatas(10, 20_000);
//        wordDataOperation.createNewWordDataFromExistingDatas(15, 25_000);
//        wordDataOperation.createNewWordDataFromExistingDatas(15, 35_000);
//                wordDataOperation.createNewWordDataFromExistingDatas(15, 40_000);
//                wordDataOperation.createNewWordDataFromExistingDatas(15, 50_000);
//        wordDataOperation.createNewWordDataFromExistingDatas(7, 100_000);
//        wordDataOperation.createNewWordDataFromExistingDatas(6, 150_000);
//                wordDataOperation.createNewWordDataFromExistingDatas(5, 200_000);
//        wordDataOperation.createNewWordDataFromExistingDatas(5, 250_000);
//        wordDataOperation.createNewWordDataFromExistingDatas(3, 300_000);
//                wordDataOperation.createNewWordDataFromExistingDatas(3, 450_000);
//        wordDataOperation.createNewWordDataFromExistingDatas(2, 500_000);
//                wordDataOperation.createNewWordDataFromExistingDatas(2, 750_000);
//        wordDataOperation.createNewWordDataFromExistingDatas(2, 1_000_000);
//                wordDataOperation.createNewWordDataFromExistingDatas(2, 1_500_000);
//        wordDataOperation.createNewWordDataFromExistingDatas(1, 2_000_000);


        wordDataOperation.setTotalWordSet(stringList);
        System.out.println(stringList.size());
        List<WordGroup> list =
                wordDataOperation.createNewWordDataFromExistingDatas(1, 3_000_000);


        saveAll(list);
        System.exit(0);


//        System.exit(0);


//        wordDataOperation.createUniqueWords(fileFundList);
//        wordDataOperation.printUniqeDataToTxtFile();
//        List<String> dataListInFile = wordDataOperation.getWordListFromFile(fileFundList.get(0));
//        System.out.println(ReadableFormat.getStringValue(dataListInFile.size()));
//        List<WordPool> wordList = new ArrayList<>();
//        DBConnection dbConnection = new DBConnection(WordPool.class);
//        dataListInFile.forEach(e -> wordList.add(new WordPool(e)));
//        saveAll(wordList);

//        saveWordGroupToDB();

//        writeIdFromWordPoolToFile();
//        int[] idArr ={ 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, };
//        saveWordGroupToDB();
    }

/*
    static void saveWordGroupToDB() {
        WordDataOperation wordDataOperation = new WordDataOperation();
        List<String> idList = wordDataOperation.getWordListFromFile(getFileFund());
        List<WordGroup> wordGroupList = new ArrayList<>();
        for (int i = 0; i < idList.size(); i++) {
            wordGroupList.add(new WordGroup(Integer.parseInt(idList.get(i).trim())));
            System.out.println("eklenen id : " + Integer.parseInt(idList.get(i).trim()));
        }
        saveAll(wordGroupList, WordGroup.class);
    }
*/

    static FileFundamental getFileFund() {
        FileLocation fileLocation = new FileLocation();
        List<FileFundamental> fileFundList = fileLocation.getBookFileFundementalList();
        WordDataOperation wordDataOperation = new WordDataOperation();
        return fileFundList.get(0);
    }

    private static int getRandom() {
        return random.nextInt(3) + 1;
    }

    public static void saveAll(List<?> objectList, Class clazz) {
        timeCalculation.start();
        DBConnection dbConnection = new DBConnection(clazz);
        dbConnection.saveAll(objectList);

        timeCalculation.stop();
        String msg = "saveAll : " + ReadableFormat.getStringValue(objectList.size()) + " :: " + timeCalculation.getStringFormatElapsedTime();
//        fileOperation.appendDBProcessTime(msg);
    }

    public static void saveAll(List<WordGroup> wordGroupList) {
        timeCalculation.start();
        DBConnection dbConnection = new DBConnection(WordGroup.class);
        dbConnection.saveAll(wordGroupList);

        timeCalculation.stop();
        String msg = "saveAll : " + ReadableFormat.getStringValue(wordGroupList.size()) + " :: " + timeCalculation.getStringFormatElapsedTime();
        fileOperation.appendDBProcessTime(msg);
    }

    public static void testDBSaveProcess() {
        DBConnection dbCon = new DBConnection(WordPool.class);

        for (int i = 0; i < 10; i++) {
            WordPool word = new WordPool("test " + i);
            dbCon.save(word);
        }
    }

    static List<WordPool> convertStringListToWordList(List<String> txtList) {
        List<WordPool> wordList = new ArrayList<>();
        txtList.forEach(e -> wordList.add(new WordPool(e)));
        return wordList;
    }

    static WordPool getWordById(int id) {
        DBConnection connection = new DBConnection(WordPool.class);
        WordPool word = (WordPool) connection.getById(id);
        System.out.println(word);
        return word;
    }

    static void matchWordsAndInsertToDBWithId() {
        DBConnection dbConnection = new DBConnection(WordPool.class);

    }

/*    static List<WordPool> getWordListFromDB() {
        DBConnection dbConnection = new DBConnection(WordPool.class);
        List<WordPool> list = (List<WordPool>) dbConnection.getAll();
        return list;
    }*/
/*

    static void writeIdFromWordPoolToFile() {
        FileLocation fileLocation = new FileLocation();
        List<FileFundamental> fileFundList = fileLocation.getBookFileFundementalList();
        WordDataOperation wordDataOperation = new WordDataOperation();
        FileFundamental fileFundamental = fileFundList.get(0);
        List<String> stringList = wordDataOperation.getWordListFromFile(fileFundamental);
        List<WordPool> wordPoolList = getWordListFromDB();

        List<String> idList = new ArrayList<>();
//        System.out.print("int[] idArr ={ ");
        wordPoolList.forEach(e -> {

            stringList.forEach(f -> {
                if (e.getWord().equals(f)) {
//                    System.out.print(e.getId() + ", ");
                    idList.add(e.getId() + "");
                }
            });
        });
        wordDataOperation.writeFileWordPoolId(idList);

//        System.out.println("};");
    }
*/


}