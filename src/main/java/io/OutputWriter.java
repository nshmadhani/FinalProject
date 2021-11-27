package io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class OutputWriter {

    private static String DIRECTORY = System.getProperty("user.dir") + "/outputs/";

    public static boolean writeFile(Object[] data, String fileName) {

        File inputFile = new File(DIRECTORY, fileName);

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        PrintWriter printWriter = new PrintWriter(fileWriter);
        for (Object s : data) {
            printWriter.println(s);
        }

        printWriter.close();


        return true;
    }

    public static boolean writeFile(Object data, String fileName) {

        File inputFile = new File(DIRECTORY, fileName);

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(data);


        printWriter.close();


        return true;
    }

}
