package r4v88.model;

public class User {

    private String name;
    private String lastname;
    private String login;
    private String email;
    private String gender;
    private String password;
    private String dateOfBirth;

    public User(String name, String lastname, String login, String email, String gender, String password, String dateOfBirth) {
        this.name = name;
        this.lastname = lastname;
        this.login = login;
        this.email = email;
        this.gender = gender;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
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

    public String getGender() {
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
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", password='" + password + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }
}
