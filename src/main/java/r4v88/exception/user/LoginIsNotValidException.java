package r4v88.exception.user;

public class LoginIsNotValidException extends RuntimeException {
    public LoginIsNotValidException(String message) {
        super(message);
    }

    public LoginIsNotValidException() {
        super();
    }
}
