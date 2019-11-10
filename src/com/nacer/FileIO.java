package com.nacer;

import java.io.*;

public class FileIO {

    public static StringBuffer read(String pathToFile) throws IOException {
        return readFromFile(pathToFile);
    }

    public static void write(String pathToFile, String data, int noOfLines) throws IOException {
        writeToFile(pathToFile, data, noOfLines);
    }

    private static StringBuffer readFromFile(String pathToFile) throws IOException {
        File file = new File(pathToFile);
        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        StringBuffer sb = new StringBuffer();

        while ((st = br.readLine()) != null) {
            if (st.isEmpty()) continue;
            sb.append(st + '\n');
        }
        return sb;
    }

    private static void writeToFile(String pathToFile, String data, int noOfLines) {
        File file = new File(pathToFile);
        FileWriter fr = null;
        BufferedWriter br = null;
        String dataWithNewLine = data + System.getProperty("line.separator");
        try {
            fr = new FileWriter(file);
            br = new BufferedWriter(fr);
            for (int i = noOfLines; i > 0; i--) {
                br.write(dataWithNewLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
