package com.company;

import java.lang.annotation.Annotation;

/**
 * this class was created to consist main general operations what often needed
 * but in consist only 1 method
 */
public class HelpToCreate {

    public static String annotationsToString(Annotation[] annotations){
        if(annotations == null || annotations.length == 0)
            return "";
        StringBuilder stringBuilder = new StringBuilder("");
        for(Annotation a : annotations){
            stringBuilder.append(a.toString());
        }
        return stringBuilder.toString();
    }
}
