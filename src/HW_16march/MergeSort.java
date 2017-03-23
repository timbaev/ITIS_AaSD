package HW_16march;

import java.util.Arrays;

/**
 * Created by Timbaev on 23.03.2017.
 *
 */
public class MergeSort {

    public static int[] sort(int[] array) {
        int size = array.length;
        if (size < 2) return array;
        int middle = size / 2;
        return merge(sort(Arrays.copyOfRange(array, 0, middle)), sort(Arrays.copyOfRange(array, middle, size)));
    }

    private static int[] merge(int[] array1, int[] array2) {
        int size1 = array1.length;
        int size2 = array2.length;
        int a = 0;
        int b = 0;
        int sumSize = size1 + size2;
        int[] result = new int[sumSize];
        for (int i = 0; i < sumSize; i++) {
            if (b < size2 && a < size1) {
                if (array1[a] > array2[b]) result[i] = array2[b++];
                else result[i] = array1[a++];
            } else if (b < size2) {
                result[i] = array2[b++];
            } else {
                result[i] = array1[a++];
            }
        }
        return result;
    }
}
