package HW_27april;

import java.util.Arrays;

/**
 * Created by Timbaev on 27.04.2017.
 * Multiplying binaryNumbers
 */
public class BinaryNumber {

    private boolean[] number;

    public BinaryNumber(boolean... numbers) {
        if (numbers.length == 0) number = new boolean[1];
        else number = numbers;
    }

    //manual method
    public BinaryNumber add(BinaryNumber anotherNumber) {
        boolean[] resultArray = null;
        boolean[] firstArray = null;
        int max = 0;
        if (number.length >= anotherNumber.length()) {
            resultArray = new boolean[number.length + 1];
            int addPosition = number.length - anotherNumber.length();
            System.arraycopy(anotherNumber.number, 0, resultArray, addPosition + 1, anotherNumber.length());
            firstArray = number;
            max = number.length;
        }
        if (number.length < anotherNumber.length()) {
            resultArray = new boolean[anotherNumber.length() + 1];
            int addPosition = anotherNumber.length() - number.length;
            System.arraycopy(number, 0, resultArray, addPosition + 1, number.length);
            firstArray = anotherNumber.number;
            max = anotherNumber.length();
        }

        assert firstArray != null;
        boolean plusOne = firstArray[max - 1] && resultArray[max];
        resultArray[max] = firstArray[max - 1] ^ resultArray[max];

        for (int i = max - 2; i >= 0; i--) {
            if (plusOne && firstArray[i]) {
                plusOne = true;
                firstArray[i] = false;
            } else {
                firstArray[i] = plusOne ^ firstArray[i];
                plusOne = firstArray[i] && resultArray[i + 1];
            }
            resultArray[i + 1] = firstArray[i] ^ resultArray[i + 1];
        }
        return new BinaryNumber(resultArray);
    }

    //java method
    public BinaryNumber addition(BinaryNumber anotherNumber) {
        int a = Integer.parseInt(this.toString(), 2);
        int b = Integer.parseInt(anotherNumber.toString(),2);
        int z = a + b;

        String result = Integer.toBinaryString(z);
        boolean[] number = new boolean[result.length()];
        for (int i = 0; i < result.length(); i++) {
            number[i] = result.charAt(i) == '1';
        }
        return new BinaryNumber(number);
    }

    public BinaryNumber subtraction(BinaryNumber anotherNumber) {
        int a = Integer.parseInt(this.toString(), 2);
        int b = Integer.parseInt(anotherNumber.toString(), 2);
        int z = a - b;

        String result = Integer.toBinaryString(z);
        boolean[] number = new boolean[result.length()];
        for (int i = 0; i < result.length(); i++) {
            number[i] = result.charAt(i) == '1';
        }
        return new BinaryNumber(number);
    }

    public BinaryNumber multiply(BinaryNumber anotherNumber) {
        //Проверка на ноль
        if (anotherNumber.isNull() || this.isNull()) return new BinaryNumber(false);
        if (anotherNumber.isOne()) return this;
        //Проверка на нечетность числа
        if (anotherNumber.number[anotherNumber.length() - 1]) {
            return this.addition((this.multiplyTwo()).multiply(anotherNumber.inHalf()));
        } else {
            return this.multiplyTwo().multiply(anotherNumber.inHalf());
        }
    }

    private boolean isNull() {
        for (boolean aNumber : number) {
            if (aNumber) return false;
        }
        return true;
    }

    private BinaryNumber multiplyTwo() {
        boolean[] result = new boolean[number.length + 1];
        System.arraycopy(number, 0, result, 0, number.length);
        return new BinaryNumber(result);
    }

    private boolean isOne() {
        if (number[number.length - 1]) {
            for (int i = 0; i < number.length - 1; i++) {
                if (number[i]) return false;
            }
            return true;
        }
        return false;
    }

    private BinaryNumber inHalf() {
        boolean[] half = new boolean[number.length];
        System.arraycopy(number, 0, half, 1, number.length - 1);
        return new BinaryNumber(half);
    }

    public int length() {
        return number.length;
    }

    public boolean[] getNumber() {
        return number;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (boolean num : number) {
            if (num) builder.append(1);
            else builder.append(0);
        }
        return builder.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (getClass() != object.getClass()) return false;
        BinaryNumber binaryNumber = (BinaryNumber) object;
        return Arrays.equals(number, binaryNumber.number);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(number);
        return result;
    }
}
