package r4v88.exception.user;

public class DateOfBirthIsNotValidException extends RuntimeException {
    public DateOfBirthIsNotValidException(String message) {
        super(message);
    }

    public DateOfBirthIsNotValidException() {
        super();
    }
}
