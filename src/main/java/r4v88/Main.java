package r4v88;

import r4v88.model.Book;
import r4v88.model.User;
import r4v88.model.enums.Gender;

public class Main {
    public static void main(String[] args) {
        User user = new User.Builder()
                .setName("tak")
                .setLastname("nie")
                .setLogin("wacek")
                .setPassword("placek321")
                .setDateOfBirth("14.06.1988")
                .setEmail("email@gmail.mail")
                .setGender(Gender.FEMALE)
                .build();

    }

    Book book = new Book.Builder()
            .setTitle("title")
            .setAuthorName("Name")
            .setAuthorLastname("Lastname")
            .setIsbn("123124123")
            .setPublishingHouse("YES")
            .setYear("12398")
            .build();
}
