package com.dpiqb;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
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
        Path path = Paths.get("./" + code + ".jpg");
        File file = new File(path.toUri());
        if(file.exists()){
          file.delete();
          Files.copy(in, path);
        }else{
          Files.copy(in, path);
        }
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    } catch (IllegalArgumentException e){
      throw new IllegalArgumentException(code+"");
    } catch (RuntimeException e) {
      throw new RuntimeException(e);
    }
  }
}
