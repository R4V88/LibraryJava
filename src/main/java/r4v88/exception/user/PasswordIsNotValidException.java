package r4v88.exception.user;

public class PasswordIsNotValidException extends RuntimeException {
    public PasswordIsNotValidException(String message) {
        super(message);
    }

    public PasswordIsNotValidException() {
        super();
    }
}
