package r4v88.exception;

public class PasswordIsNotValid extends RuntimeException {
    public PasswordIsNotValid(String message) {
        super(message);
    }

    public PasswordIsNotValid() {
        super();
    }
}
