package r4v88;

import r4v88.api.UserService;
import r4v88.exception.*;
import r4v88.model.Author;
import r4v88.model.Book;
import r4v88.model.User;
import r4v88.model.enums.Gender;
import r4v88.model.enums.Type;
import r4v88.service.UserServiceImpl;
import r4v88.validator.enums.RegexpValidator;

import java.util.Map;

public class Main {
    public static void main(String[] args) throws UserWithIdDoesNotExist, UserWithNameAndLastNameDoesNotExist, UserWithEmailDoesNotExist, UserWithLoginEmailAlreadyExist, DateOfBirthIsNotValid, LoginIsNotValid, PasswordIsNotValid, EmailIsNotValid {
        User wacek = new User.Builder()
                .setName("tak")
                .setLastname("nie")
                .setLogin("wacek2")
                .setPassword("1Ab*45678")
                .setDateOfBirth("11.08.2018")
                .setEmail("email@gmail.mail")
                .setGender(Gender.MALE)
                .build();

        User marek = new User.Builder()
                .setName("marek")
                .setLastname("jest")
                .setLogin("marekk")
                .setPassword("1Ab*45678")
                .setDateOfBirth("11.10.1994")
                .setEmail("email@dzimejl.mail")
                .setGender(Gender.FEMALE)
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
                .build();
        userService.createUser(karolek);
        userService.createUser(marek);
        userService.createUser(wacek);
        printAllUsers();
//        userService.updateUserName("kutalak", 6);
//        printAllUsers();

//        System.out.println(RegexpValidator.MIN_LENGTH_LOGIN.getRegexp());


//        System.out.println(userService.getAllUsers().toString());
//        System.out.println(userService.getUserByEmail("imejl.123"));


    }

    static void printAllUsers() {
        UserService userService = UserServiceImpl.getInstance();
        Map<Long, User> longUserMap = userService.getAllUsers();
        for (Map.Entry<Long, User> longUserEntry : longUserMap.entrySet()) {
            System.out.println(longUserEntry.getKey() + " " + longUserEntry.getValue());
        }
    }
}
