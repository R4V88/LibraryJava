package r4v88;

import r4v88.api.AuthorDao;
import r4v88.api.AuthorService;
import r4v88.api.BookDao;
import r4v88.api.UserService;
import r4v88.dao.AuthorDaoImpl;
import r4v88.dao.BookDaoImpl;
import r4v88.exception.*;
import r4v88.model.Author;
import r4v88.model.Book;
import r4v88.model.User;
import r4v88.model.enums.Gender;
import r4v88.model.enums.Role;
import r4v88.model.enums.Type;
import r4v88.service.AuthorServiceImpl;
import r4v88.service.UserServiceImpl;

import java.util.Map;

public class Main {
    public static void main(String[] args) throws UserWithIdDoesNotExist, UserWithNameAndLastNameDoesNotExist, UserWithEmailDoesNotExist, UserWithLoginEmailAlreadyExist, DateOfBirthIsNotValid, LoginIsNotValid, PasswordIsNotValid, EmailIsNotValid, UserWithLoginDoesNotExist {
        User wacek = new User.Builder()
                .setName("tak")
                .setLastname("nie")
                .setLogin("wacek2")
                .setPassword("1Ab*45678")
                .setDateOfBirth("11.08.2018")
                .setEmail("email@gmail.mail")
                .setGender(Gender.MALE)
                .setRole(Role.USER)
                .build();

        User marek = new User.Builder()
                .setName("marek")
                .setLastname("jest")
                .setLogin("marekk")
                .setPassword("1Ab*45678")
                .setDateOfBirth("11.10.1994")
                .setEmail("email@dzimejl.mail")
                .setGender(Gender.FEMALE)
                .setRole(Role.ADMIN)
                .build();

        Book book = new Book.Builder()
                .setTitle("title")
                .setIsbn(123124123)
                .setPublisher("YES")
                .setYear("12398")
                .setType(Type.COMEDY)
                .build();

//        System.out.println(book.getId());

        Author author = new Author.Builder()
                .setName("Name")
                .setLastname("LastName")
                .setDateOfBirth("19.12.2019")
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
//        System.out.println(userService.getUserById(1));
//        System.out.println(userService.getUserByNameAndLastname("Tom", "Tailor"));

        User karolek = new User.Builder()
                .setName("Karolak")
                .setLastname("Worek")
                .setLogin("loginbb")
                .setEmail("taki@mejl")
                .setPassword("1Ab*45678")
                .setDateOfBirth("11.12.2018")
                .setGender(Gender.MALE)
                .setRole(Role.USER)
                .build();
//        userService.createUser(karolek);
////        userService.createUser(marek);
////        userService.createUser(wacek);

//        userService.updateUserName("Czarek", 1);
//        userService.updateUserLogin("loginbbc", 1);
//        userService.updateUserEmail("1232@3123", 1);
//        userService.updateUserLastname("Nazwisko", 1);
//        userService.updateUserPassword("asli!jdD1", 1);
//        userService.createUser(new User.Builder()
//                .setLogin("Korek123")
//                .setLastname("Dębowy")
//                .setEmail("napisz@tutaj")
//                .setPassword("asli*jdD2")
//                .setDateOfBirth("11.11.2011")
//                .setName("Korek")
//                .setGender(Gender.MALE)
//                .build());
        printAllUsers();
//        userService.removeUserByLogin("Korek123");
//        printAllUsers();

//        userService.updateUserName("kutalak", 6);
//        printAllUsers();

//        System.out.println(RegexpValidator.MIN_LENGTH_LOGIN.getRegexp());


//        System.out.println(userService.getAllUsers().toString());
//        System.out.println(userService.getUserByEmail("imejl.123"));

        BookDao bookDao = BookDaoImpl.getInstance();
        bookDao.addBook(book);
//            bookDao.borrowBook(1, false);
        bookDao.removeBook(1);


        AuthorDao authorDao = AuthorDaoImpl.getInstance();
//        authorDao.getAllAuthors();
        authorDao.addAuthor(new Author.Builder().setName("Ken").setLastname("Follet").setDateOfBirth("19.08.1947").build());
        printAllAuthors();

    }

    static void printAllUsers() {
        UserService userService = UserServiceImpl.getInstance();
        Map<Long, User> longUserMap = userService.getAllUsers();
        for (Map.Entry<Long, User> longUserEntry : longUserMap.entrySet()) {
            System.out.println(longUserEntry.getKey() + " " + longUserEntry.getValue());
        }
    }
    static void printAllAuthors() {
        AuthorService userService = AuthorServiceImpl.getInstance();
        Map<Long, Author> longAuthorMap = userService.getAllAuthors();
        for (Map.Entry<Long, Author> longAuthorEntry : longAuthorMap.entrySet()) {
            System.out.println(longAuthorEntry.getKey() + " " + longAuthorEntry.getValue());
        }
    }
}
