package javaProgramingElements.level1;

import java.util.Scanner;

/*
  square perimeter:
  takes side and prints perimeter = 4 * side.
*/
public class SquarePerimeter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("enter side: ");
        int side = input.nextInt();

        int perimeter = 4 * side;
        System.out.println("the length of the side is " + side + " whose perimeter is " + perimeter);

        input.close();
    }
}
