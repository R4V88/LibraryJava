package r4v88.exception;

public class UserWithIdDoesNotExist extends Exception {
    public UserWithIdDoesNotExist(String message) {
        super(message);
    }

    public UserWithIdDoesNotExist() {
        super();
    }
}
