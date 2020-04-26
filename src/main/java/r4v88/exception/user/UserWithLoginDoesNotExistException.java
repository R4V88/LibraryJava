package r4v88.exception.user;

public class UserWithLoginDoesNotExistException extends RuntimeException {
    public UserWithLoginDoesNotExistException(String message) {
        super(message);
    }

    public UserWithLoginDoesNotExistException() {
        super();
    }
}
