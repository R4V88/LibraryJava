package r4v88.api;

import r4v88.model.Book;

import java.util.Map;

public interface BookDao {

    void addBook(Book book);

    Map<Long, Book> getAllBooks();

    void removeBook(long id);

    void borrowBook(long id, boolean borrow);
}
