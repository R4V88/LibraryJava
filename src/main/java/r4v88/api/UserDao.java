package r4v88.api;

import r4v88.model.User;

import java.util.Map;

public interface UserDao {

    Map<Long, User> getAllUsers();

    void insertUser(User user);

    void updateUserName(String name, long id);

    void updateUserLastname(String lastname, long id);

    void updateUserLogin(String login, long id);

    void updateUserEmail(String email, long id);

    void updateUserPassword(String password, long id);

    void removeUserById(long id);
}
