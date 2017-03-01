package HW_16Febrary.exception;

/**
 * Created by Timbaev on 16.02.2017.
 *
 */

public class KeyException extends RuntimeException {
    public KeyException() {}
    public KeyException(String msg) {
        super(msg);
    }
}
