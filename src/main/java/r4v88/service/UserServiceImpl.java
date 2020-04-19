package r4v88.service;

import r4v88.api.UserDao;
import r4v88.api.UserService;
import r4v88.dao.UserDaoImpl;
import r4v88.exception.UserWithEmailDoesNotExist;
import r4v88.exception.UserWithIdDoesNotExist;
import r4v88.exception.UserWithNameAndLastNameDoesNotExist;
import r4v88.model.User;

import java.util.Map;

public class UserServiceImpl implements UserService {

    private final UserDao userDao = UserDaoImpl.getInstance();
    private final Map<Long, User> idUserMap = getAllUsers();

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
    public User getUserById(long id) throws UserWithIdDoesNotExist {
        User user = null;
        if (!isUserWithIdExist(id)) {
            throw new UserWithIdDoesNotExist("User with id = " + id + " doesnt exist!");
        } else {
            for (Map.Entry<Long, User> users : idUserMap.entrySet()) {
                if (id == users.getKey()) {
                    user = users.getValue();
                }
            }
        }
        return user;
    }

    private boolean isUserWithIdExist(Long id) {
        User user = idUserMap.get(id);
        return user != null;
    }

    @Override
    public User getUserByNameAndLastname(String name, String lastname) throws UserWithNameAndLastNameDoesNotExist {
        User user = null;
        if (!isUserWithNameAndLastnameExist(name, lastname)) {
            throw new UserWithNameAndLastNameDoesNotExist("User with name: " + name + " and lastname: " + lastname + " doesnt not exist");
        } else {
            for (Map.Entry<Long, User> users : idUserMap.entrySet()) {
                if (name.equals(users.getValue().getName()) && lastname.equals(users.getValue().getLastname())) {
                    user = users.getValue();
                }
            }
        }
        return user;
    }

    private boolean isUserWithNameAndLastnameExist(String name, String lastname) {
        for (Map.Entry<Long, User> user : idUserMap.entrySet()) {
            if (user.getValue().getName().equals(name) && user.getValue().getLastname().equals(lastname)) {
                return true;
            }

        }
        return false;
    }

    @Override
    public User getUserByEmail(String email) throws UserWithEmailDoesNotExist {
        User user;

        if (!isUserWithEmailExist(email)) {
            throw new UserWithEmailDoesNotExist("User with email = " + email + " does not exist!");
        } else {
            for (Map.Entry<Long, User> userEntry : idUserMap.entrySet()) {
                if (email.equals(userEntry.getValue().getEmail())) {
                    user = userEntry.getValue();
                    return user;
                }
            }
        }
        return null;
    }

    private boolean isUserWithEmailExist(String email) {
        for (Map.Entry<Long, User> users : idUserMap.entrySet()) {
            if (users.getValue().getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public User getUserByLogin(String login) {
        User user;
        for (Map.Entry<Long, User> users : idUserMap.entrySet()) {
            if (login.equals(users.getValue().getLogin())) {
                user = users.getValue();
                return user;
            }
        }
        return null;
    }

    @Override
    public void createUser(User user) {
        userDao.insertUser(user);
    }

    @Override
    public void removeUserById(long id) {
        userDao.removeUserById(id);
    }

    @Override
    public void removeUserByLogin(String login) {
        for (Map.Entry<Long, User> users : idUserMap.entrySet()) {
            if (login.equals(users.getValue().getLogin())) {
                userDao.removeUserById(users.getKey());
            }
        }
    }

    @Override
    public void removeUserByEmail(String email) {
        for (Map.Entry<Long, User> users : idUserMap.entrySet()) {
            if (email.equals(users.getValue().getEmail())) {
                userDao.removeUserById(users.getKey());
            }
        }
    }

    @Override
    public void updateUserName(String name, long id) {
        User user = idUserMap.get(id);
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
        User user = idUserMap.get(id);
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
        User user = idUserMap.get(id);
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
        User user = idUserMap.get(id);
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
        User user = idUserMap.get(id);
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
        User user = idUserMap.get(id);
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
