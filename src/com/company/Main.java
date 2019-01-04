package com.company;

import java.util.logging.Logger;

public class Main {
    public static Logger log = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        EntryKeyParse keyParse = new EntryKeyParse();
        keyParse.parseKeys(args);
    }
}
