package HW_16Febrary.exception;

/**
 * Created by Timbaev on 16.02.2017.
 *
 */
public class KeyAlreadyExistsException extends KeyException {

    public KeyAlreadyExistsException() {
    }

    public KeyAlreadyExistsException(String msg) {
        super(msg);
    }
}
