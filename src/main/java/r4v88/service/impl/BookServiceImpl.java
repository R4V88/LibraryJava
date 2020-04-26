package r4v88.service.impl;

import r4v88.dao.BookDao;
import r4v88.dao.impl.BookDaoImpl;
import r4v88.model.Book;
import r4v88.service.BookService;

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
            for (Map.Entry<Long, Book> bookFromDB : idBookMap.entrySet()) {
                if (bookFromDB.getKey() == id) {
                    book = bookFromDB.getValue();
                } else {
                    throw new RuntimeException("Book with id: " + id + " does not exist");
                }
            }
            return book;
    }

    @Override
    public void addBook(Book book) {
        for (Map.Entry<Long, Book> bookFromDB : idBookMap.entrySet()) {
            if(!bookFromDB.getValue().equals(book)) {
                bookDao.addBook(book);
            } else {
                throw new RuntimeException("Book: " + book.getTitle() + " already exists!");
            }
        }
    }

    @Override
    public void removeBook(long id) {
        for(Map.Entry<Long, Book> bookFromDB : idBookMap.entrySet()){
            if(bookFromDB.getKey() == id) {
                bookDao.removeBook(id);
            } else {
                throw new RuntimeException("Book with id: " + id + " does not exist!");
            }
        }
    }

    @Override
    public void borrowBook(long id, boolean borrow) {
        for(Map.Entry<Long, Book> bookFromDB : idBookMap.entrySet()){
            if(!bookFromDB.getValue().isBorrowed()) {
                bookDao.borrowBook(id, borrow);
            } else {
                throw new RuntimeException("Book " + bookFromDB.getValue().getTitle() + " is already borrowed :'(");
            }
        }
    }
}
