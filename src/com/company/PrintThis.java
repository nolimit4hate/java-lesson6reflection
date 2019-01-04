package com.company;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

/**
 * some class for output information about Map
 */
public class PrintThis {
    /**
     * output information about class and his annotations
     *
     * @param mapToPrint
     */
    public void printClass(Map<Class, Annotation[]> mapToPrint) {
        mapToPrint.forEach((k, v) -> {
            System.out.print(k.toString());
            System.out.println("\t" + HelpToCreate.annotationsToString(v));
        });
    }

    /**
     * output information about fields or method and its annotations(this information are located in value of Map)
     * of the classes which are located in Key of current map
     *
     * @param mapToPrint
     */
    public void printFieldMethod(Map<Class, List<PairNameOther>> mapToPrint) {
        mapToPrint.forEach((k, v) -> {
            System.out.println(k.toString());
            if (v != null) {
                System.out.print("\t");
                this.printPairList(v);
            }
        });
    }

    private void printPairList(List<PairNameOther> pairList) {
        for (PairNameOther pair : pairList) {
            System.out.println(pair.toString());
        }
    }


}
