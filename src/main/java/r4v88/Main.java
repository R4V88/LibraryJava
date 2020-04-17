package r4v88;

import r4v88.model.User;

public class Main {
    public static void main(String[] args) {
        User user = new User.Builder()
                .setName("tak")
                .setLastname("nie")
                .setLogin("wacek")
                .setPassword("placek321")
                .setDateOfBirth("14.06.1988")
                .setEmail("email@gmail.mail")
                .setGender("Female")
                .build();


    }
}
