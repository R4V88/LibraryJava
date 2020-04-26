package r4v88.exception.author;

public class AuthorAlreadyExistException extends RuntimeException{
    public AuthorAlreadyExistException(String message) {
        super(message);
    }

    public AuthorAlreadyExistException() {
        super();
    }
}
