package r4v88.exception.book;

public class BookWithIdDoesNotExistException extends RuntimeException {
    public BookWithIdDoesNotExistException(String message) {
        super(message);
    }

    public BookWithIdDoesNotExistException() {
        super();
    }
}
