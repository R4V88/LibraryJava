package r4v88.exception;

public class PasswordIsNotValidException extends RuntimeException {
    public PasswordIsNotValidException(String message) {
        super(message);
    }

    public PasswordIsNotValidException() {
        super();
    }
}
