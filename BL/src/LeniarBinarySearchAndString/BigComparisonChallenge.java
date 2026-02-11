package LeniarBinarySearchAndString;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

public class BigComparisonChallenge {

    /*
     * Challenge:
     * 1) Compare StringBuilder vs StringBuffer for 1,000,000 appends.
     * 2) Compare FileReader vs InputStreamReader for reading a large file and counting words.
     */
    public static void main(String[] args) {
        final int N = 1_000_000;
        final String word = "hello";

        // ---- Part A: String concat benchmark ----
        warmUp(N / 10, word);

        long builderTime = concatWithBuilder(N, word);
        long bufferTime  = concatWithBuffer(N, word);

        System.out.println("=== String Concatenation (1,000,000 appends) ===");
        System.out.println("StringBuilder time: " + formatNanos(builderTime));
        System.out.println("StringBuffer  time: " + formatNanos(bufferTime));

        // ---- Part B: File reading benchmark ----
        String bigFilePath = "bigfile.txt"; // put your 100MB text file here

        System.out.println("\n=== Large File Word Count Comparison ===");

        long frStart = System.nanoTime();
        long wordsByFileReader = countWordsUsingFileReader(bigFilePath);
        long frEnd = System.nanoTime();

        long isrStart = System.nanoTime();
        long wordsByInputStreamReader = countWordsUsingInputStreamReader(bigFilePath);
        long isrEnd = System.nanoTime();

        System.out.println("FileReader word count:        " + wordsByFileReader + " | time: " + formatNanos(frEnd - frStart));
        System.out.println("InputStreamReader word count: " + wordsByInputStreamReader + " | time: " + formatNanos(isrEnd - isrStart));
    }

    private static void warmUp(int n, String word) {
        // Quick warm-up so timings are less jumpy
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append(word);

        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < n; i++) buf.append(word);
    }

    private static long concatWithBuilder(int n, String word) {
        StringBuilder sb = new StringBuilder(n * word.length());
        long start = System.nanoTime();

        // Append repeatedly
        for (int i = 0; i < n; i++) sb.append(word);

        long end = System.nanoTime();

        // Use length to prevent useless optimization
        if (sb.length() == 0) System.out.println("Impossible");

        return end - start;
    }

    private static long concatWithBuffer(int n, String word) {
        StringBuffer buf = new StringBuffer(n * word.length());
        long start = System.nanoTime();

        // Append repeatedly
        for (int i = 0; i < n; i++) buf.append(word);

        long end = System.nanoTime();

        // Use length to prevent useless optimization
        if (buf.length() == 0) System.out.println("Impossible");

        return end - start;
    }

    private static long countWordsUsingFileReader(String path) {
        long words = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;

            // Read line by line
            while ((line = br.readLine()) != null) {
                words += countWordsInLine(line);
            }

        } catch (IOException e) {
            System.out.println("FileReader error: " + e.getMessage());
        }

        return words;
    }

    private static long countWordsUsingInputStreamReader(String path) {
        long words = 0;

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8)
        )) {
            String line;

            // Read line by line
            while ((line = br.readLine()) != null) {
                words += countWordsInLine(line);
            }

        } catch (IOException e) {
            System.out.println("InputStreamReader error: " + e.getMessage());
        }

        return words;
    }

    private static int countWordsInLine(String line) {
        int count = 0;
        boolean inWord = false;

        // Count word boundaries without heavy split() (faster for large files)
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);

            if (Character.isWhitespace(c)) {
                inWord = false;
            } else {
                if (!inWord) {
                    count++;
                    inWord = true;
                }
            }
        }

        return count;
    }

    private static String formatNanos(long nanos) {
        long ms = TimeUnit.NANOSECONDS.toMillis(nanos);
        return ms + " ms (" + nanos + " ns)";
    }
}
