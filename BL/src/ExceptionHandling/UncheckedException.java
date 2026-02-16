package ExceptionHandling;
import java.util.*;

public class UncheckedException {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int div=0;
        try{
            System.out.println("enter n1");
            int num1= sc.nextInt();
            System.out.println("enter num 2");
            int num2= sc.nextInt();

             div= num1/num2;
        }catch(ArithmeticException e){
            System.out.println("num can not be divisible by zero " +e.getMessage());
        }
        catch (InputMismatchException e){
            System.out.println("enter a valid number " + e.getMessage());
        }
        finally {
            sc.close();
            System.out.println("Program done result is "+ div);
        }
    }

}
