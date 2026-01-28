package javaProgramingElements.level1;

/*
  volume of earth:
  calculates volume using 4/3*pi*r^3.
*/
public class VolumeOfEarth {
    public static void main(String[] args) {
        double radius = 6378; // km
        double volume = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);

        double volumeInCubicMiles = volume * 0.23; // keeping your multiplier idea
        System.out.println("the volume of earth in cubic kilometers is " + volume + " and cubic miles is " + volumeInCubicMiles);
    }
}
