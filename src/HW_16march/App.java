package HW_16march;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Timbaev on 16.03.2017.
 * Test Selection Sort
 */
public class App {

    public static void main(String[] args) {
        int[] numbers = new int[10];
        for (int i = 0; i < numbers.length; i++) {
            Random random = new Random();
            numbers[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(numbers));
        //System.out.println(Arrays.toString(SelectionSort.sort(numbers)));
        System.out.println(Arrays.toString(InsertionSort.sort(numbers)));
    }
}
