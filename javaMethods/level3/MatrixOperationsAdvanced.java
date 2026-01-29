package javaMethods.level3;

public class MatrixOperationsAdvanced {

    public static double[][] createRandomMatrix(int rows, int cols) {
        double[][] m = new double[rows][cols];

        // loop to fill random small values
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                m[i][j] = 1 + (int) (Math.random() * 9);
            }
        }

        return m;
    }

    public static void displayMatrix(double[][] m) {
        // loop to print matrix
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.printf("%8.2f", m[i][j]);
            }
            System.out.println();
        }
    }

    public static double[][] add(double[][] a, double[][] b) {
        if (a.length != b.length || a[0].length != b[0].length) return new double[0][0];
        double[][] r = new double[a.length][a[0].length];

        // loops for add
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                r[i][j] = a[i][j] + b[i][j];
            }
        }

        return r;
    }

    public static double[][] subtract(double[][] a, double[][] b) {
        if (a.length != b.length || a[0].length != b[0].length) return new double[0][0];
        double[][] r = new double[a.length][a[0].length];

        // loops for subtract
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                r[i][j] = a[i][j] - b[i][j];
            }
        }

        return r;
    }

    public static double[][] multiply(double[][] a, double[][] b) {
        if (a[0].length != b.length) return new double[0][0];
        double[][] r = new double[a.length][b[0].length];

        // 3 loops for multiplication
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                double sum = 0;
                for (int k = 0; k < a[0].length; k++) {
                    sum = sum + a[i][k] * b[k][j];
                }
                r[i][j] = sum;
            }
        }

        return r;
    }

    public static double[][] transpose(double[][] a) {
        double[][] t = new double[a[0].length][a.length];

        // loops for transpose
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                t[j][i] = a[i][j];
            }
        }

        return t;
    }

    public static double det2x2(double[][] m) {
        return m[0][0] * m[1][1] - m[0][1] * m[1][0];
    }

    public static double det3x3(double[][] m) {
        double a = m[0][0], b = m[0][1], c = m[0][2];
        double d = m[1][0], e = m[1][1], f = m[1][2];
        double g = m[2][0], h = m[2][1], i = m[2][2];

        return a * (e * i - f * h) - b * (d * i - f * g) + c * (d * h - e * g);
    }

    public static double[][] inverse2x2(double[][] m) {
        double det = det2x2(m);
        if (det == 0) return new double[0][0];

        double[][] inv = new double[2][2];

        // swapping and negating
        inv[0][0] = m[1][1] / det;
        inv[0][1] = -m[0][1] / det;
        inv[1][0] = -m[1][0] / det;
        inv[1][1] = m[0][0] / det;

        return inv;
    }

    public static double[][] inverse3x3(double[][] m) {
        double det = det3x3(m);
        if (det == 0) return new double[0][0];

        double[][] inv = new double[3][3];

        // cofactor matrix then transpose then divide by det
        inv[0][0] =  (m[1][1]*m[2][2] - m[1][2]*m[2][1]) / det;
        inv[0][1] = -(m[0][1]*m[2][2] - m[0][2]*m[2][1]) / det;
        inv[0][2] =  (m[0][1]*m[1][2] - m[0][2]*m[1][1]) / det;

        inv[1][0] = -(m[1][0]*m[2][2] - m[1][2]*m[2][0]) / det;
        inv[1][1] =  (m[0][0]*m[2][2] - m[0][2]*m[2][0]) / det;
        inv[1][2] = -(m[0][0]*m[1][2] - m[0][2]*m[1][0]) / det;

        inv[2][0] =  (m[1][0]*m[2][1] - m[1][1]*m[2][0]) / det;
        inv[2][1] = -(m[0][0]*m[2][1] - m[0][1]*m[2][0]) / det;
        inv[2][2] =  (m[0][0]*m[1][1] - m[0][1]*m[1][0]) / det;

        return inv;
    }

    public static void main(String[] args) {
        double[][] a = createRandomMatrix(3, 3);
        double[][] b = createRandomMatrix(3, 3);

        System.out.println("matrix a");
        displayMatrix(a);

        System.out.println("matrix b");
        displayMatrix(b);

        System.out.println("a plus b");
        displayMatrix(add(a, b));

        System.out.println("a minus b");
        displayMatrix(subtract(a, b));

        System.out.println("a times b");
        displayMatrix(multiply(a, b));

        System.out.println("transpose of a");
        displayMatrix(transpose(a));

        System.out.println("determinant of a");
        System.out.println(det3x3(a));

        System.out.println("inverse of a");
        double[][] inv = inverse3x3(a);
        if (inv.length == 0) {
            System.out.println("inverse not possible");
        } else {
            displayMatrix(inv);
        }
    }
}
