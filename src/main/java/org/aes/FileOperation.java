package org.aes;

import org.ahmeteminsaglik.fileoperation.business.abstracts.ReadFileService;
import org.ahmeteminsaglik.fileoperation.business.abstracts.WriteFileService;
import org.ahmeteminsaglik.fileoperation.business.concretes.FileOperationFacade;
import org.ahmeteminsaglik.fileoperation.dataaccess.concretes.ReadFileManagement;
import org.ahmeteminsaglik.fileoperation.dataaccess.concretes.WriteFileManagement;
import org.ahmeteminsaglik.fileoperation.entities.concretes.FileFundamental;

import java.util.List;

public class FileOperation {
    private ReadFileService readFileService = new ReadFileManagement();
    private WriteFileService writeFileService= new WriteFileManagement();
    private FileOperationFacade fileOperationFacade = new FileOperationFacade(null, readFileService);

    public List<String> read(FileFundamental fileFund) {
        readFileService.read(fileFund);
        return readFileService.getReadDataList();
    }

    public void clearList() {
        readFileService.clearList();
    }
    public  void appendFile(String text){
        String path = "C:\\Users\\ahmet\\OneDrive\\Desktop\\books-data\\uniqewords\\";
        FileFundamental fileFundamental = new FileFundamental().setPath(path).setFileName("uniqe-words").setFileExtension(".txt");
        writeFileService.append(fileFundamental,text);

    }

}
