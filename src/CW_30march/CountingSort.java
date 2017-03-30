package CW_30march;

/**
 * Created by Timbaev on 30.03.2017.
 * Counting Sort
 */
public class CountingSort {

    public static int[] sort(int[] array, int startDiapason, int endDiapason) {
        int[] counts = new int[endDiapason - startDiapason];
        for (int number : array) {
            int index = number - startDiapason;
            counts[index] += 1;
        }

        int positionInsert = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] != 0) {
                for (int j = 0; j < counts[i]; j++) {
                    array[positionInsert] = i + startDiapason;
                    positionInsert++;
                }
            }
        }
        return array;
    }
}
