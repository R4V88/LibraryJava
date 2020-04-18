package r4v88.model;

public class Author {
    private long id;
    private String name;
    private String lastname;
    private String dateOfBirth;

    private Author(long id, String name, String lastname, String dateOfBirth) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.dateOfBirth = dateOfBirth;
    }

    public static class Builder {
        private long id;
        private String name;
        private String lastname;
        private String dateOfBirth;

        public Builder() {
        }

        public Builder setId(long id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setLastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public Builder setDateOfBirth(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Author build() {
            return new Author(id, name, lastname, dateOfBirth);
        }

    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }
}
