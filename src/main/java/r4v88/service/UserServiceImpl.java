package r4v88.service;

import r4v88.api.UserDao;
import r4v88.api.UserService;
import r4v88.dao.UserDaoImpl;
import r4v88.model.User;

import java.util.Map;

public class UserServiceImpl implements UserService {

    private UserDao userDao = UserDaoImpl.getInstance();

    private static UserService instance = new UserServiceImpl();

    private UserServiceImpl() {
    }

    public static UserService getInstance() {
        return UserServiceImpl.instance;
    }


    @Override
    public Map<Long, User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getUserById(long id) {
        User user = null;
        Map<Long, User> usersMap = getAllUsers();

        for (Map.Entry<Long, User> users : usersMap.entrySet()) {
            if (id == users.getKey()) {
                user = users.getValue();
            }
        }
        return user;
    }

    @Override
    public User getUserByNameAndLastname(String name, String lastname) {
        User user = null;
        Map<Long, User> usersMap = getAllUsers();

        for (Map.Entry<Long, User> users : usersMap.entrySet()) {
            if (name.equals(users.getValue().getName()) && lastname.equals(users.getValue().getLastname())) {
                user = users.getValue();
                return user;
            }
        }
        return null;
    }

    @Override
    public User getUserByEmail(String email) {
        User user = null;
        Map<Long, User> userMap = getAllUsers();

        for (Map.Entry<Long, User> userEntry : userMap.entrySet()) {
            if (email.equals(userEntry.getValue().getEmail())) {
                user = userEntry.getValue();
                return user;
            }
        }
        return null;
    }

    @Override
    public User getUserByLogin(String login) {
        User user = null;
        Map<Long, User> userMap = getAllUsers();
        for (Map.Entry<Long, User> users : userMap.entrySet()) {
            if (login.equals(users.getValue().getLogin())) {
                user = users.getValue();
                return user;
            }
        }
        return null;
    }

    @Override
    public void createUser(User user) {
        userDao.createUser(user);
    }

    @Override
    public void removeUserById(long id) {
        userDao.removeUserById(id);
    }

    @Override
    public void removeUserByLogin(String login) {
        Map<Long, User> userMap = getAllUsers();
        for (Map.Entry<Long, User> users : userMap.entrySet()) {
            if (login.equals(users.getValue().getLogin())) {
                userDao.removeUserById(users.getKey());
            }
        }
    }

    @Override
    public void removeUserByEmail(String email) {
        Map<Long, User> userMap = getAllUsers();
        for (Map.Entry<Long, User> users : userMap.entrySet()) {
            if (email.equals(users.getValue().getEmail())) {
                userDao.removeUserById(users.getKey());
            }
        }
    }

    @Override
    public void updateUserName(String name, long id) {
        Map<Long, User> userMap = getAllUsers();
        User user = userMap.get(id);
        User userUpdate = new User.Builder()
                .setName(name)
                .setLastname(user.getLastname())
                .setLogin(user.getLogin())
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .setDateOfBirth(user.getDateOfBirth())
                .build();

        userDao.updateUser(userUpdate, id);
    }

    @Override
    public void updateUserLastname(String lastname, long id) {
        Map<Long, User> userMap = getAllUsers();
        User user = userMap.get(id);
        User userUpdate = new User.Builder()
                .setName(user.getName())
                .setLastname(lastname)
                .setLogin(user.getLogin())
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .setDateOfBirth(user.getDateOfBirth())
                .build();

        userDao.updateUser(userUpdate, id);
    }

    @Override
    public void updateUserLogin(String login, long id) {
        Map<Long, User> userMap = getAllUsers();
        User user = userMap.get(id);
        User userUpdate = new User.Builder()
                .setName(user.getName())
                .setLastname(user.getLastname())
                .setLogin(login)
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .setDateOfBirth(user.getDateOfBirth())
                .build();

        userDao.updateUser(userUpdate, id);
    }

    @Override
    public void updateUserEmail(String email, long id) {
        Map<Long, User> userMap = getAllUsers();
        User user = userMap.get(id);
        User userUpdate = new User.Builder()
                .setName(user.getName())
                .setLastname(user.getLastname())
                .setLogin(user.getLogin())
                .setEmail(email)
                .setPassword(user.getPassword())
                .setDateOfBirth(user.getDateOfBirth())
                .build();

        userDao.updateUser(userUpdate, id);
    }

    @Override
    public void updateUserPassword(String password, long id) {
        Map<Long, User> userMap = getAllUsers();
        User user = userMap.get(id);
        User userUpdate = new User.Builder()
                .setName(user.getName())
                .setLastname(user.getLastname())
                .setLogin(user.getLogin())
                .setEmail(user.getEmail())
                .setPassword(password)
                .setDateOfBirth(user.getDateOfBirth())
                .build();

        userDao.updateUser(userUpdate, id);
    }

    @Override
    public void updateUserDateOfBirth(String dateOfBirth, long id) {
        Map<Long, User> userMap = getAllUsers();
        User user = userMap.get(id);
        User userUpdate = new User.Builder()
                .setName(user.getName())
                .setLastname(user.getLastname())
                .setLogin(user.getLogin())
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .setDateOfBirth(dateOfBirth)
                .build();

        userDao.updateUser(userUpdate, id);
    }
}
