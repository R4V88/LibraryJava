package r4v88.exception;

public class UserWithEmailDoesNotExistException extends RuntimeException {
    public UserWithEmailDoesNotExistException(String message) {
        super(message);
    }

    public UserWithEmailDoesNotExistException() {
        super();
    }
}
