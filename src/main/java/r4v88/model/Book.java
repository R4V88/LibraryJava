package r4v88.model;

import r4v88.model.enums.Type;

public class Book {
    private String title;
    private int isbn;
    private String publisher;
    private String year;
    private Type type;
    private boolean isBorrowed;

    private Book(String title, int isbn, String publisher, String year, Type type, boolean isBorrowed) {
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
        this.year = year;
        this.type = type;
        this.isBorrowed = isBorrowed;
    }

    public static class Builder {
        private String title;
        private int isbn;
        private String publisher;
        private String year;
        private Type type;
        private boolean isBorrowed;

        public Builder() {
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setIsbn(int isbn) {
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

        public Builder setIsBorrowed(boolean isBorrowed) {
            this.isBorrowed = isBorrowed;
            return this;
        }

        public Book build() {
            return new Book(title, isbn, publisher, year, type, isBorrowed);
        }
    }

    public String getTitle() {
        return title;
    }

    public int getIsbn() {
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

    public boolean isBorrowed() {
        return isBorrowed;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", publisher='" + publisher + '\'' +
                ", year='" + year + '\'' +
                ", type=" + type +
                ", isBorrowed=" + isBorrowed +
                '}';
    }
}
