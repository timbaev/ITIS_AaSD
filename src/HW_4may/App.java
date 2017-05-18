package HW_4may;
/**
 * Created by Timbaev on 18.05.2017.
 *
 */
public class App {

    public static void main(String[] args) {
        BinaryNumberPlus number1 = new BinaryNumberPlus(true, false, true, false, true); //21
        BinaryNumberPlus number2 = new BinaryNumberPlus(true, true, true, false, true); //29

        BinaryNumberPlus number3 = new BinaryNumberPlus(true, true, false, true); //13
        BinaryNumberPlus number4 = new BinaryNumberPlus(true, false, true, false); //10

        System.out.println(number3.multiplyKaratsuba(number4));
        System.out.println(number1.multiplyKaratsuba(number2));
    }
}
