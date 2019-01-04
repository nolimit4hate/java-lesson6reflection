package com.company;

import java.lang.annotation.Annotation;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.logging.Level;

public class JarRipper {
    /**
     * take from all JarEntry objects only *.class and load them with Classloader
     *
     * @param jarEntry Enumeration of JarEntry - everything in jar
     * @param loader   - ClassLoader type. if we find *.class we load this file by loader
     * @return map with Key = object Class type; Value = array of annotation of this class
     */
    public Map<Class, Annotation[]> JarClassesToMap(Enumeration<JarEntry> jarEntry, ClassLoader loader) {
        Map<Class, Annotation[]> classesMap = new HashMap<>();
        while (jarEntry.hasMoreElements()) {
            JarEntry currentJarEntry = jarEntry.nextElement();
            if (currentJarEntry.isDirectory() || !currentJarEntry.getName().endsWith(".class")) {
                continue;
            }
            // ".class" - 6 symbols
            String className = currentJarEntry.getName().substring(0, currentJarEntry.getName().length() - 6);
            // get something like com/company/name, but we need com.company.name
            className = className.replace('/', '.');
            try {
                Class clazz = loader.loadClass(className);
                classesMap.put(clazz, clazz.getAnnotations());
            } catch (ClassNotFoundException ex) {
                Main.log.log(Level.SEVERE, "ClassNotFound", ex);
            }
        }
        return classesMap;
    }

    public Map<Class, Annotation[]> jarToMap(ClassLoader loader) {

        return null;
    }


}
