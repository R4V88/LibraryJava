package r4v88.exception;

public class PasswordIsNotValid extends Exception {
    public PasswordIsNotValid(String message) {
        super(message);
    }

    public PasswordIsNotValid() {
        super();
    }
}
