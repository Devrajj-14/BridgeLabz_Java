package Sorting;

import java.util.Arrays;

class ISort{
    public static void Check(int[] arr){
        for(int i=0; i <arr.length;i++){
            int key=arr[i];
            int j=i-1;
            while(j>=0 && arr[j]>key){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
    }
}

public class InsertionSort {
    public static void main(String[] args){
        int[] arr= {1,4,3,5,2,5,78,4,3,7,6,543,2};
        ISort.Check(arr);
        System.out.println(Arrays.toString(arr));
    }
}
