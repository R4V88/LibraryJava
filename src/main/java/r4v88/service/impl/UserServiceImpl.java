package r4v88.service.impl;

import r4v88.dao.UserDao;
import r4v88.dao.impl.UserDaoImpl;
import r4v88.exception.*;
import r4v88.model.User;
import r4v88.model.enums.Role;
import r4v88.service.UserService;
import r4v88.validator.UserValidator;

import java.util.LinkedHashMap;
import java.util.Map;

public class UserServiceImpl implements UserService {

    private final UserDao userDao = UserDaoImpl.getInstance();
    private final UserValidator userValidator = UserValidator.getInstance();

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
    public Map<Long, User> getUsersByRole(Role role) {
        Map<Long, User> usersByRole = new LinkedHashMap<>();
        for (Map.Entry<Long, User> search : idUserMap.entrySet()) {
            if (search.getValue().getRole().equals(role)) {
                usersByRole.put(search.getKey(), search.getValue());
            }
        }
        return usersByRole;
    }


    @Override
    public User getUserById(long id) throws UserWithIdDoesNotExistException {
        User user = null;
        if (isUserWithIdExist(id)) {
            for (Map.Entry<Long, User> users : idUserMap.entrySet()) {
                if (id == users.getKey()) {
                    user = users.getValue();
                }
            }
        } else {
            throw new UserWithIdDoesNotExistException("User with id = " + id + " doesnt exist!");
        }
        return user;
    }

    @Override
    public User getUserByNameAndLastname(String name, String lastname) throws UserWithNameAndLastNameDoesNotExistException {
        User user = null;
        if (isUserWithNameAndLastnameExist(name, lastname)) {
            for (Map.Entry<Long, User> users : idUserMap.entrySet()) {
                if (name.equals(users.getValue().getName()) && lastname.equals(users.getValue().getLastname())) {
                    user = users.getValue();
                }
            }
        } else {
            throw new UserWithNameAndLastNameDoesNotExistException("User with name: " + name + " and lastname: " + lastname + " doesnt not exist");
        }
        return user;
    }

    @Override
    public User getUserByEmail(String email) throws UserWithEmailDoesNotExistException {
        User user;

        if (isUserWithEmailExist(email)) {
            for (Map.Entry<Long, User> userEntry : idUserMap.entrySet()) {
                if (email.equals(userEntry.getValue().getEmail())) {
                    user = userEntry.getValue();
                    return user;
                }
            }
        } else {
            throw new UserWithEmailDoesNotExistException("User with email = " + email + " does not exist!");
        }
        return null;
    }

    @Override
    public User getUserByLogin(String login) throws UserWithLoginDoesNotExistException {
        User user;

        if (isUserWithLoginExist(login)) {
            for (Map.Entry<Long, User> users : idUserMap.entrySet()) {
                if (login.equals(users.getValue().getLogin())) {
                    user = users.getValue();
                    return user;
                }
            }
        } else {
            throw new UserWithLoginDoesNotExistException("User with login: " + login + " does not exist!");
        }
        return null;
    }

    @Override
    public void createUser(User user) throws UserWithLoginEmailAlreadyExistException, DateOfBirthIsNotValidException, LoginIsNotValidException, PasswordIsNotValidException, EmailIsNotValidException {
        if (!isUserWithLoginExist(user.getLogin()) && !isUserWithEmailExist(user.getEmail()) && userValidator.isUserValid(user)) {
            userDao.insertUser(user);
        } else {
            throw new UserWithLoginEmailAlreadyExistException("User with login: " + user.getLogin() + " and email: " + user.getEmail() + " already exist!");
        }
    }

    @Override
    public void removeUserById(long id) throws UserWithIdDoesNotExistException {
        if (isUserWithIdExist(id)) {
            userDao.removeUserById(id);
        } else {
            throw new UserWithIdDoesNotExistException("User with id = " + id + " doesnt exist!");
        }
    }

    @Override
    public void removeUserByLogin(String login) throws UserWithLoginDoesNotExistException {
        if (isUserWithLoginExist(login)) {
            for (Map.Entry<Long, User> users : idUserMap.entrySet()) {
                if (login.equals(users.getValue().getLogin())) {
                    userDao.removeUserById(users.getKey());
                }
            }
        } else {
            throw new UserWithLoginDoesNotExistException("User with login: " + login + " does not exist!");
        }
    }

    @Override
    public void removeUserByEmail(String email) throws UserWithEmailDoesNotExistException {
        if (isUserWithEmailExist(email)) {
            for (Map.Entry<Long, User> users : idUserMap.entrySet()) {
                if (email.equals(users.getValue().getEmail())) {
                    userDao.removeUserById(users.getKey());
                }
            }
        } else {
            throw new UserWithEmailDoesNotExistException("User with email = " + email + " does not exist!");
        }
    }

    @Override
    public void updateUserName(String name, long id) {
        userDao.updateUserName(name, id);
    }

    @Override
    public void updateUserLastname(String lastname, long id) {
        userDao.updateUserLastname(lastname, id);
    }

    @Override
    public void updateUserLogin(String login, long id) throws LoginIsNotValidException {
        if (userValidator.isLoginValid(login)) {
            userDao.updateUserLogin(login, id);
        } else {
            throw new LoginIsNotValidException("Login is not valid!");
        }
    }

    @Override
    public void updateUserEmail(String email, long id) throws EmailIsNotValidException {
        if (userValidator.isEmailValid(email)) {
            userDao.updateUserEmail(email, id);
        } else {
            throw new EmailIsNotValidException("Email is not valid!");
        }
    }

    @Override
    public void updateUserPassword(String password, long id) throws PasswordIsNotValidException {
        if (userValidator.isPasswordValid(password)) {
            userDao.updateUserPassword(password, id);
        } else {
            throw new PasswordIsNotValidException("Password is not valid!");
        }
    }

    private boolean isUserWithIdExist(Long id) {
        User user = idUserMap.get(id);
        return user != null;
    }

    private boolean isUserWithLoginExist(String login) {
        for (Map.Entry<Long, User> user : idUserMap.entrySet()) {
            if (user.getValue().getLogin().equals(login)) {
                return true;
            }
        }
        return false;
    }

    private boolean isUserWithEmailExist(String email) {
        for (Map.Entry<Long, User> users : idUserMap.entrySet()) {
            if (users.getValue().getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    private boolean isUserWithNameAndLastnameExist(String name, String lastname) {
        for (Map.Entry<Long, User> user : idUserMap.entrySet()) {
            if (user.getValue().getName().equals(name) && user.getValue().getLastname().equals(lastname)) {
                return true;
            }

        }
        return false;
    }
}
