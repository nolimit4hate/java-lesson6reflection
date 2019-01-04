package com.company;

public class JarPath {
    /**
     * @param jarName name of file in format NAME.TYPE like SomeJar.jar
     *                this .jar must be in project folder
     * @return full path of this file or "null" if the file name incorrect
     */
    public static String getJarPath(String jarName) {
        if ((jarName != null) && (jarName.length() > 4)) {

            String workDir = System.getProperty("user.dir") + System.getProperty("file.separator");
            return (workDir + jarName);
        }
        System.err.println("Something wrong with filename, enter correct!");
        return null;
    }


}
