package javaMethods.level2;

public class Random4DigitStats {

    public static int[] generate4DigitRandomArray(int size) {
        int[] arr = new int[size];

        // loop for random 4 digit numbers
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1000 + (int) (Math.random() * 9000);
        }

        return arr;
    }

    // returns average min max in double array
    public static double[] findAverageMinMax(int[] numbers) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        long sum = 0;

        // loop for sum min max
        for (int i = 0; i < numbers.length; i++) {
            int v = numbers[i];
            sum += v;

            if (v < min) min = v;
            if (v > max) max = v;
        }

        double avg = (double) sum / numbers.length;

        return new double[]{avg, min, max};
    }

    public static void main(String[] args) {
        int[] arr = generate4DigitRandomArray(5);

        // printing numbers
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        double[] res = findAverageMinMax(arr);

        System.out.println("average " + res[0]);
        System.out.println("min " + (int) res[1]);
        System.out.println("max " + (int) res[2]);
    }
}
