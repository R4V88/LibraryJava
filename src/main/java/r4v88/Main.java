package r4v88;

import r4v88.api.UserDao;
import r4v88.api.UserService;
import r4v88.dao.UserDaoImpl;
import r4v88.exception.UserWithIdDoesNotExist;
import r4v88.model.Author;
import r4v88.model.Book;
import r4v88.model.User;
import r4v88.model.enums.Type;
import r4v88.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) throws UserWithIdDoesNotExist {
        User wacek = new User.Builder()
                .setName("tak")
                .setLastname("nie")
                .setLogin("wacek")
                .setPassword("placek321")
                .setDateOfBirth("11.22.3333")
                .setEmail("email@gmail.mail")
                .build();

        User marek = new User.Builder()
                .setName("marek")
                .setLastname("jest")
                .setLogin("mare")
                .setPassword("admin1")
                .setDateOfBirth("11.22.3334")
                .setEmail("email@dzimejl.mail")
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

//        UserDao userDao = UserDaoImpl.getInstance();
//        userDao.saveUser(user);
//
//        userDao.updateUser(user, 1);

        UserService userService = UserServiceImpl.getInstance();
//        System.out.println(userService.getUserById(1).toString());
//        System.out.println(userService.getUserByNameAndLastname("tak", "nie"));
//        userService.updateUserName("Karol", 1);
//        System.out.println(userService.getUserById(1).toString());
//        userService.createUser(marek);
//        System.out.println(userService.getUserByNameAndLastname("marek", "jest"));
        System.out.println(userService.getUserById(1));
        System.out.println(userService.getUserById(10));


    }
}
