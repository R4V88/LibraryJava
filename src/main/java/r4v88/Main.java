package r4v88;

import r4v88.api.UserDao;
import r4v88.dao.UserDaoImpl;
import r4v88.model.Author;
import r4v88.model.Book;
import r4v88.model.User;
import r4v88.model.enums.Type;

public class Main {
    public static void main(String[] args) {
        User user = new User.Builder()
                .setName("tak")
                .setLastname("nie")
                .setLogin("wacek")
                .setPassword("placek321")
                .setDateOfBirth("11.22.3333")
                .setEmail("email@gmail.mail")
                .build();

        Book book = new Book.Builder()
                .setTitle("title")
                .setIsbn("123124123")
                .setPublisher("YES")
                .setYear("12398")
                .setType(Type.COMEDY)
                .build();

//        System.out.println(book.getId());

        Author author = new Author.Builder()
                .setName("Name")
                .setLastname("LastName")
                .setDateOfBirth("19.19.19")
                .build();

        UserDao userDao = UserDaoImpl.getInstance();
        userDao.saveUser(user);

        userDao.updateUser(user, 1);

    }
}
