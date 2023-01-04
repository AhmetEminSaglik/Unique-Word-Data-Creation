package org.aes.model;

import org.ahmeteminsaglik.fileoperation.entities.concretes.FileFundamental;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileLocation {
    public List<FileFundamental> getBookFileFundementalList() {
        List<FileFundamental> filePaths = new ArrayList<>();
        String directory = "C:\\Users\\ahmet\\OneDrive\\Desktop\\books-data\\books\\"; //directory For String Data

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
}
