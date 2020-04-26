package r4v88.exception;

public class UserWithNameAndLastNameDoesNotExist extends RuntimeException {
    public UserWithNameAndLastNameDoesNotExist(String message) {
        super(message);
    }

    public UserWithNameAndLastNameDoesNotExist() {
        super();
    }
}
