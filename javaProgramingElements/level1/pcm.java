package javaProgramingElements.level1;

/*
  pcm average:
  stores marks of physics, chemistry, maths and prints average.
*/
public class pcm {
    public static void main(String[] args) {
        String name = "Sam";
        int maths = 94;
        int physics = 95;
        int chemistry = 96;

        int average = (maths + physics + chemistry) / 3;
        System.out.println(name + " average mark in pcm is " + average);
    }
}
