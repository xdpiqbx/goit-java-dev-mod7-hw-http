package com.dpiqb;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusChecker {

    public String getStatusImage(int code){
        try {
            URL url = new URL(createUrl(code));
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            int status = con.getResponseCode();
            if(status == 404){
                throw new IllegalArgumentException(
                    "Status code [" + code + "] does not support. " + createUrl(status)
                );
            }
            return url.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private String createUrl(int code){
        return "https://http.cat/" + code + ".jpg";
    }
}
