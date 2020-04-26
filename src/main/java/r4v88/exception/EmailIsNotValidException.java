package r4v88.exception;

public class EmailIsNotValid extends RuntimeException {
    public EmailIsNotValid(String message) {
        super(message);
    }

    public EmailIsNotValid() {
        super();
    }
}
