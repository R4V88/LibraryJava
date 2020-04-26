package r4v88.service;

import r4v88.exception.*;
import r4v88.model.User;
import r4v88.model.enums.Role;

import java.util.Map;

public interface UserService {

    Map<Long, User> getAllUsers();

    Map<Long, User> getUsersByRole(Role role);

    User getUserById(long id) throws UserWithIdDoesNotExistException;

    User getUserByNameAndLastname(String name, String lastname) throws UserWithNameAndLastNameDoesNotExistException;

    User getUserByEmail(String email) throws UserWithEmailDoesNotExistException;

    User getUserByLogin(String login) throws UserWithLoginDoesNotExistException;

    void createUser(User user) throws UserWithLoginEmailAlreadyExistException, DateOfBirthIsNotValidException, LoginIsNotValidException, PasswordIsNotValidException, EmailIsNotValidException;

    void removeUserById(long id) throws UserWithIdDoesNotExistException;

    void removeUserByLogin(String login) throws UserWithLoginDoesNotExistException;

    void removeUserByEmail(String email) throws UserWithEmailDoesNotExistException;

    void updateUserName(String name, long id);

    void updateUserLastname(String lastname, long id);

    void updateUserLogin(String login, long id) throws LoginIsNotValidException;

    void updateUserEmail(String email, long id) throws EmailIsNotValidException;

    void updateUserPassword(String password, long id) throws PasswordIsNotValidException;
}
