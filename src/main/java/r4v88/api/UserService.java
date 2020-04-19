package r4v88.api;

import r4v88.exception.UserWithIdDoesNotExist;
import r4v88.model.User;

import java.util.Map;

public interface UserService {

    Map<Long, User> getAllUsers();
    User getUserById(long id) throws UserWithIdDoesNotExist;
    User getUserByNameAndLastname(String name, String lastname);
    User getUserByEmail(String email);
    User getUserByLogin(String login);

    void createUser(User user);

    void removeUserById (long id);
    void removeUserByLogin (String login);
    void removeUserByEmail (String email);

    void updateUserName (String name, long id);
    void updateUserLastname (String lastname, long id);
    void updateUserLogin (String login, long id);
    void updateUserEmail (String email, long id);
    void updateUserPassword (String password, long id);
    void updateUserDateOfBirth (String dateOfBirth, long id);
}
