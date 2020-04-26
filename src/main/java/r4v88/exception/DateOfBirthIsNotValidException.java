package r4v88.exception;

public class DateOfBirthIsNotValid extends RuntimeException {
    public DateOfBirthIsNotValid(String message) {
        super(message);
    }

    public DateOfBirthIsNotValid() {
        super();
    }
}
