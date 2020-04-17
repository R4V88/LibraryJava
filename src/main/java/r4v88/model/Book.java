package r4v88.model;

import org.apache.maven.lifecycle.internal.BuildListCalculator;
import r4v88.model.enums.BookType;

public class Book {
    private long id;
    private String title;
    private String authorName;
    private String authorLastname;
    private String isbn;
    private String publishingHouse;
    private String year;
    private BookType bookType;

    private Book(long id, String title, String authorName, String authorLastname, String isbn, String publishingHouse, String year, BookType bookType) {
        this.id = id;
        this.title = title;
        this.authorName = authorName;
        this.authorLastname = authorLastname;
        this.isbn = isbn;
        this.publishingHouse = publishingHouse;
        this.year = year;
        this.bookType = bookType;
    }

    public static class Builder {
        private long id;
        private String title;
        private String authorName;
        private String authorLastname;
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

        public Builder setAuthorName(String authorName) {
            this.authorName = authorName;
            return this;
        }

        public Builder setAuthorLastname(String authorLastname) {
            this.authorLastname = authorLastname;
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
            return new Book(id, title, authorName, authorLastname, isbn, publishingHouse, year, bookType);
        }
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getAuthorLastname() {
        return authorLastname;
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
