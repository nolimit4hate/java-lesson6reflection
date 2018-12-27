package com.company;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.logging.Level;

public class JarLoad {

    /**
     * @param jarName - name of file
     * @return Enumeration of JarEntry - all that consist in jar file
     */
    public Enumeration<JarEntry> getJarEntrys(String jarName) {
        JarFile jarFile = null;
        try {
            jarFile = new JarFile(JarPath.getJarPath(jarName));
        } catch (IOException ex) {
            Main.log.log(Level.SEVERE, "Some IOException", ex);
            System.err.println("Got new Err");
        }
        return jarFile.entries();
    }

    /**
     * @param jarName name of file
     * @return URLClassLoader - create new instance of URLCLassloader for our URL
     */
    public URLClassLoader loadClassJar(String jarName) {
        try {
            URL[] urls = {new URL("jar:file:" + JarPath.getJarPath(jarName) + "!/")};
            return URLClassLoader.newInstance(urls);
        } catch (MalformedURLException ex) {
            Main.log.log(Level.SEVERE, "URL ERR", ex);
        }
        return null;
    }

}
