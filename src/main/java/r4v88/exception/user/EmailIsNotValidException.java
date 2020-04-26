package r4v88.exception.user;

public class EmailIsNotValidException extends RuntimeException {
    public EmailIsNotValidException(String message) {
        super(message);
    }

    public EmailIsNotValidException() {
        super();
    }
}
