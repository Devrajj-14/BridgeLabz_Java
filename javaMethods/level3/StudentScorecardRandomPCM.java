package javaMethods.level3;

import java.util.Scanner;

public class StudentScorecardRandomPCM {

    public static int[][] generatePcmScores(int students) {
        int[][] scores = new int[students][3];

        // loop for random 2 digit scores
        for (int i = 0; i < students; i++) {
            scores[i][0] = (int) (Math.random() * 100);
            scores[i][1] = (int) (Math.random() * 100);
            scores[i][2] = (int) (Math.random() * 100);
        }

        return scores;
    }

    // returns total avg percent for each student
    public static double[][] calculateTotalAvgPercent(int[][] scores) {
        double[][] res = new double[scores.length][3];

        // loop for calculations
        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double avg = total / 3.0;
            double percent = (total / 300.0) * 100.0;

            // rounding to 2 digits
            avg = Math.round(avg * 100.0) / 100.0;
            percent = Math.round(percent * 100.0) / 100.0;

            res[i][0] = total;
            res[i][1] = avg;
            res[i][2] = percent;
        }

        return res;
    }

    public static void displayScorecard(int[][] scores, double[][] calc) {
        System.out.println("id\tphy\tchem\tmath\ttotal\tavg\tpercent");

        // loop to print table
        for (int i = 0; i < scores.length; i++) {
            System.out.println(
                    (i + 1) + "\t" +
                    scores[i][0] + "\t" +
                    scores[i][1] + "\t" +
                    scores[i][2] + "\t" +
                    (int) calc[i][0] + "\t" +
                    calc[i][1] + "\t" +
                    calc[i][2]
            );
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("enter number of students ");
        int n = sc.nextInt();

        // validation
        if (n <= 0) {
            System.out.println("invalid input");
            sc.close();
            return;
        }

        int[][] scores = generatePcmScores(n);
        double[][] calc = calculateTotalAvgPercent(scores);
        displayScorecard(scores, calc);

        sc.close();
    }
}
