package LeniarBinarySearchAndString;

class Reverse{
    public static String reverse(String s){
        StringBuilder b1= new StringBuilder();
        b1.append(s);
        b1.reverse();
        return b1.toString();
    }
}

public class ReverseStringBuilder {
    public static void main (String[] args){

        String s ="Devraj";
        String out = Reverse.reverse(s);
        System.out.println(out);

    }
}
