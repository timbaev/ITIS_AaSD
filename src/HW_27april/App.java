package HW_27april;

/**
 * Created by Timbaev on 27.04.2017.
 * Main app class
 */
public class App {

    public static void main(String[] args) {
        BinaryNumber first = new BinaryNumber(true, false, true, false, true); //21
        BinaryNumber second = new BinaryNumber(true, true, true); //7

        System.out.println(first.multiply(second));
    }
}
