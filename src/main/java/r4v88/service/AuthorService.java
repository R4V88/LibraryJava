package r4v88.service;

import r4v88.model.Author;

import java.util.Map;

public interface AuthorService {

    Map<Long, Author> getAllAuthors();

    Author getAuthorById(long id);

    Author getAuthorByName(String name);

    Author getAuthorByLastname(String lastname);

    void addAuthor(Author author);

    void removeAuthorById(Long id);

}
