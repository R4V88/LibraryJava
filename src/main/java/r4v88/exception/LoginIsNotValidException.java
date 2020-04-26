package r4v88.exception;

public class LoginIsNotValid extends RuntimeException {
    public LoginIsNotValid(String message) {
        super(message);
    }

    public LoginIsNotValid() {
        super();
    }
}
