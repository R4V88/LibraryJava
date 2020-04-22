package r4v88.service;

import r4v88.api.AuthorDao;
import r4v88.api.AuthorService;
import r4v88.dao.AuthorDaoImpl;
import r4v88.model.Author;

import java.util.Map;

public class AuthorServiceImpl implements AuthorService {

    private AuthorDao authorDao = AuthorDaoImpl.getInstance();

    private static AuthorService instance = new AuthorServiceImpl();

    private Map<Long, Author> idAuthorsMap = getAllAuthors();

    public static AuthorService getInstance() {
        return AuthorServiceImpl.instance;
    }

    private AuthorServiceImpl() {

    }

    @Override
    public Map<Long, Author> getAllAuthors() {
        return authorDao.getAllAuthors();
    }

    @Override
    public Author getAuthorById(long id) {
        Author author = null;
        for (Map.Entry<Long, Author> authorFromMap : idAuthorsMap.entrySet()) {
            if (authorFromMap.getKey() == id) {
                author = authorFromMap.getValue();
            } else {
                throw new RuntimeException("Author with id: " + id + " does not exist!");
            }
        }
        return author;
    }

    @Override
    public Author getAuthorByName(String name) {
        Author author = null;
        for (Map.Entry<Long, Author> authorFromMap : idAuthorsMap.entrySet()) {
            if (authorFromMap.getValue().getName().equals(name)) {
                author = authorFromMap.getValue();
            } else {
                throw new RuntimeException("Author with name: " + name + " does not exist!");
            }
        }
        return author;
    }

    @Override
    public Author getAuthorByLastname(String lastname) {
        Author author = null;
        for (Map.Entry<Long, Author> authorFromMap : idAuthorsMap.entrySet()) {
            if (authorFromMap.getValue().getLastname().equals(lastname)) {
                author = authorFromMap.getValue();
            } else {
                throw new RuntimeException("Author with lastname: " + lastname + " does not exist!");
            }
        }
        return author;
    }

    @Override
    public void addAuthor(Author author) {
        for (Map.Entry<Long, Author> authorFromMap : idAuthorsMap.entrySet()) {
            if(!authorFromMap.getValue().equals(author)) {
                authorDao.addAuthor(author);
            } else {
                throw new RuntimeException("Author: " + author.getName() + " already exist!");
            }
        }
    }

    @Override
    public void removeAuthorById(long id) {
        for (Map.Entry<Long, Author> authorFromMap : idAuthorsMap.entrySet()) {
            if (authorFromMap.getKey() == id) {
                authorDao.removeAuthorById(id);
            } else {
                throw new RuntimeException("Author with id: " + id + " does not exist!");
            }
        }
    }
}
