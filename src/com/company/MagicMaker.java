package com.company;

import java.lang.annotation.Annotation;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * consist operations with .jar files, making new list(map) with information about
 * classes in *.jar file and output information on screen.
 * This *.jar file must be in project directory
 */

public class MagicMaker {
    /**
     * @param jarName - name of jar in format fileName.jar
     * @return Map with Key = Class type objects which was in *.jar file,
     * value = array of annotations of this class
     */
    public Map<Class, Annotation[]> makeMagicGetJarClasses(String jarName) {
        System.out.println("Classes in " + JarPath.getJarPath(jarName));
        JarLoad loadJar = new JarLoad();
        JarRipper ripperJar = new JarRipper();
        Map<Class, Annotation[]> classMap = ripperJar.JarClassesToMap(loadJar.getJarEntrys(jarName), loadJar.loadClassJar(jarName));
        return classMap;
    }

    /**
     * class take name of jar file and output Map of Key = Class obj; Value = information about fields of this class
     * with PairNameOther type. also output this information on screen
     *
     * @param jarName file name of jar
     * @return Map of Key is Class obects, Value is List<PairNameOther> information about fields of this class
     */
    public Map<Class, List<PairNameOther>> makeMagicGetClassFields(String jarName) {
        return this.classFieldOrMethod(ChooseWay.RETURN_CLASS_FIELDS, jarName);
    }

    /**
     * class take name of jar file and output Map of Key = Class obj; Value = information about methods of this class
     * with PairNameOther type. also output this information on screen
     *
     * @param jarName file name of jar
     * @return Map of Key is Class obects, Value is List<PairNameOther> information about methods of this class
     */

    public Map<Class, List<PairNameOther>> makeMagicGetClassMethods(String jarName) {
        return this.classFieldOrMethod(ChooseWay.RETURN_CLASS_METHODS, jarName);
    }

    /**
     * private method that help to build Map with need data of classes
     *
     * @param way     is key that decide what information will be returned
     * @param jarName file name of jar
     * @return need Map with classes and their data
     */
    private Map<Class, List<PairNameOther>> classFieldOrMethod(ChooseWay way, String jarName) {
        Map<Class, Annotation[]> classMap = this.makeMagicGetJarClasses(jarName);
        Map<Class, List<PairNameOther>> fieldsMap = new LinkedHashMap<>();
        ClassInfo classInfo = new ClassInfo();
        PrintThis printer = new PrintThis();
        classMap.forEach((k, v) -> {
            if (way == ChooseWay.RETURN_CLASS_FIELDS)
                fieldsMap.put(k, classInfo.getClassFields(k));
            if (way == ChooseWay.RETURN_CLASS_METHODS)
                fieldsMap.put(k, classInfo.getClassMethods(k));
        });
        printer.printFieldMethod(fieldsMap);
        return fieldsMap;
    }


}
