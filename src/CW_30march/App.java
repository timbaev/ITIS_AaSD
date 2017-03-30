package CW_30march;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Timbaev on 30.03.2017.
 * Sort with CountingSort
 */
public class App {

    public static void main(String[] args) {
        int[] numbers = new int[10];
        for (int i = 0; i < numbers.length; i++) {
            Random random = new Random();
            numbers[i] = random.nextInt(20) - 10;
        }
        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.toString(CountingSort.sort(numbers, -10, 10)));
    }
}
