package r4v88.api;

import r4v88.exception.*;
import r4v88.model.User;

import java.util.Map;

public interface UserService {

    Map<Long, User> getAllUsers();
    User getUserById(long id) throws UserWithIdDoesNotExist;
    User getUserByNameAndLastname(String name, String lastname) throws UserWithNameAndLastNameDoesNotExist;
    User getUserByEmail(String email) throws UserWithEmailDoesNotExist;
    User getUserByLogin(String login) throws UserWithLoginDoesNotExist;

    void createUser(User user) throws UserWithLoginEmailAlreadyExist, DateOfBirthIsNotValid, LoginIsNotValid, PasswordIsNotValid, EmailIsNotValid;

    void removeUserById (long id) throws UserWithIdDoesNotExist;
    void removeUserByLogin (String login) throws UserWithLoginDoesNotExist;
    void removeUserByEmail (String email) throws UserWithEmailDoesNotExist;

    void updateUserName (String name, long id);
    void updateUserLastname (String lastname, long id);
    void updateUserLogin (String login, long id) throws LoginIsNotValid;
    void updateUserEmail (String email, long id) throws EmailIsNotValid;
    void updateUserPassword (String password, long id) throws PasswordIsNotValid;
}
