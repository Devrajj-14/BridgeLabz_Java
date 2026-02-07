package hashMapHashFunction;

import java.util.HashMap;
import java.util.Map;

class Target{
    public boolean check(int[] arr,int target){
        Map<Integer,Integer> map= new HashMap<>();
        int sum=0;
        int a=0;
        for(int i=0; i<arr.length ;i++){
            sum+= arr[i];
            if(sum<target){
                continue;
            }
            else if(sum== target){
                return true;
            }else{
                while(sum>target && a<= i) {
                    sum -= arr[a];
                    a++;
                }
                if(sum == target){
                    return true;
                }
            }
        }
        return false;
    }
}

public class TaargetSum {
    public static void main(String[] args){
        Target t1 = new Target();

        int[] arr={1,2,3,4,5,3,2,1};
        boolean res = t1.check(arr,9);
        System.out.println(" "+ res);
    }
}
