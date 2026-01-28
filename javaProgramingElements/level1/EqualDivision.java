package javaProgramingElements.level1;

/*
  equal division:
  divides pens among students and prints each share + remaining.
*/
public class EqualDivision {
    public static void main(String[] args) {
        int pens = 14;
        int numberOfStudents = 3;

        int pensPerStudent = pens / numberOfStudents;
        int remainingPens = pens % numberOfStudents;

        System.out.println("the pen per student is " + pensPerStudent + " and the remaining pen not distributed is " + remainingPens);
    }
}
