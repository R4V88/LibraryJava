package r4v88.exception;

public class UserWithIdDoesNotExist extends RuntimeException {
    public UserWithIdDoesNotExist(String message) {
        super(message);
    }

    public UserWithIdDoesNotExist() {
        super();
    }
}
