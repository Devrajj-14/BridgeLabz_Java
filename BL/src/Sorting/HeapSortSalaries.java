package Sorting;

import java.util.Arrays;

public class HeapSortSalaries {

    public static void heapSort(int[] salaries) {
        int n = salaries.length;

        // 1) Build Max Heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salaries, n, i);
        }

        // 2) Extract elements from heap one by one
        for (int end = n - 1; end > 0; end--) {
            // Move current root (largest) to end
            int temp = salaries[0];
            salaries[0] = salaries[end];
            salaries[end] = temp;

            // Heapify reduced heap
            heapify(salaries, end, 0);
        }
    }

    // Maintains Max Heap property for subtree rooted at i
    private static void heapify(int[] arr, int heapSize, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < heapSize && arr[left] > arr[largest]) largest = left;
        if (right < heapSize && arr[right] > arr[largest]) largest = right;

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, heapSize, largest);
        }
    }

    public static void main(String[] args) {
        int[] expectedSalaries = {55000, 72000, 48000, 60000, 90000, 51000};

        System.out.println("Before: " + Arrays.toString(expectedSalaries));
        heapSort(expectedSalaries);
        System.out.println("After : " + Arrays.toString(expectedSalaries));
    }
}