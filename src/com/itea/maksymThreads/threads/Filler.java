package com.itea.maksymThreads.threads;

import com.itea.maksymThreads.models.JsonParser;

public class Filler extends Thread {
    private String json = null;

    @Override
    public void run() {
        System.out.println("Daemon filler started");
        try {
            while (true) {
                String tmp = Parser.setAndGet(null);
                if(tmp != null) {
                    if(json == null) {
                        json = tmp;
                        new JsonParser(json).fillArray();
                    } else {
                        if(!json.equals(tmp)) {
                            json = tmp;
                            new JsonParser(json).fillArray();
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
