package r4v88.validator;

import r4v88.exception.DateOfBirthIsNotValid;
import r4v88.exception.EmailIsNotValid;
import r4v88.exception.LoginIsNotValid;
import r4v88.exception.PasswordIsNotValid;
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
