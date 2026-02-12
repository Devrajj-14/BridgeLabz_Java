package ListInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Rotate{
    public static List<Integer> rotate(List<Integer> list , int k){
        List<Integer> res = new ArrayList<>();
        int n = list.size();
        k= ((k%n)+n)%n;

        for(int i=k; i<n;i++) res.add(list.get(i));
        for(int i=0; i<k;i++) res.add(list.get(i));

        return res;
    }
}

public class RotateElement {
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>(Arrays.asList(10,20,30,40,5000000));

        System.out.println(Rotate.rotate(list,3));

    }
}
