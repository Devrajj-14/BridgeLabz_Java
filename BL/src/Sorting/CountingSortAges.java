package Sorting;

import java.util.Arrays;

public class CountingSortAges {

    public static void countingSortAges(int[] ages) {
        int minAge = 10;
        int maxAge = 18;

        int range = maxAge - minAge + 1;
        int[] count = new int[range];

        // 1) Frequency count
        for (int age : ages) {
            if (age < minAge || age > maxAge) {
                throw new IllegalArgumentException("Age out of range: " + age);
            }
            count[age - minAge]++;
        }

        // 2) Rebuild sorted array (ascending)
        int index = 0;
        for (int i = 0; i < range; i++) {
            int age = i + minAge;
            while (count[i] > 0) {
                ages[index++] = age;
                count[i]--;
            }
        }
    }

    public static void main(String[] args) {
        int[] studentAges = {12, 15, 11, 18, 10, 14, 12, 16, 10};

        System.out.println("Before: " + Arrays.toString(studentAges));
        countingSortAges(studentAges);
        System.out.println("After : " + Arrays.toString(studentAges));
    }
}