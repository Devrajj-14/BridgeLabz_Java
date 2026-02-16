package ExceptionHandling;

import javax.swing.tree.ExpandVetoException;
import java.util.Scanner;

class CustomInvalidException extends Exception {
    public CustomInvalidException(String mess){
        super(mess);
    }

}

public class CustomException {
    static void validAge(int age) throws CustomInvalidException{
        if(age<18){
            throw new CustomInvalidException("you are under age");
        }
        System.out.println("access granted");
    }

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        try{
            System.out.println("enter age");
            int age= sc.nextInt();
            validAge(age);
        }catch (CustomInvalidException e){
            System.out.println("not valid " + e.getMessage());
        }
    }
}
