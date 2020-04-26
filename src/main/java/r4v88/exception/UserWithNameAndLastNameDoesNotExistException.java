package r4v88.exception;

public class UserWithNameAndLastNameDoesNotExistException extends RuntimeException {
    public UserWithNameAndLastNameDoesNotExistException(String message) {
        super(message);
    }

    public UserWithNameAndLastNameDoesNotExistException() {
        super();
    }
}
