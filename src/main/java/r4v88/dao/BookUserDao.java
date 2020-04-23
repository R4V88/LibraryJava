package r4v88.dao;

import r4v88.model.entity.BookUser;

import java.util.List;

public interface BookUserDao {

    List<BookUser> getAllUsers();

    BookUser getBookById(long id);

    long getBookIdByName(String bookName);
}
