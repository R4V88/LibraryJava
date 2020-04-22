package r4v88;

import r4v88.api.AuthorService;
import r4v88.api.BookService;
import r4v88.api.UserService;
import r4v88.model.Author;
import r4v88.model.Book;
import r4v88.model.User;
import r4v88.model.enums.Gender;
import r4v88.model.enums.Role;
import r4v88.model.enums.Type;
import r4v88.service.AuthorServiceImpl;
import r4v88.service.BookServiceImpl;
import r4v88.service.UserServiceImpl;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
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


        Author author = new Author.Builder()
                .setName("Name")
                .setLastname("LastName")
                .setDateOfBirth("19.12.2019")
                .build();

        Author author1 = new Author.Builder()
                .setName("Ken")
                .setLastname("Follet")
                .setDateOfBirth("19.08.1947")
                .build();


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

        User korek = new User.Builder()
                .setLogin("Korek123")
                .setLastname("Dębowy")
                .setEmail("napisz@tutaj")
                .setPassword("asli*jdD2")
                .setDateOfBirth("11.11.2011")
                .setName("Korek")
                .setGender(Gender.MALE)
                .build();

        BookService bookService = BookServiceImpl.getInastance();
        AuthorService authorService = AuthorServiceImpl.getInstance();
        UserService userService = UserServiceImpl.getInstance();


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
