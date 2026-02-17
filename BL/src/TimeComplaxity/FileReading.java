package TimeComplaxity;

import java.io.*;

public class FileReading {
    public static void readFileWithFileReader(String filePath) throws IOException {
        FileReader fr = new FileReader(filePath);
        int ch;
        while ((ch = fr.read()) != -1) {
            // Process character by character
        }
        fr.close();
    }

    public static void readFileWithInputStreamReader(String filePath) throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath));
        int ch;
        while ((ch = isr.read()) != -1) {
            // Process character by character
        }
        isr.close();
    }

    public static void main(String[] args) {
        try {
            readFileWithFileReader("largefile.txt");
            readFileWithInputStreamReader("largefile.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}