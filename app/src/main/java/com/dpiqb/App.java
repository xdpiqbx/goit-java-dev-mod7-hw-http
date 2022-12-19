package com.dpiqb;

public class App {
    public static void main(String[] args) {
        HttpStatusChecker httpStatusChecker = new HttpStatusChecker();
        System.out.println(httpStatusChecker.getStatusImage(2000));
    }
}
