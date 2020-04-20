package r4v88.validator;

import r4v88.exception.DateOfBirthIsNotValid;
import r4v88.exception.EmailIsNotValid;
import r4v88.exception.LoginIsNotValid;
import r4v88.exception.PasswordIsNotValid;
import r4v88.model.User;

public class UserValidator {

    private final int MIN_LENGTH_LOGIN = 6;
    /*
        For PASSWORD_VALIDATOR below:
        1) Password must contain at least 8 characters
        2) Password must contain at least 1 number
        3) Password must contain at least 1 upper case letter
        4) Password must contain at least 1 lower case letter
        5) Password must contain at least 1 special character
        6) Password must not contain any spaces
     */
    private final String PASSWORD_VALIDATOR = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*])(?=\\S+$).{8,}$";
    private final String EMAIL_VALIDATOR = "^(.+)@(.+)$";
    /*
        For DATE_VALIDATOR:
        Date required format: DD.MM.YYYY
     */
    private final String DATE_VALIDATOR = "^([0-2][0-9]|(3)[0-1])(\\.)(((0)[0-9])|((1)[0-2]))(\\.)\\d{4}$";


    private static UserValidator instance = null;

    private UserValidator() {
    }

    public static UserValidator getInstance() {
        if (instance == null) {
            instance = new UserValidator();
        }
        return instance;
    }

    public boolean isPasswordValid(String password) {
        return password.matches(PASSWORD_VALIDATOR);
    }

    public boolean isLoginValid(String login) {
        return login.length() >= MIN_LENGTH_LOGIN;
    }

    public boolean isEmailValid(String email) {
        return email.matches(EMAIL_VALIDATOR);
    }

    public boolean isDateOfBirthValid(String date) {
        return date.matches(DATE_VALIDATOR);
    }

    public boolean isUserValid(User user) throws LoginIsNotValid, PasswordIsNotValid, EmailIsNotValid, DateOfBirthIsNotValid {
        if (!isLoginValid(user.getLogin())) {
            throw new LoginIsNotValid("Login is too short! (Min. 6 characters)");
        }
        if (!isPasswordValid(user.getPassword())) {
            throw new PasswordIsNotValid("Password is not valid!");
        }
        if (!isEmailValid(user.getEmail())) {
            throw new EmailIsNotValid("Email is not valid!");
        }
        if (!isDateOfBirthValid(user.getDateOfBirth())) {
            throw new DateOfBirthIsNotValid("Date of your birth is not valid!");
        }

        return true;
    }
}
