package TimeComplaxity;

public class LinearSearch {
    public static int search(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // return index if target is found
            }
        }
        return -1; // target not found
    }

    public static void main(String[] args) {
        int[] dataset = {1, 3, 5, 7, 9, 11, 13, 15, 17};
        int target = 7;
        int result = search(dataset, target);
        System.out.println("Target found at index: " + result);
    }
}