package Sorting;

import java.util.Arrays;

class MSort{
    public static void mergeSort(int[] arr , int left , int right){
        int mid=0;
        if(left<right) {
            mid = left + (right - left) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
    public static void merge(int[] arr, int left , int mid ,int right ){
        int n1=mid-left+1;
        int n2 = right -mid;

        int[] leftArr= new int[n1];
        int[] rightArr= new int[n2];

        System.arraycopy(arr , left , leftArr , 0 ,n1);
        System.arraycopy(arr ,mid+1 , rightArr, 0 , n2);

        int i=0; int j=0; int k=left;
        while(i<n1 && j<n2){
            if(leftArr[i]<rightArr[j]){
                arr[k++]=leftArr[i++];
            }else{
                arr[k++]=rightArr[j++];
            }
        }
        while(i<n1)arr[k++]=leftArr[i++];
        while(j<n2)arr[k++]=rightArr[j++];
    }
}

public class MergeSort {
    public static void main (String[] args){
        int[] arr ={1,2,4,23456789,5,6,8,23456789,54,345678,3,5,765,432,34,567,6543,2,34567,8,765,43,456,78,765,43,456,78,7654,3,4567,876,5};

        MSort.mergeSort(arr , 0 , arr.length-1);

        System.out.println(Arrays.toString(arr));
    }
}
