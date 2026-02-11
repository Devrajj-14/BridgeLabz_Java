package LeniarBinarySearchAndString;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileLineByLine {

    /*
     * Reads a text file line by line using FileReader and BufferedReader.
     * Prints each line to console.
     */
    public static void main(String[] args) {
        String path = "input.txt"; // change this to your file path

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;

            // Read lines until EOF (null)
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            // If file missing or read fails, you'll see it here
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
