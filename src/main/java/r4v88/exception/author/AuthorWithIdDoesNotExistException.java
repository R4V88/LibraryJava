package r4v88.exception.author;

public class AuthorWithIdDoesNotExistException extends RuntimeException {
    public AuthorWithIdDoesNotExistException(String message) {
        super(message);
    }

    public AuthorWithIdDoesNotExistException() {
        super();
    }
}
