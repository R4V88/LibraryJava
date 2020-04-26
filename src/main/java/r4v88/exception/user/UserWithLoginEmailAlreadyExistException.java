package r4v88.exception.user;

public class UserWithLoginEmailAlreadyExistException extends RuntimeException {

    public UserWithLoginEmailAlreadyExistException(String message) {
        super(message);
    }

    public UserWithLoginEmailAlreadyExistException() {
        super();
    }
}
