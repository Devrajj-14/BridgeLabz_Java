package Regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidEmail {
    public static void check(String regex, String str){
        Pattern p = Pattern.compile(regex);
        Matcher m= p.matcher(str);
        boolean match= m.matches();
        System.out.println(match);
    }
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        String regex="^[a-zA-Z0-9_.$-]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}$";
        System.out.println("enter string");
        String str=sc.nextLine();

        ValidEmail.check(regex,str);
    }
}
