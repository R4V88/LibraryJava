package r4v88.service;

import r4v88.api.UserDao;
import r4v88.api.UserService;
import r4v88.dao.UserDaoImpl;
import r4v88.exception.*;
import r4v88.model.User;
import r4v88.model.enums.Role;
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
            if (search.getValue().getUserRole().getRole().equals(role)) {
                usersByRole.put(search.getKey(), search.getValue());
            }
        }
        return usersByRole;
    }


    @Override
    public User getUserById(long id) throws UserWithIdDoesNotExist {
        User user = null;
        if (isUserWithIdExist(id)) {
            for (Map.Entry<Long, User> users : idUserMap.entrySet()) {
                if (id == users.getKey()) {
                    user = users.getValue();
                }
            }
        } else {
            throw new UserWithIdDoesNotExist("User with id = " + id + " doesnt exist!");
        }
        return user;
    }

    @Override
    public User getUserByNameAndLastname(String name, String lastname) throws UserWithNameAndLastNameDoesNotExist {
        User user = null;
        if (isUserWithNameAndLastnameExist(name, lastname)) {
            for (Map.Entry<Long, User> users : idUserMap.entrySet()) {
                if (name.equals(users.getValue().getName()) && lastname.equals(users.getValue().getLastname())) {
                    user = users.getValue();
                }
            }
        } else {
            throw new UserWithNameAndLastNameDoesNotExist("User with name: " + name + " and lastname: " + lastname + " doesnt not exist");
        }
        return user;
    }

    @Override
    public User getUserByEmail(String email) throws UserWithEmailDoesNotExist {
        User user;

        if (isUserWithEmailExist(email)) {
            for (Map.Entry<Long, User> userEntry : idUserMap.entrySet()) {
                if (email.equals(userEntry.getValue().getEmail())) {
                    user = userEntry.getValue();
                    return user;
                }
            }
        } else {
            throw new UserWithEmailDoesNotExist("User with email = " + email + " does not exist!");
        }
        return null;
    }

    @Override
    public User getUserByLogin(String login) throws UserWithLoginDoesNotExist {
        User user;

        if (isUserWithLoginExist(login)) {
            for (Map.Entry<Long, User> users : idUserMap.entrySet()) {
                if (login.equals(users.getValue().getLogin())) {
                    user = users.getValue();
                    return user;
                }
            }
        } else {
            throw new UserWithLoginDoesNotExist("User with login: " + login + " does not exist!");
        }
        return null;
    }

    @Override
    public void createUser(User user) throws UserWithLoginEmailAlreadyExist, DateOfBirthIsNotValid, LoginIsNotValid, PasswordIsNotValid, EmailIsNotValid {
        if (!isUserWithLoginExist(user.getLogin()) && !isUserWithEmailExist(user.getEmail()) && userValidator.isUserValid(user)) {
            userDao.insertUser(user);
        } else {
            throw new UserWithLoginEmailAlreadyExist("User with login: " + user.getLogin() + " and email: " + user.getEmail() + " already exist!");
        }
    }

    @Override
    public void removeUserById(long id) throws UserWithIdDoesNotExist {
        if (isUserWithIdExist(id)) {
            userDao.removeUserById(id);
        } else {
            throw new UserWithIdDoesNotExist("User with id = " + id + " doesnt exist!");
        }
    }

    @Override
    public void removeUserByLogin(String login) throws UserWithLoginDoesNotExist {
        if (isUserWithLoginExist(login)) {
            for (Map.Entry<Long, User> users : idUserMap.entrySet()) {
                if (login.equals(users.getValue().getLogin())) {
                    userDao.removeUserById(users.getKey());
                }
            }
        } else {
            throw new UserWithLoginDoesNotExist("User with login: " + login + " does not exist!");
        }
    }

    @Override
    public void removeUserByEmail(String email) throws UserWithEmailDoesNotExist {
        if (isUserWithEmailExist(email)) {
            for (Map.Entry<Long, User> users : idUserMap.entrySet()) {
                if (email.equals(users.getValue().getEmail())) {
                    userDao.removeUserById(users.getKey());
                }
            }
        } else {
            throw new UserWithEmailDoesNotExist("User with email = " + email + " does not exist!");
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
    public void updateUserLogin(String login, long id) throws LoginIsNotValid {
        if (userValidator.isLoginValid(login)) {
            userDao.updateUserLogin(login, id);
        } else {
            throw new LoginIsNotValid("Login is not valid!");
        }
    }

    @Override
    public void updateUserEmail(String email, long id) throws EmailIsNotValid {
        if (userValidator.isEmailValid(email)) {
            userDao.updateUserEmail(email, id);
        } else {
            throw new EmailIsNotValid("Email is not valid!");
        }
    }

    @Override
    public void updateUserPassword(String password, long id) throws PasswordIsNotValid {
        if (userValidator.isPasswordValid(password)) {
            userDao.updateUserPassword(password, id);
        } else {
            throw new PasswordIsNotValid("Password is not valid!");
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
