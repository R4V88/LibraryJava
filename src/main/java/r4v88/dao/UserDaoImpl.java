package r4v88.dao;

import r4v88.api.UserDao;
import r4v88.model.User;

import java.util.List;

public class UserDaoImpl implements UserDao {

    private static UserDao instance = new UserDaoImpl();

    public static UserDao getInstance(){
        return UserDaoImpl.instance;
    }

    private UserDaoImpl(){};

    @Override
    public void saveUser(User user) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void removeUserById(long id) {

    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }
}
