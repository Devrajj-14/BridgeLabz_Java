package LeniarBinarySearchAndString;

import java.util.HashSet;
import java.util.Set;

class Remove{
    public static String remove(String s){
        HashSet<Character> seen =new HashSet<>();
        StringBuilder sb= new StringBuilder();

        for(int i =0 ; i<s.length(); i++){
            char ch = s.charAt(i);
            if(!seen.contains(ch)){
                sb.append(ch);
                seen.add(ch);
            }
        }
        return sb.toString();

    }
}

public class RemoveDuplicateBuilder {
    public static void main (String[] args) {
        String s = "DDEEVVRraajj";

        String out = Remove.remove(s);

        System.out.println(out);
    }
}
