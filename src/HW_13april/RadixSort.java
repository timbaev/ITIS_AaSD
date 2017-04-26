package HW_13april;

/**
 * Created by Timbaev on 13.04.2017.
 * Radix Sort
 */
public class RadixSort {

    public static int[] sort(int[] array, int maxDigit) {
        int[] tempSortedArray = new int[array.length];
        int digit = 1;
        for (int i = 1; i <= maxDigit; i++) {
            int divDigit = digit;
            digit *= 10;
            int position = 0;
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k < array.length; k++) {
                    if (array[k] % digit / divDigit == j) {
                        tempSortedArray[position] = array[k];
                        position++;
                    }
                }
            }
            System.arraycopy(tempSortedArray, 0, array, 0, array.length);
        }
        return array;
    }
}
