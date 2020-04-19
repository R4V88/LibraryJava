package r4v88.api;

import r4v88.model.User;

public interface UserService {

    User getUserById(long id);
    User getUserByNameAndLastname(String name, String lastname);
    User getUserByEmail(String email);
    User getUserByLogin(String login);

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
