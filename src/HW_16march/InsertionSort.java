package HW_16march;

import java.util.Arrays;

/**
 * Created by Timbaev on 16.03.2017.
 * Insert Sort
 */
public class InsertionSort {

    public static int[] sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int insertElement = array[i];
            int positionInsert = Arrays.binarySearch(array, 0, i, insertElement) * -1 - 1;
            int j = i;
            while (positionInsert != j) {
                int temp = array[j - 1];
                array[j - 1] = insertElement;
                array[j] = temp;
                j--;
            }
        }
        return array;
    }
}
