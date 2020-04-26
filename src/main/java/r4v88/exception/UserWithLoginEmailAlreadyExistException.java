package r4v88.exception;

public class UserWithLoginEmailAlreadyExist extends RuntimeException {

    public UserWithLoginEmailAlreadyExist(String message) {
        super(message);
    }

    public UserWithLoginEmailAlreadyExist() {
        super();
    }
}
