package HW_4may;

import HW_27april.BinaryNumber;

/**
 * Created by Timbaev on 18.05.2017.
 *
 */
public class BinaryNumberPlus extends BinaryNumber {

    public BinaryNumberPlus(boolean... numbers) {
        super(numbers);
    }

    public BinaryNumber multiplyKaratsuba(BinaryNumber binaryNumber) {
        BinaryNumber[] numberA = divideArray(this.getNumber());
        BinaryNumber[] numberB = divideArray(binaryNumber.getNumber());
        int m = binaryNumber.length() / 2;
        int baseM = (int) Math.pow(2, m);
        int base2M = (int) Math.pow(2, 2 * m);

        BinaryNumber result;
        BinaryNumber A0B0 = numberA[0].multiply(numberB[0]);
        BinaryNumber A1B1 = numberA[1].multiply(numberB[1]);
        BinaryNumber A0plusA1 = numberA[0].addition(numberA[1]);
        BinaryNumber B0plusB1 = numberB[0].addition(numberB[1]);
        BinaryNumber A0plusA1B0plusB1 = A0plusA1.multiply(B0plusB1); //C
        BinaryNumber CsubA0B0subA1B1 = A0plusA1B0plusB1.subtraction(A0B0).subtraction(A1B1); //D
        BinaryNumber DBase = CsubA0B0subA1B1.multiply(toBinaryNumber(baseM));
        BinaryNumber A0B0plusDBase = A0B0.addition(DBase);
        BinaryNumber A1B1Base = A1B1.multiply(toBinaryNumber(base2M));
        result = A0B0plusDBase.addition(A1B1Base);

        return result;
    }

    private BinaryNumber[] divideArray(boolean[] array) {
        int m = array.length / 2;
        boolean[] divide1;
        boolean[] divide2 = new boolean[m];
        if (array.length % 2 == 0) {
            divide1 = new boolean[m];
            System.arraycopy(array, m, divide2, 0, m);
        }
        else {
            divide1 = new boolean[m + 1];
            System.arraycopy(array, m + 1, divide2, 0, m);
        }
        System.arraycopy(array, 0, divide1, 0, divide1.length);
        return new BinaryNumber[] {new BinaryNumber(divide2), new BinaryNumber(divide1)};
    }

    private BinaryNumber toBinaryNumber(int number) {
        StringBuilder builder = new StringBuilder();
        while (number != 0) {
            int mod = number % 2;
            builder.append(mod);
            number /= 2;
        }
        builder = builder.reverse();
        String result = builder.toString();
        boolean[] binaryNumber = new boolean[result.length()];
        for (int i = 0; i < result.length(); i++) {
            binaryNumber[i] = result.charAt(i) == '1';
        }
        return new BinaryNumber(binaryNumber);
    }

}
