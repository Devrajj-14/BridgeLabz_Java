package Sorting;

class QSort{
    public static void QuickSort(int[] arr , int low , int high ) {
        if (low < high) {

           int partition= merge(arr, low , high);
            QuickSort(arr,low , partition);
            QuickSort(arr,partition+1,high);
        }
    }
    public static int merge(int[] arr , int low , int high){
        int i= low-1;
        int j=high+1;

        int pivot=arr[i];
        while(true) {
            do {
                i++;
            } while (arr[i] < pivot);
            do {
                j++;
            } while (arr[j] > pivot);

            if (i >= j) {
                return j;
            }

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}

public class QuickSort {

}
