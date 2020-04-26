package r4v88.exception.book;

public class BookAlreadyExistException extends RuntimeException {
    public BookAlreadyExistException(String message) {
        super(message);
    }

    public BookAlreadyExistException() {
        super();
    }
}
