package LeniarBinarySearchAndString;

class Peak{
    public static int peak(int[] arr){
        int left= 0;
        int right = arr.length-1;

        while(left<right){
            int mid= left+(right-left)/2;

            if(arr[mid]>arr[mid+1] && arr[mid]> arr[mid-1]){
                return mid;

            }else if(arr[mid]<arr[mid-1]){
                right= mid-1;
            }else if(arr[mid]<arr[mid+1]){
                left=mid+1;
            }
        }
        return -1;
    }
}

public class PeakBinary {
    public static void main (String[] args ){
        int[] arr= {1,2,4,22,7,4,3};
        System.out.println(Peak.peak(arr));
    }
}

