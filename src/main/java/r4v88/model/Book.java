package r4v88.model;

public class Book {
    private String title;
    private String authorName;
    private String authorLastname;
    private String isbn;
    private String publishingHouse;
    private String year;

    private Book(String title, String authorName, String authorLastname, String isbn, String publishingHouse, String year) {
        this.title = title;
        this.authorName = authorName;
        this.authorLastname = authorLastname;
        this.isbn = isbn;
        this.publishingHouse = publishingHouse;
        this.year = year;
    }

    public static class Builder {
        private String title;
        private String authorName;
        private String authorLastname;
        private String isbn;
        private String publishingHouse;
        private String year;

        public Builder() {
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

        public Book build() {
            return new Book(title, authorName, authorLastname, isbn, publishingHouse, year);
        }
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
}
