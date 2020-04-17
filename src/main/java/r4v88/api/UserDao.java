package r4v88.api;

import r4v88.model.User;

import java.util.List;

public interface UserDao {

    void saveUser(User user);

    void updateUser (User user);

    void removeUserById(long id);

    List<User> getAllUsers();
}
