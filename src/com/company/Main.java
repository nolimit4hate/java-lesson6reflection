package com.company;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class Main {
    public static Logger log = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        String jarName = "testedPlanet.jar";
        MagicMaker newMagicMaker = new MagicMaker();
        Map<Class, List<PairNameOther>> myMapField = newMagicMaker.makeMagicGetClassFields(jarName);
        System.out.println("########");
        myMapField = newMagicMaker.makeMagicGetClassMethods(jarName);
    }
}
