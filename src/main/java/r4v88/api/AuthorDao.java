package r4v88.api;

import r4v88.model.Author;

import java.util.Map;

public interface AuthorDao {

    Map<Long, Author> getAllAuthors();

    void addAuthor(Author author);

    void removeAuthorById(Long id);
}
