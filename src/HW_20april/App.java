package HW_20april;

import java.util.Arrays;

/**
 * Created by Timbaev on 24.05.2017.
 */
public class App {

    public static void main(String[] args) {
        int[][] matrix1 = {
                {1, 2, 3, 4},
                {1, 2, 3, 4},
                {1, 2, 3, 4},
                {1, 2, 3, 4}
        };
        int[][] matrix2 = {
                {1, 2, 3, 4},
                {1, 2, 3, 4},
                {1, 2, 3, 4},
                {1, 2, 3, 4}
        };
        System.out.println(Arrays.toString(MultiplyMatrix.strassenMultiplay(matrix1, matrix2)));
    }
}
