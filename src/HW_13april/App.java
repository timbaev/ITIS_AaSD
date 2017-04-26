package HW_13april;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Timbaev on 13.04.2017.
 * Main app class
 */
public class App {

    public static void main(String[] args) {
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            Random random = new Random();
            array[i] = random.nextInt(9999);
        }
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(RadixSort.sort(array, 4)));
    }
}
