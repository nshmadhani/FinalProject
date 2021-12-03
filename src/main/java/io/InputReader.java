package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputReader {


    private static String DIRECTORY = System.getProperty("user.dir") + "/inputs/";

    public static String[] loadFile(String fileName) {

        File inputFile = new File(DIRECTORY, fileName);
        System.out.println(inputFile.getAbsolutePath());


        List<String> input = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            String line;
            while ((line = br.readLine()) != null) {
                // process the line.
                input.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return input.toArray(new String[0]);
    }


}
