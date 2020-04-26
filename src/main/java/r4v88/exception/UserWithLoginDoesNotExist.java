package r4v88.exception;

public class UserWithLoginDoesNotExist extends RuntimeException {
    public UserWithLoginDoesNotExist(String message) {
        super(message);
    }

    public UserWithLoginDoesNotExist() {
        super();
    }
}
