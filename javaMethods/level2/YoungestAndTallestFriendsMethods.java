package javaMethods.level2;

import java.util.Scanner;

/*
this program finds youngest and tallest among amar akbar anthony
uses arrays for age and height and methods to decide
*/
public class YoungestAndTallestFriendsMethods {

    public static int findYoungestIndex(int[] ages) {
        int idx = 0;

        // loop for youngest
        for (int i = 1; i < ages.length; i++) {
            if (ages[i] < ages[idx]) idx = i;
        }

        return idx;
    }

    public static int findTallestIndex(double[] heights) {
        int idx = 0;

        // loop for tallest
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[idx]) idx = i;
        }

        return idx;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] names = {"amar", "akbar", "anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];

        // loop for input
        for (int i = 0; i < 3; i++) {
            System.out.print("enter age for " + names[i] + " ");
            ages[i] = sc.nextInt();

            System.out.print("enter height for " + names[i] + " ");
            heights[i] = sc.nextDouble();

            // validation
            if (ages[i] < 0 || heights[i] <= 0) {
                System.out.println("invalid input");
                sc.close();
                return;
            }
        }

        int youngIdx = findYoungestIndex(ages);
        int tallIdx = findTallestIndex(heights);

        System.out.println("youngest " + names[youngIdx]);
        System.out.println("tallest " + names[tallIdx]);

        sc.close();
    }
}
