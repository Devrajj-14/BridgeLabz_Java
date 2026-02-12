package ListInterface;

import java.util.HashMap;
import java.util.Map;

class FreqCount{
    public static Map<String, Integer>freq(String[] arr) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : arr) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        return map;
    }
}

public class Frequency {
    public static void main(String[] args){
        String[] arr={"apple","banana", "apple","orange"};
        System.out.println(FreqCount.freq(arr));
    }
}
