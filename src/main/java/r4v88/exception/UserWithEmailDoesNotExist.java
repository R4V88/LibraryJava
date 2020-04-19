package r4v88.exception;

public class UserWithEmailDoesNotExist extends Exception {
    public UserWithEmailDoesNotExist(String message) {
        super(message);
    }

    public UserWithEmailDoesNotExist() {
        super();
    }
}
