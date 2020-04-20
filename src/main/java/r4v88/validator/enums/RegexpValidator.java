package r4v88.validator.enums;

public enum RegexpValidator {

    /*
        MIN_LENGTH_LOGIN
        min 6 characters length.
     */
    MIN_LENGTH_LOGIN("/^.{6,}$/"),

    /*
        For PASSWORD_VALIDATOR below:
        1) Password must contain at least 8 characters
        2) Password must contain at least 1 number
        3) Password must contain at least 1 upper case letter
        4) Password must contain at least 1 lower case letter
        5) Password must contain at least 1 special character
        6) Password must not contain any spaces
     */
    PASSWORD_VALIDATOR("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*])(?=\\S+$).{8,}$"),


    EMAIL_VALIDATOR("^(.+)@(.+)$"),

    /*
        For DATE_VALIDATOR:
        Date required format: DD.MM.YYYY
     */
    DATE_VALIDATOR("^([0-2][0-9]|(3)[0-1])(\\.)(((0)[0-9])|((1)[0-2]))(\\.)\\d{4}$");

    String regexp;

    RegexpValidator(String regexp) {
        this.regexp = regexp;
    }

    public String getRegexp() {
        return regexp;
    }
}
