package r4v88.model;

import org.apache.maven.lifecycle.internal.BuildListCalculator;
import r4v88.model.enums.BookType;

public class Book {
    private long id;
    private String title;
    private String isbn;
    private String publishingHouse;
    private String year;
    private BookType bookType;

    private Book(long id, String title, String isbn, String publishingHouse, String year, BookType bookType) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.publishingHouse = publishingHouse;
        this.year = year;
        this.bookType = bookType;
    }

    public static class Builder {
        private long id;
        private String title;
        private String isbn;
        private String publishingHouse;
        private String year;
        private BookType bookType;

        public Builder() {
        }

        public Builder setId(long id){
            this.id = id;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setIsbn(String isbn) {
            this.isbn = isbn;
            return this;
        }

        public Builder setPublishingHouse(String publishingHouse) {
            this.publishingHouse = publishingHouse;
            return this;
        }

        public Builder setYear(String year) {
            this.year = year;
            return this;
        }

        public Builder setBookType(BookType bookType) {
            this.bookType = bookType;
            return this;
        }

        public Book build() {
            return new Book(id, title, isbn, publishingHouse, year, bookType);
        }
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public String getYear() {
        return year;
    }

    public BookType getBookType() {
        return bookType;
    }
}
