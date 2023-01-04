package org.aes;

import org.aes.utillity.ReadableStringFormat;
import org.aes.utillity.SpecialCharacter;
import org.ahmeteminsaglik.fileoperation.business.abstracts.ReadFileService;
import org.ahmeteminsaglik.fileoperation.business.concretes.FileOperationFacade;
import org.ahmeteminsaglik.fileoperation.dataaccess.concretes.ReadFileManagement;
import org.ahmeteminsaglik.fileoperation.entities.concretes.FileFundamental;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FileOperation {
    //    private static Logger LOGGER =
//            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private ReadFileService readFileService = new ReadFileManagement();
    private FileOperationFacade fileOperationFacade = new FileOperationFacade(null, readFileService);

    public FileOperation() {
    }

    private List<FileFundamental> getBookFileFundementalList() {
        List<FileFundamental> filePaths = new ArrayList<>();
        String directory = "C:\\Users\\ahmet\\OneDrive\\Desktop\\books\\"; //directory For String Data

        try {
            DirectoryStream<Path> directoryStream = Files.newDirectoryStream(FileSystems.getDefault().getPath(directory));
            for (Path path : directoryStream) {
                FileFundamental fileFundamental = new FileFundamental();
                String nameWithExtension = path.getFileName().toString();
                String fileName = nameWithExtension.substring(0, nameWithExtension.lastIndexOf("."));
                String extension = nameWithExtension.substring(nameWithExtension.lastIndexOf("."));

                fileFundamental.setPath(directory);
                fileFundamental.setFileName(fileName);
                fileFundamental.setFileExtension(extension);
                filePaths.add(fileFundamental);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return filePaths;
    }


    public void createUniqeWords() {
        List<FileFundamental> list = getBookFileFundementalList();
        int fileNumber = 0;
        for (FileFundamental tmpFilefund : list) {
            readFileService.read(tmpFilefund);
            System.out.println("Process File :  " + ReadableStringFormat.getReadableValueIntToString((fileNumber + 1)) + " | " + ReadableStringFormat.getReadableValueIntToString(list.size()) + " | " + " file : " + list.get(fileNumber).getCompletePath());
            System.out.println("Total Line in file : " + ReadableStringFormat.getReadableValueIntToString(readFileService.getReadDataList().size()));
            List<String> readDataList = readFileService.getReadDataList();
            Set hashSet = new HashSet();
            for (String tmpStringLine : readDataList) {
                String stringLine = clearLineFromPunctuation(tmpStringLine);
                String[] wordArr = splitWordFromText(stringLine);

                List wordList = removeMeaninglessWordsInWordArray(wordArr);
//                System.out.println(wordList);
                hashSet.addAll(wordList);
            }

//            System.out.println(hashSet);
            System.out.println("-------------------------------");
            System.out.println("hashsetSize : " + hashSet.size());
//            List<String> uniqeWordList = new ArrayList<>(hashSet);
//            System.exit(0);
            fileNumber++;

            if(fileNumber>=10){
                System.exit(0);
            }
        }

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
