package r4v88.model;

public class Author {
    private String name;
    private String lastname;
    private String dateOfBirth;

    private Author(String name, String lastname, String dateOfBirth) {
        this.name = name;
        this.lastname = lastname;
        this.dateOfBirth = dateOfBirth;
    }

    public static class Builder {
        private String name;
        private String lastname;
        private String dateOfBirth;

        public Builder() {
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
            return new Author(name, lastname, dateOfBirth);
        }

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

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }
}
