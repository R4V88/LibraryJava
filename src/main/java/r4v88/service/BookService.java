package r4v88.service;

import r4v88.model.Book;

import java.util.Map;

public interface BookService {

    Map<Long, Book> getAllBooks();

    Book getBookById(long id);

    void addBook(Book book);

    void removeBook(long id);

    void borrowBook(long id, boolean borrow);
}
