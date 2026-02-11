package LeniarBinarySearchAndString;

import java.util.concurrent.TimeUnit;

public class CompareBufferVsBuilder {

    /*
     * Compares StringBuffer and StringBuilder performance for concatenation.
     * StringBuffer is synchronized (thread-safe), StringBuilder is not (faster in single-thread).
     */
    public static void main(String[] args) {
        final int N = 1_000_000;
        final String word = "hello";

        // Warm-up to reduce first-run JVM effects (simple and practical)
        warmUp(N / 10, word);

        long sbTime = testStringBuilder(N, word);
        long bufTime = testStringBuffer(N, word);

        System.out.println("Appends: " + N);
        System.out.println("StringBuilder time: " + formatNanos(sbTime));
        System.out.println("StringBuffer  time: " + formatNanos(bufTime));
    }

    private static void warmUp(int n, String word) {
        // Warm-up: builder
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append(word);

        // Warm-up: buffer
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < n; i++) buf.append(word);
    }

    private static long testStringBuilder(int n, String word) {
        StringBuilder sb = new StringBuilder(n * word.length());
        long start = System.nanoTime();

        // Append in a loop
        for (int i = 0; i < n; i++) sb.append(word);

        long end = System.nanoTime();

        // Use the result so JVM doesn't optimize it away
        if (sb.length() == 0) System.out.println("Impossible");

        return end - start;
    }

    private static long testStringBuffer(int n, String word) {
        StringBuffer buf = new StringBuffer(n * word.length());
        long start = System.nanoTime();

        // Append in a loop
        for (int i = 0; i < n; i++) buf.append(word);

        long end = System.nanoTime();

        // Use the result so JVM doesn't optimize it away
        if (buf.length() == 0) System.out.println("Impossible");

        return end - start;
    }

    private static String formatNanos(long nanos) {
        long ms = TimeUnit.NANOSECONDS.toMillis(nanos);
        return ms + " ms (" + nanos + " ns)";
    }
}