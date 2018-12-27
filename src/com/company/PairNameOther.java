package com.company;

import java.lang.annotation.Annotation;

/**
 * class for comfortable presentation data of Class
 */
public class PairNameOther {
    private String name;
    private String other;
    private Annotation[] annotations;

    public PairNameOther(String name, String other) {
        this.name = name;
        this.other = other;
    }

    public PairNameOther(String name, String other, Annotation[] annotations) {
        this.name = name;
        this.other = other;
        this.annotations = annotations;
    }

    @Override
    public String toString() {
        return "[" + this.name + "] [" + this.other + "] " +
                HelpToCreate.annotationsToString(this.annotations);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public Annotation[] getAnnotations() {
        return annotations;
    }

    public void setAnnotations(Annotation[] annotations) {
        this.annotations = annotations;
    }
}
