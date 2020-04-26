package r4v88.exception.author;

public class AuthorWithLastnameDoesNotExistException extends RuntimeException {
    public AuthorWithLastnameDoesNotExistException(String message) {
        super(message);
    }

    public AuthorWithLastnameDoesNotExistException() {
        super();
    }
}
