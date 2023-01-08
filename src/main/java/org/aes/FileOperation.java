package org.aes;

import org.ahmeteminsaglik.ReadableFormat;
import org.ahmeteminsaglik.fileoperation.business.abstracts.ReadFileService;
import org.ahmeteminsaglik.fileoperation.business.abstracts.WriteFileService;
import org.ahmeteminsaglik.fileoperation.business.concretes.FileOperationFacade;
import org.ahmeteminsaglik.fileoperation.dataaccess.concretes.ReadFileManagement;
import org.ahmeteminsaglik.fileoperation.dataaccess.concretes.WriteFileManagement;
import org.ahmeteminsaglik.fileoperation.entities.concretes.FileFundamental;

import java.util.List;

public class FileOperation {
    private ReadFileService readFileService = new ReadFileManagement();
    private WriteFileService writeFileService = new WriteFileManagement();
    private FileOperationFacade fileOperationFacade = new FileOperationFacade(null, readFileService);

    public List<String> read(FileFundamental fileFund) {
        readFileService.read(fileFund);
        return readFileService.getReadDataList();
    }

    public void clearList() {
        readFileService.clearList();
    }

    public void writeFile(List<String> list) {
//        String path = "C:\\Users\\ahmet\\OneDrive\\Desktop\\books-data\\uniqe-words -2\\";
        String path = "C:\\Users\\ahmet\\OneDrive\\Desktop\\books-data\\unique-english-words\\";
        FileFundamental fileFundamental = new FileFundamental().setPath(path).setFileName("uniqe-words").setFileExtension(".txt");
        writeFileService.write(fileFundamental, list);
        System.out.println("total printed word size : " + ReadableFormat.getStringValue(list.size()));

    }

    public void writeFile(List<String> list, String fileName) {
//        String path = "C:\\Users\\ahmet\\OneDrive\\Desktop\\books-data\\uniqe-words -2\\";
        String path = "C:\\Users\\ahmet\\OneDrive\\Desktop\\books-data\\word-data\\";
        FileFundamental fileFundamental = new FileFundamental().setPath(path).setFileName(fileName).setFileExtension(".txt");
//        writeFileService.write(fileFundamental, list);
        writeFileService.write(fileFundamental,list);
        System.out.println("total printed word size : " + ReadableFormat.getStringValue(list.size()));

    }public void writeFile(List<String> list, String path,String fileName) {
//        String path = "C:\\Users\\ahmet\\OneDrive\\Desktop\\books-data\\uniqe-words -2\\";
//        String path = "C:\\Users\\ahmet\\OneDrive\\Desktop\\books-data\\word-data\\";
        FileFundamental fileFundamental = new FileFundamental().setPath(path).setFileName(fileName).setFileExtension(".txt");
//        writeFileService.write(fileFundamental, list);
        writeFileService.write(fileFundamental,list);
        System.out.println("total printed word size : " + ReadableFormat.getStringValue(list.size()));

    }

    public void appendDBProcessTime(String msg) {
        String path = "C:\\Users\\ahmet\\OneDrive\\Desktop\\books-data\\db-process\\";
        FileFundamental fileFundamental = new FileFundamental().setPath(path).setFileName("db-process-time").setFileExtension(".txt");
        writeFileService.append(fileFundamental, msg);

    }

}
