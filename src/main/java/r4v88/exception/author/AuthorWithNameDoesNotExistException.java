package r4v88.exception.author;

public class AuthorWithNameDoesNotExistException extends RuntimeException {
    public AuthorWithNameDoesNotExistException(String message) {
        super(message);
    }

    public AuthorWithNameDoesNotExistException() {
        super();
    }
}
