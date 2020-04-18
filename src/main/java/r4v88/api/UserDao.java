package r4v88.api;

import r4v88.model.User;

import java.util.List;
import java.util.Map;

public interface UserDao {

    Map<Integer, User> getAllUsers();

    void saveUser(User user);

    void updateUser (User user, long id);

    void removeUserById(long id);
}
