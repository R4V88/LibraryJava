package r4v88.exception;

public class UserWithIdDoesNotExistException extends RuntimeException {
    public UserWithIdDoesNotExistException(String message) {
        super(message);
    }

    public UserWithIdDoesNotExistException() {
        super();
    }
}
