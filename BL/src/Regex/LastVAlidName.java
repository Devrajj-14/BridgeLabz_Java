package Regex;
import java.util.Scanner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LastVAlidName {
    public static void check(String re, String str){
        Pattern p= Pattern.compile(re);
        Matcher m = p.matcher(str);
        boolean match= m.matches();
        System.out.println(match);
    }
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        String regex="^[A-z][a-z]{2,} [A-z][a-z]{2,}";

        System.out.println("Enter string");
        String str = sc.nextLine();

        LastVAlidName.check(regex,str);
    }


}
