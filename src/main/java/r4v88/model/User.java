package r4v88.model;

import r4v88.model.enums.Gender;

public class User {

    private long id;
    private String name;
    private String lastname;
    private String login;
    private String email;
    private String password;
    private Gender gender;
    private String dateOfBirth;

    private User(long id, String name, String lastname, String login, String email, String password, Gender gender, String dateOfBirth) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.login = login;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    public static class Builder {

        private long id;
        private String name;
        private String lastname;
        private String login;
        private String email;
        private String password;
        private Gender gender;
        private String dateOfBirth;

        /*
            Konstruktor parametrowy nie ma sensu bo w ten sposob wprowadzamy parametry jak bezposrednio w konstruktorze
            parametryzowanym dla klasy.
        */
//        public Builder(String name, String lastname, String login, String email, String password, String gender, String dateOfBirth) {
//            this.name = name;
//            this.lastname = lastname;
//            this.login = login;
//            this.email = email;
//            this.password = password;
//            this.gender = gender;
//            this.dateOfBirth = dateOfBirth;
//        }

        public Builder() {
        }

        public Builder setId(long id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setLastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public Builder setLogin(String login) {
            this.login = login;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setGender(Gender gender) {
            this.gender = gender;
            return this;

        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setDateOfBirth(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public User build() {
            return new User(id, name, lastname, login, email, password, gender, dateOfBirth);
        }
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public Gender getGender() {
        return gender;
    }

    public String getPassword() {
        return password;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }


}
