package javaMethods.level3;

public class FootballTeamHeightStats {

    // random height between 150 and 250
    public static int[] generateHeights(int size) {
        int[] heights = new int[size];

        // loop to fill random heights
        for (int i = 0; i < heights.length; i++) {
            heights[i] = 150 + (int) (Math.random() * 101);
        }

        return heights;
    }

    public static int findSum(int[] arr) {
        int sum = 0;

        // loop for sum
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }

        return sum;
    }

    public static double findMean(int[] arr) {
        return (double) findSum(arr) / arr.length;
    }

    public static int findShortest(int[] arr) {
        int min = Integer.MAX_VALUE;

        // loop for shortest
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) min = arr[i];
        }

        return min;
    }

    public static int findTallest(int[] arr) {
        int max = Integer.MIN_VALUE;

        // loop for tallest
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }

        return max;
    }

    public static void main(String[] args) {
        int[] heights = generateHeights(11);

        // printing heights
        for (int i = 0; i < heights.length; i++) {
            System.out.println("player " + (i + 1) + " height " + heights[i]);
        }

        double mean = findMean(heights);
        int shortest = findShortest(heights);
        int tallest = findTallest(heights);

        System.out.println("shortest " + shortest);
        System.out.println("tallest " + tallest);
        System.out.println("mean " + mean);
    }
}
