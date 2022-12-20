package com.dpiqb;

import java.util.Objects;
import java.util.Scanner;

public class HttpImageStatusCli {
  private final String ASK_FOR_HTTP_STATUS = "Enter HTTP status code or [q] to quit: ";
  private final String ASK_FOR_VALID_DATA = "Please enter valid number\n";
  private final String DOWLOADED = "Image dowloaded.\n";
  private HttpStatusImageDownloader httpStatusImageDownloader;
  HttpImageStatusCli(){
    httpStatusImageDownloader = new HttpStatusImageDownloader();
  }

  public void askStatus(){
    try(Scanner scanner = new Scanner(System.in)){
      while(true){
        System.out.print(ASK_FOR_HTTP_STATUS);
        String input = scanner.nextLine().strip();

        // to quit from app
        if (Objects.equals(input, "q")){
          break;
        }

        // if input length too big continue (normally it's 3 char length)
        if (input.length() != 3){
          System.out.println(ASK_FOR_VALID_DATA);
          continue;
        }

        try {
          int code = Integer.parseInt(input);
          //in http specification status code max is - 599
          if(code > 599){
            System.out.println(ASK_FOR_VALID_DATA);
            continue;
          }
          // if everything ok
          httpStatusImageDownloader.downloadStatusImage(code);
          System.out.println(DOWLOADED);
        } catch (NumberFormatException e){
          // 12h j21 hjk ...
          System.out.println(ASK_FOR_VALID_DATA);
        } catch (IllegalArgumentException e){
          // no image for HTTP status code
          System.out.println(
            responseNoImage(e.getMessage())
          );
        }
      }
    }
  }

  private String responseNoImage(String code){
    return "There is no image for HTTP status code: " + code + "\n";
  }
}
