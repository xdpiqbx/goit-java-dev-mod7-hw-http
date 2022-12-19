package com.dpiqb;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HttpStatusImageDownloader {
    private HttpStatusChecker httpStatusChecker;

    HttpStatusImageDownloader(){
        httpStatusChecker = new HttpStatusChecker();
    }

    void downloadStatusImage(int code){
        try{
            String imageUrl = httpStatusChecker.getStatusImage(code);
            try(InputStream in = new URL(imageUrl).openStream()){
                Files.copy(in, Paths.get("./" + code + ".jpg"));
            }
        } catch (IllegalArgumentException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
