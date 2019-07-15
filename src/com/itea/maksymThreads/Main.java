package com.itea.maksymThreads;

import com.itea.maksymThreads.models.User;
import com.itea.maksymThreads.resource.Users;
import com.itea.maksymThreads.threads.*;

public class Main {
    public static int endOfParse = 0;
    public static void main(String[] args) {
        Parser p = new Parser(4);
        Filler f = new Filler();
        f.setDaemon(true);
        f.start();
        p.start();
        while(endOfParse==0){
            System.out.println(Users.users.size());
        }

        System.out.println("{");
        for(User u: Users.users) {
            System.out.print("\t"+u);
        }
        System.out.println("}");
    }
}
