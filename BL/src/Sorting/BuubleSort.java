package Sorting;

import java.util.Arrays;

class Sort{
    public static void sort(int[] arr){
        boolean swaped;
        for(int i=0; i<arr.length; i++){
            swaped=false;
            for(int j=0; j<arr.length-1-i; j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    swaped=true;
                }

            }
            if(!swaped)break;
        }

    }
}

public class BuubleSort {
    public static void main(String[]  args){
        //Sort s1= new Sort();
        int[] arr= {2,1,31,4,3,32,14,5,2};
        Sort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
