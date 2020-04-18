package r4v88.model;

public class Author {
    private String authorName;
    private String authorLastname;
    private String dateOfBirth;

    private Author(String authorName, String authorLastname, String dateOfBirth) {
        this.authorName = authorName;
        this.authorLastname = authorLastname;
        this.dateOfBirth = dateOfBirth;
    }

    public static class Builder {
        private String authorName;
        private String authorLastname;
        private String dateOfBirth;

        public Builder() {
        }

        public Builder setAuthorName(String authorName) {
            this.authorName = authorName;
            return this;
        }

        public Builder setAuthorLastName(String authorLastname) {
            this.authorLastname = authorLastname;
            return this;
        }

        public Builder setDateOfBirth(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Author build() {
            return new Author(authorName, authorLastname, dateOfBirth);
        }

    }

    public String getAuthorName() {
        return authorName;
    }

    public String getAuthorLastname() {
        return authorLastname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }
}
