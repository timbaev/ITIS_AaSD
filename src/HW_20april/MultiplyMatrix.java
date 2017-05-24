package HW_20april;

/**
 * Created by Timbaev on 20.04.2017.
 * Strassen algorithm
 */
public class MultiplyMatrix {

    public static int[][] strassenMultiplay(int[][] a, int[][] b) {
        int n = a.length;
        if (a.length != b.length) {
            throw new IllegalStateException("a.length != b.length");
        }
        if (n == 8) {
            return multiplayMatrix(a, b);
        }
        int[][] c;

        int[][] a11 = new int[n/2][n/2];
        int[][] a12 = new int[n/2][n/2];
        int[][] a21 = new int[n/2][n/2];
        int[][] a22 = new int[n/2][n/2];
        splitMatrix(a, a11, a12, a21, a22);

        int[][] b11 = new int[n/2][n/2];
        int[][] b12 = new int[n/2][n/2];
        int[][] b21 = new int[n/2][n/2];
        int[][] b22 = new int[n/2][n/2];
        splitMatrix(b, b11, b12, b21, b22);


        int[][] p1 = strassenMultiplay(sumMatrix(a11, a22, 1), sumMatrix(b11, b22, 1));
        int[][] p2 = strassenMultiplay(sumMatrix(a21, a22, 1), b11);
        int[][] p3 = strassenMultiplay(a11, sumMatrix(b12, b22, -1));
        int[][] p4 = strassenMultiplay(a22, sumMatrix(b21, b11, -1));
        int[][] p5 = strassenMultiplay(sumMatrix(a11, a12, 1), b22);
        int[][] p6 = strassenMultiplay(sumMatrix(a21, a11, -1), sumMatrix(b11, b12, 1));
        int[][] p7 = strassenMultiplay(sumMatrix(a12, a22, -1), sumMatrix(b21, b22, 1));

        int[][] c11 = sumMatrix(sumMatrix(p1, p4, 1), sumMatrix(p7, p5, -1), 1);
        int[][] c12 = sumMatrix(p3, p5, 1);
        int[][] c21 = sumMatrix(p2, p4, 1);
        int[][] c22 = sumMatrix(sumMatrix(p3, p6, 1), sumMatrix(p1, p2, -1), 1);

        c = concatenationMatrix(c11, c12, c21, c22);

        return c;
    }

    private static int[][] concatenationMatrix(int[][] a11, int[][] a12, int[][] a21, int[][] a22) {
        int n = a11.length;
        int[][] a = new int[n * 2][n * 2];
        for (int i = 0; i < n; i++) {
            System.arraycopy(a11[i], 0, a[i], 0, n);
            System.arraycopy(a12[i], 0, a[i], n, n);
            System.arraycopy(a21[i], 0, a[i + n], 0, n);
            System.arraycopy(a22[i], 0, a[i + n], n, n);
        }
        return a;
    }

    private static void splitMatrix(int[][] a, int[][] a11, int[][] a12, int[][] a21, int[][] a22) {
        int n = a.length / 2;
        for (int i = 0; i < n; i++) {
            System.arraycopy(a[i], 0, a11[i], 0, n);
            System.arraycopy(a[i], n, a12[i], 0, n);
            System.arraycopy(a[i + n], 0, a21[i], 0, n);
            System.arraycopy(a[i + n], n, a22[i], 0, n);
        }
    }

    private static int[][] sumMatrix(int[][] a, int[][] b, int k) {
        int[][] c = new int[a.length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                c[i][j] = a[i][j] + b[i][j] * k;
            }
        }
        return c;
    }

    private static int[][] multiplayMatrix(int[][] a, int[][] b) {
        int[][] c = new int[a.length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                c[i][j] = 0;
                for (int k = 0; k < a.length; k++) {
                    c[i][j] += a[i][k]*b[k][j];
                }
            }
        }
        return c;
    }
}




