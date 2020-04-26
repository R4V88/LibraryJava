package r4v88.exception;

public class UserWithEmailDoesNotExist extends RuntimeException {
    public UserWithEmailDoesNotExist(String message) {
        super(message);
    }

    public UserWithEmailDoesNotExist() {
        super();
    }
}
