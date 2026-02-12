package ListInterface;

import java.util.*;

class Duplicate{
    public static List<Integer> duplicate(List<Integer> list){
        List<Integer>res= new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for(int  x : list){
            if(set.add(x)){
                res.add(x);
            }
        }
        return res;
    }
}

public class RemoveDuplicate {
    public static void main(String[] args){
        List<Integer> list= new ArrayList<>(Arrays.asList(10,12,3,2,1,3,1,323,24,21,13,12,10));
        System.out.println(Duplicate.duplicate(list));
    }
}
