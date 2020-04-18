package r4v88;

import r4v88.model.Author;
import r4v88.model.Book;
import r4v88.model.User;
import r4v88.model.enums.BookType;
import r4v88.model.enums.Gender;

public class Main {
    public static void main(String[] args) {
        User user = new User.Builder()
                .setId(1290)
                .setName("tak")
                .setLastname("nie")
                .setLogin("wacek")
                .setPassword("placek321")
                .setDateOfBirth("14.06.1988")
                .setEmail("email@gmail.mail")
                .setGender(Gender.FEMALE)
                .build();

        Book book = new Book.Builder()
                .setId(1234234)
                .setTitle("title")
                .setIsbn("123124123")
                .setPublishingHouse("YES")
                .setYear("12398")
                .setBookType(BookType.COMEDY)
                .build();

        Author author = new Author.Builder()
                .setId(123123)
                .setName("Name")
                .setLastname("LastName")
                .setDateOfBirth("19.19.19")
                .build();

    }
}
