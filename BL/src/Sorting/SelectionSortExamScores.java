package Sorting;

import java.util.Arrays;

public class SelectionSortExamScores {

    public static void selectionSort(int[] scores) {
        int n = scores.length;

        // One by one move boundary of unsorted part
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i; // assume first unsorted is min

            // Find minimum in unsorted part
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap min element with first unsorted element
            int temp = scores[i];
            scores[i] = scores[minIndex];
            scores[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] examScores = {78, 92, 65, 88, 70, 99, 81};

        System.out.println("Before: " + Arrays.toString(examScores));
        selectionSort(examScores);
        System.out.println("After : " + Arrays.toString(examScores));
    }
}