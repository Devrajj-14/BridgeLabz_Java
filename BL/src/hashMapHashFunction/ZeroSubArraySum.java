package hashMapHashFunction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Hash {

    public List<int[]> findAllZeroSumSubarrays(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<int[]> res = new ArrayList<>();
        int sum = 0;

        map.put(0,new ArrayList<>());
        map.get(0).add(-1);

        for(int i=0; i< arr.length;i++){
            sum+= arr[i];
            if(map.containsKey(sum)) {
                for (int startIdx : map.get(sum)) {
                    res.add(new int[]{startIdx + 1, i});
                }
            }
            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }
        return res;

    }
}
public class ZeroSubArraySum {
    public static void main(String[] args) {
        // sample input
        Hash h1 = new Hash();

        int[] arr = {3, 4, -7, 1, 3, 3, 1, -4};

        List<int[]> res =h1.findAllZeroSumSubarrays(arr);


        // if none found, print message
        if (res.isEmpty()) {
            System.out.println("no zero-sum subarrays found");
        } else {
            // otherwise print all index pairs
            System.out.println("zero-sum subarrays (startIndex, endIndex):");
            for (int[] p :res) {
                System.out.println(p[0] + " " + p[1]);
            }
        }
    }
}
