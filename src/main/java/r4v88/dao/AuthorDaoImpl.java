package r4v88.dao;

import r4v88.api.AuthorDao;
import r4v88.model.Author;

import java.sql.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class AuthorDaoImpl implements AuthorDao {

    private final String DATABASE_NAME = "library";
    private final String TABLE_NAME = "authors";
    private final String USER = "root";
    private final String PASSWORD = "root";
    private Connection connection;

    private static AuthorDao instance = new AuthorDaoImpl();

    public static AuthorDao getInstance() {
        return AuthorDaoImpl.instance;
    }

    private AuthorDaoImpl() {
        init();
    }

    private void init() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost/" + DATABASE_NAME + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Map<Long, Author> getAllAuthors() {
        Map<Long, Author> authors = new LinkedHashMap<>();
        Statement statement = null;

        try {
            statement = connection.createStatement();
            String query = "select * from " + TABLE_NAME;

            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String lastname = resultSet.getString("lastname");
                String dateOfBirth = resultSet.getString("dateofbirth");

                Author author = new Author.Builder()
                        .setName(name)
                        .setLastname(lastname)
                        .setDateOfBirth(dateOfBirth)
                        .build();

                authors.put(id, author);
            }
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return authors;
    }

    @Override
    public void addAuthor(Author author) {
        PreparedStatement preparedStatement = null;
        try {
            String query = "insert into " + TABLE_NAME + "(name, lastname, dateofbirth) values (?, ?, ?)";

            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, author.getName());
            preparedStatement.setString(2, author.getLastname());
            preparedStatement.setString(3, author.getDateOfBirth());

            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void removeAuthorById(Long id) {
        PreparedStatement preparedStatement = null;
        try {
            String query = "delete from " + TABLE_NAME + " where id = ?";

            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setLong(1, id);

            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
