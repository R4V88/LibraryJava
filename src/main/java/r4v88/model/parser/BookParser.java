package r4v88.model.parser;

import r4v88.model.enums.Type;

public class BookParser {

    private static BookParser instance = null;

    public static BookParser getInstance() {
        if (instance == null) {
            return instance = new BookParser();
        }
        return instance;
    }

    private BookParser() {
    }

    public Type stringToEnum(String string) {
        String stringToConvert = string.toUpperCase();
        switch (stringToConvert) {
            case "SCIFI": {
                return Type.SCIFI;
            }
            case "FANTASY": {
                return Type.FANTASY;
            }
            case "CRIMINAL": {
                return Type.CRIMINAL;
            }
            case "SENSATIONAL": {
                return Type.SENSATIONAL;
            }
            case "DRAMA": {
                return Type.DRAMA;
            }
            case "MORAL": {
                return Type.MORAL;
            }
            case "COMEDY": {
                return Type.COMEDY;
            }
        }
        return null;
    }

}
