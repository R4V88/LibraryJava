package r4v88.service;

import r4v88.api.BookDao;
import r4v88.api.BookService;
import r4v88.dao.BookDaoImpl;
import r4v88.model.Book;

import java.util.Map;

public class BookServiceImpl implements BookService {

    BookDao bookDao = BookDaoImpl.getInstance();
    private Map<Long, Book> idBookMap = getAllBooks();

    private static BookService inastance = new BookServiceImpl();

    public static BookService getInastance() {
        return BookServiceImpl.inastance;
    }

    private BookServiceImpl() {
    }

    @Override
    public Map<Long, Book> getAllBooks() {
        return bookDao.getAllBooks();
    }

    @Override
    public Book getBookById(long id) {
        Book book = null;
        for(Map.Entry<Long, Book> bookFromDB : idBookMap.entrySet()) {
            if(bookFromDB.getKey() == id){
                book = bookFromDB.getValue();
            }
        }
        return book;
    }

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void removeBook(long id) {
        bookDao.removeBook(id);
    }

    @Override
    public void borrowBook(long id, boolean borrow) {
        bookDao.borrowBook(id, borrow);
    }
}
