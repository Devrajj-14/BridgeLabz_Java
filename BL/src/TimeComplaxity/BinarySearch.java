package TimeComplaxity;

import java.util.Arrays;

public class BinarySearch {
    public static int search(int[] arr, int target) {
        Arrays.sort(arr);  // Ensure the array is sorted
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;  // target found
            }
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;  // target not found
    }

    public static void main(String[] args) {
        int[] dataset = {1, 3, 5, 7, 9, 11, 13, 15, 17};
        int target = 7;
        int result = search(dataset, target);
        System.out.println("Target found at index: " + result);
    }
}