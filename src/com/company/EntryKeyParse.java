package com.company;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

public class EntryKeyParse {

    private String fileName;
    private Map<Class, Annotation[]> outputMapClass;
    private Map<Class, List<PairNameOther>> outputMapFieldOrMethod;


    public EntryKeyParse() {
    }

    /**
     * take array of String and parse it
     *
     * @param keys is String[] args
     * @throws RuntimeException
     */
    public void parseKeys(String[] keys) throws RuntimeException {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i].equals("-n")) {
                i++;
                if (!keys[i].endsWith(".jar")) {
                    System.err.println("Wrong entering parameters. See with -h for more information");
                    throw new RuntimeException();
                }
                setFileName(keys[i]);
            }
            if (keys[i].equals("-h")) {
                System.out.println("\nEnter params in this form: -n fileName -nextParam\nAll params:" +
                        "\n-h" + "\toutput help" +
                        "\n-n" + "\tafter this param you must enter name of jarFile like this -n myJar.jar" +
                        "\n-c" + "\toutput information about classes and annotations" +
                        "\n-f" + "\toutput information about fields and annotations of classes" +
                        "\n-m" + "\toutput information about methods and annotations of classes");
            }
            if (keys[i].equals("-c")) {
                getHelp(ChooseWay.SHOWCLASS);
            }
            if (keys[i].equals("-f")) {
                getHelp(ChooseWay.SHOWFIELD);
            }
            if (keys[i].equals("-m")) {
                getHelp(ChooseWay.SHOWMETHOD);
            }
        }
    }

    /**
     * helps parseKeys. fill fields, show information, depends of way
     * if you choose SHOWCLASS - fill outputMapClass and show information about classes and annotations
     * if you choose SHOWFIELDS - fill outputMapClass with data about classes, outputMapFieldOrMethod with
     * data about classes, fields and annotations of this fields
     * if you choose SHOWMETHODS - fill outputMapClass with data about classes, outputMapFieldOrMethod with
     * data about classes, methods and annotations of this methods
     *
     * @param way
     */
    private void getHelp(ChooseWay way) {
        MagicMaker magicMaker = new MagicMaker();
        PrintThis printer = new PrintThis();
        if (fileName != null || fileName.endsWith(".jar")) {
            setOutputMapClass(magicMaker.makeMagicGetJarClasses(getFileName()));
            if (way == ChooseWay.SHOWCLASS) {
                printer.printClass(getOutputMapClass());
            }
            if (way == ChooseWay.SHOWFIELD) {
                setOutputMapFieldOrMethod(magicMaker.makeMagicGetClassFields(getFileName()));
                printer.printFieldMethod(getOutputMapFieldOrMethod());
            }
            if (way == ChooseWay.SHOWMETHOD) {
                setOutputMapFieldOrMethod(magicMaker.makeMagicGetClassMethods(getFileName()));
                printer.printFieldMethod(getOutputMapFieldOrMethod());
            }
        }

    }

    public String getFileName() {
        return fileName;
    }

    private void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Map<Class, Annotation[]> getOutputMapClass() {
        return outputMapClass;
    }

    private void setOutputMapClass(Map<Class, Annotation[]> outputMapClass) {
        this.outputMapClass = outputMapClass;
    }

    public Map<Class, List<PairNameOther>> getOutputMapFieldOrMethod() {
        return outputMapFieldOrMethod;
    }

    private void setOutputMapFieldOrMethod(Map<Class, List<PairNameOther>> outputMapFieldOrMethod) {
        this.outputMapFieldOrMethod = outputMapFieldOrMethod;
    }
}

