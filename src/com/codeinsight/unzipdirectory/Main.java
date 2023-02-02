package com.codeinsight.unzipdirectory;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        FolderUnzipper folderUnzipper = new FolderUnzipper();
        String sourcePath = "C:\\Users\\Pratham\\Downloads\\Ist Folder\\ByteStreamDemo.zip";
        String destinationpath = "C:\\Users\\Pratham\\Downloads\\Second Folder\\";
        try {
            folderUnzipper.unzip(sourcePath, destinationpath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
