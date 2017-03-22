package HW_16march;

/**
 * Created by Timbaev on 16.03.2017.
 *
 */
public class SelectionSort {

    public static int[] sort(int[] array) {
        int minPoition = -1;
        boolean isNeedChanged;
        for (int j = 0; j < array.length; j++) {
            int min = array[j];
            isNeedChanged = false;
            //find minElement and position
            for (int i = j; i < array.length; i++) {
                if (array[i] < min) {
                    min = array[i];
                    minPoition = i;
                    isNeedChanged = true;
                }
            }
            //change numbers
            if (isNeedChanged) {
                int temp = array[j];
                array[j] = min;
                array[minPoition] = temp;
            }
        }
        return array;
    }
}
