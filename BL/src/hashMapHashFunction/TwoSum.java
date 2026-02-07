package hashMapHashFunction;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class target{
    public int[] Check(int[] arr,int target){
        Map<Integer,Integer> map= new HashMap<>();

        for(int i=0; i<arr.length ; i++){
            int sum=target-arr[i];
            if(map.containsKey(sum)){
                return new int[]{map.get(sum),i};
            }
            map.put(arr[i],i);
        }
        return new int[]{};
    }
}

public class TwoSum {
    public static void main(String[] args){
        target t1 = new target();
        int[] arr={1,2,3,4,5,6,7,8,6,};
        int[] res =t1.Check(arr, 12);
        System.out.println(Arrays.toString(res) );
    }

}
