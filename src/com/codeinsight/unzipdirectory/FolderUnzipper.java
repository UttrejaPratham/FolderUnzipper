package com.codeinsight.unzipdirectory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class FolderUnzipper {
    public void unzip(String zipFilePath, String destDirectory) throws IOException {
        FileExtractor fileExtractor = null;
        File destDir = new File(destDirectory);
        if (!destDir.exists()) {
            destDir.mkdir();
        }
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(zipFilePath));
        ZipEntry entry = zipInputStream.getNextEntry();
        fileExtractor = new FileExtractor();
        while (entry != null) {
            String filePath = destDirectory + File.separator + entry.getName();
            if (!entry.isDirectory()) {
                fileExtractor.extractFile(zipInputStream, filePath);
            } else {
                File dir = new File(filePath);
                dir.mkdirs();
            }
            zipInputStream.closeEntry();
            entry = zipInputStream.getNextEntry();
        }
        zipInputStream.close();
    }
}
