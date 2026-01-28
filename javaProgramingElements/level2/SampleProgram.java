package javaProgramingElements.level2;

import java.util.Scanner;

/*
  travel summary:
  takes city route + distances + time and prints total distance and time.
*/
public class SampleProgram {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("enter name: ");
        String name = input.nextLine();

        System.out.print("enter source city: ");
        String fromCity = input.nextLine();

        System.out.print("enter via city: ");
        String viaCity = input.nextLine();

        System.out.print("enter destination city: ");
        String toCity = input.nextLine();

        System.out.print("enter distance between source to via: ");
        double distanceFromToVia = input.nextDouble();

        System.out.print("enter time in min between source to via: ");
        double timeFromToVia = input.nextDouble();

        System.out.print("enter distance between via to destination: ");
        double distanceViaToFinalCity = input.nextDouble();

        System.out.print("enter time took in min between via to destination: ");
        double timeViaToFinalCity = input.nextDouble();

        double totalDistance = distanceFromToVia + distanceViaToFinalCity;
        double totalTime = timeFromToVia + timeViaToFinalCity;

        System.out.println("the total distance travelled by " + name + " from " + fromCity + " to " + toCity + " via " + viaCity
                + " is " + totalDistance + " km and the total time taken is " + totalTime + " minutes");

        input.close();
    }
}
