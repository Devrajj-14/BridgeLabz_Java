package LeniarBinarySearchAndString;

class Negative{
    public static int check(int[] arr){
        for(int i=0; i<arr.length; i++){
            if(arr[i]<0){
                return i;
            }
        }
        return -1;
    }
}

public class FirstNegativeLinearSearch {
    public static void main(String[] args){
        int[] arr = {1,2,4,5,3,1,-654,3};
        System.out.println(Negative.check(arr));
    }
}
