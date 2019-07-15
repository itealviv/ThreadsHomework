package com.itea.maksymThreads.threads;


import com.itea.maksymThreads.services.HttpClient;
import com.itea.maksymThreads.Main;

public class Parser extends Thread {
    private int pages;
    private static String json;

    public Parser(int pages) {
        this.pages = pages;
    }

    @Override
    public void run() {
        System.out.println("Parser started");
        try {
            while(pages>0) {
                String js = new HttpClient("https://reqres.in/api/users?page="+pages).getResponseBody();
                Parser.setAndGet(js);
                Thread.sleep(500);
                pages--;
            }
            System.out.println("Parser end of work");
            Main.endOfParse = 1;

        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }

    synchronized static String setAndGet(String newValue) {
        if(newValue == null) {
            return Parser.json;
        } else {
            Parser.json = newValue;
            return newValue;
        }
    }
}
