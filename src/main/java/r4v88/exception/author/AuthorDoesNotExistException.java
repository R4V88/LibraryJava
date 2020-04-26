package r4v88.exception.author;

public class AuthorDoesNotExistException extends RuntimeException {
    public AuthorDoesNotExistException(String message) {
        super(message);
    }

    public AuthorDoesNotExistException() {
        super();
    }
}
