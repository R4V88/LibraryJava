package r4v88.exception;

public class UserWithNameAndLastNameDoesNotExist extends Exception {
    public UserWithNameAndLastNameDoesNotExist(String message) {
        super(message);
    }

    public UserWithNameAndLastNameDoesNotExist() {
        super();
    }
}
