package r4v88.model.parser;

import r4v88.model.enums.Gender;

public class UserParser {

    private static UserParser instance = null;

    private UserParser() {
    }

    public static UserParser getInstance() {
        if (instance == null) {
            instance = new UserParser();
        }
        return instance;
    }

    public Gender stringToEnum(String string) {
        String stringToConvert = string.toUpperCase();
        switch (stringToConvert) {
            case "MALE": {
                return Gender.MALE;
            }
            case "FEMALE": {
                return Gender.FEMALE;
            }
        }
        return null;
    }
}
