package r4v88.model;

import r4v88.model.enums.Type;

public class Book {
    private long id;
    private String title;
    private String isbn;
    private String publisher;
    private String year;
    private Type type;

    private Book(String title, String isbn, String publisher, String year, Type type) {
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
        this.year = year;
        this.type = type;
    }

    public static class Builder {
        private String title;
        private String isbn;
        private String publisher;
        private String year;
        private Type type;

        public Builder() {
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setIsbn(String isbn) {
            this.isbn = isbn;
            return this;
        }

        public Builder setPublisher(String publisher) {
            this.publisher = publisher;
            return this;
        }

        public Builder setYear(String year) {
            this.year = year;
            return this;
        }

        public Builder setType(Type type) {
            this.type = type;
            return this;
        }

        public Book build() {
            return new Book(title, isbn, publisher, year, type);
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

    public String getPublisher() {
        return publisher;
    }

    public String getYear() {
        return year;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", publisher='" + publisher + '\'' +
                ", year='" + year + '\'' +
                ", bookType=" + type +
                '}';
    }
}
