package org.aes;

import org.ahmeteminsaglik.fileoperation.entities.concretes.FileFundamental;

import java.io.File;
import java.util.List;

public class DeleteBrokenFileMain {
    public static void main(String[] args) {
        FileOperation fileOperation = new FileOperation();
        String path = "C:\\Users\\ahmet\\OneDrive\\Desktop\\books-data\\brokenFile\\";
        List<String> list = fileOperation.read(new FileFundamental().setPath(path).setFileName("broken-File-Names").setFileExtension(".txt"));
        for (String tmp : list) {
//            System.out.println("file : "+tmp);
            File file = new File(tmp);
            System.out.println(file);
            System.out.println(file.toString());

            if(file.delete()){
                System.out.println("file is deleted : "+file);
            }
        }

    }
}
