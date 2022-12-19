package com.dpiqb;

public class App {
    public static void main(String[] args) {
        HttpStatusImageDownloader httpStatusImageDownloader = new HttpStatusImageDownloader();
        httpStatusImageDownloader.downloadStatusImage(200);
    }
}
