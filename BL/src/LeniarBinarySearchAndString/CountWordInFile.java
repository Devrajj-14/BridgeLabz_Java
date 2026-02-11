package LeniarBinarySearchAndString;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountWordInFile {

    /*
     * Counts how many times a target word appears in a file.
     * Uses FileReader + BufferedReader.
     */
    public static void main(String[] args) {
        String path = "input.txt";      // change this
        String target = "hello";        // change this
        boolean ignoreCase = true;      // set false if you want case-sensitive

        int count = countWordOccurrences(path, target, ignoreCase);
        System.out.println("Word '" + target + "' occurred: " + count + " times");
    }

    private static int countWordOccurrences(String path, String target, boolean ignoreCase) {
        int total = 0;

        if (ignoreCase) target = target.toLowerCase();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;

            // Read each line and check words
            while ((line = br.readLine()) != null) {

                // Split by whitespace
                String[] words = line.split("\\s+");

                for (String w : words) {
                    // Clean punctuation from start/end (basic and practical)
                    String cleaned = w.replaceAll("^[^a-zA-Z0-9]+|[^a-zA-Z0-9]+$", "");

                    if (ignoreCase) cleaned = cleaned.toLowerCase();

                    if (cleaned.equals(target)) {
                        total++;
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return total;
    }
}