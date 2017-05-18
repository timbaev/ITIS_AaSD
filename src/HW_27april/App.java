package HW_27april;

/**
 * Created by Timbaev on 27.04.2017.
 * Main app class
 */
public class App {

    public static void main(String[] args) {
        BinaryNumber first = new BinaryNumber(true, true); //21
        BinaryNumber second = new BinaryNumber(true, false, true); //7

        System.out.println(first.add(second));
    }
}
