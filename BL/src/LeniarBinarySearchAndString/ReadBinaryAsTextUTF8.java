package LeniarBinarySearchAndString;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ReadBinaryAsTextUTF8 {

    /*
     * Reads bytes from a file using FileInputStream,
     * converts to characters using InputStreamReader (UTF-8),
     * and prints text line by line.
     */
    public static void main(String[] args) {
        String path = "input_utf8.txt"; // change this to your file path

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8)
        )) {
            String line;

            // Read and print
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("Error reading file with UTF-8: " + e.getMessage());
        }
    }
}


