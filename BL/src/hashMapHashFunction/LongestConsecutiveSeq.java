package hashMapHashFunction;

class Longest{
    public int size(int[] arr){
        int count=1;
        int maxx=0;
        for(int i=1 ; i< arr.length; i++){
            if(arr[i]==(arr[i-1]+1)){
                count++;
                maxx = Math.max(count, maxx);
            }else{
                count=1;
            }
        }
        return maxx;
    }
}

public class LongestConsecutiveSeq {
    public static void main(String[] args) {
        Longest l1 = new Longest();

        int[] arr = {1, 2, 3, 6, 5, 6, 7, 8, 9};
        int res =l1.size(arr);
        System.out.println(res);
    }
}
