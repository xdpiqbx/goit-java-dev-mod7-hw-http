package com.dpiqb;

public class App {
    public static void main(String[] args) {
        HttpStatusImageDownloader httpStatusImageDownloader = new HttpStatusImageDownloader();
        // TODO check if image exist, if exist do not download.
        httpStatusImageDownloader.downloadStatusImage(203);
    }
}
