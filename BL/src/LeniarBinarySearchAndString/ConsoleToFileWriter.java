package LeniarBinarySearchAndString;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;

public class ConsoleToFileWriter {

    /*
     * Reads user input from console using InputStreamReader + BufferedReader,
     * writes each line into a file using FileWriter (wrapped in BufferedWriter),
     * stops when user types "exit".
     */
    public static void main(String[] args) {
        String outputPath = "output.txt"; // change this if needed

        try (
                BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath, true))
        ) {
            System.out.println("Type lines to save. Type 'exit' to stop.");

            while (true) {
                // Read a line from user
                String input = console.readLine();

                if (input == null) break; // safety: stream closed
                if ("exit".equalsIgnoreCase(input.trim())) break;

                // Write line and newline
                writer.write(input);
                writer.newLine();

                // Flush so data is actually written (good habit)
                writer.flush();
            }

            System.out.println("Saved input to: " + outputPath);

        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}