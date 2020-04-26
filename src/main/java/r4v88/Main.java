package r4v88;

import r4v88.service.UserService;
import r4v88.exception.*;
import r4v88.model.Author;
import r4v88.model.Book;
import r4v88.model.User;
import r4v88.model.enums.Gender;
import r4v88.model.enums.Role;
import r4v88.model.enums.Type;
import r4v88.service.impl.UserServiceImpl;

import java.util.Map;

public class Main {
    public static void main(String[] args) throws UserWithIdDoesNotExistException, UserWithNameAndLastNameDoesNotExistException, UserWithEmailDoesNotExistException, UserWithLoginEmailAlreadyExistException, DateOfBirthIsNotValidException, LoginIsNotValidException, PasswordIsNotValidException, EmailIsNotValidException, UserWithLoginDoesNotExistException {
        User wacek = User.builder()
                .name("tak")
                .lastname("nie")
                .login("wacek2")
                .password("1Ab*45678")
                .dateOfBirth("11.08.2018")
                .email("email@gmail.mail")
                .gender(Gender.MALE)
                .role(Role.USER)
                .build();

        User marek = User.builder()
                .name("marek")
                .lastname("jest")
                .login("marekk")
                .password("1Ab*45678")
                .dateOfBirth("11.10.1994")
                .email("email@dzimejl.mail")
                .gender(Gender.FEMALE)
                .role(Role.ADMIN)
                .build();


        Book book = Book.builder()
                .title("title")
                .isbn(123124123)
                .publisher("YES")
                .year("12398")
                .type(Type.COMEDY)
                .build();


        Author author = new Author("Name", "LastName", "19.12.2019");

        User karolek = User.builder()
                .name("Karolak")
                .lastname("Worek")
                .login("loginbb")
                .email("taki@mejl")
                .password("1Ab*45678")
                .dateOfBirth("11.12.2018")
                .gender(Gender.MALE)
                .role(Role.USER)
                .build();
    }

    static void printAllUsers() {
        UserService userService = UserServiceImpl.getInstance();
        Map<Long, User> longUserMap = userService.getAllUsers();
        for (Map.Entry<Long, User> longUserEntry : longUserMap.entrySet()) {
            System.out.println(longUserEntry.getKey() + " " + longUserEntry.getValue());
        }
    }
}
