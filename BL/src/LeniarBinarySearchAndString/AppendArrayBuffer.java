package LeniarBinarySearchAndString;

class Add{
    public static String add(String[] arr){
        StringBuffer sb= new StringBuffer();
        for(String s: arr){
            if(s!= null){
                sb.append(s);
            }
        }
        return sb.toString();
    }
}

public class AppendArrayBuffer {
    public static void main(String[] args){
        String[] arr= {"Hello " , "! " , "all ", " Devraj"};
        Add.add(arr);
        System.out.println(Add.add(arr));
    }
}
