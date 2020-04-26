package r4v88.validator;

import r4v88.exception.DateOfBirthIsNotValidException;
import r4v88.exception.EmailIsNotValidException;
import r4v88.exception.LoginIsNotValidException;
import r4v88.exception.PasswordIsNotValidException;
import r4v88.model.User;
import r4v88.validator.enums.RegexpValidator;

public class UserValidator {

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
        return password.matches(RegexpValidator.PASSWORD_VALIDATOR.getRegexp());
    }

    public boolean isLoginValid(String login) {
        return login.matches(RegexpValidator.MIN_LENGTH_LOGIN.getRegexp());
    }

    public boolean isEmailValid(String email) {
        return email.matches(RegexpValidator.EMAIL_VALIDATOR.getRegexp());
    }

    public boolean isDateOfBirthValid(String date) {
        return date.matches(RegexpValidator.DATE_VALIDATOR.getRegexp());
    }

    public boolean isUserValid(User user) throws LoginIsNotValidException, PasswordIsNotValidException, EmailIsNotValidException, DateOfBirthIsNotValidException {
        if (!isLoginValid(user.getLogin())) {
            throw new LoginIsNotValidException(user.getName() + " your login is too short! (Min. 6 characters)");
        }
        if (!isPasswordValid(user.getPassword())) {
            throw new PasswordIsNotValidException(user.getName() + " your password is not valid!");
        }
        if (!isEmailValid(user.getEmail())) {
            throw new EmailIsNotValidException(user.getName() + " your email is not valid!");
        }
        if (!isDateOfBirthValid(user.getDateOfBirth())) {
            throw new DateOfBirthIsNotValidException(user.getName() + " your date of your birth is not valid!");
        }

        return true;
    }
}
