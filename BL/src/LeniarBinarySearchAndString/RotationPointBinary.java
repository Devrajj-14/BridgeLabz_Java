package LeniarBinarySearchAndString;

class Rotate{
    public static int  rotate(int[] arr ){
        int left=0;
        int right= arr.length-1;
        if(arr[left]<=arr[right])return 0;

        while(left<right){
            int mid = left + (right-left)/2;
            if(arr[mid]>arr[right]){
                left=mid+1;
            }
            else if(arr[mid]<arr[right]){
                right=mid;
            }
            else{
                right--;
            }
        }
        return left;
    }

}

public class RotationPointBinary {
    public static void main(String[] args){
        int[] arr= {4,5,6,7,1,2,3};
        System.out.println(Rotate.rotate(arr));
    }
}
