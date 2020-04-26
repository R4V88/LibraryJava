package r4v88.dao.impl;

import r4v88.dao.AuthorDao;
import r4v88.model.Author;

import java.sql.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class AuthorDaoImpl implements AuthorDao {
    private static AuthorDao instance = new AuthorDaoImpl();

    private final String USER = "root";
    private final String PASSWORD = "root";

    private Connection connection;

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
                    .getConnection("jdbc:mysql://localhost/library" +
                                    "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                            USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Map<Long, Author> getAllAuthors() {
        Map<Long, Author> authors = new LinkedHashMap<>();

        PreparedStatement preparedStatement;

        try {
            String query = "select * from authors";
            preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String lastname = resultSet.getString("lastname");
                String dateOfBirth = resultSet.getString("dateofbirth");

                Author author = new Author(name, lastname, dateOfBirth);

                authors.put(id, author);
            }
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return authors;
    }

    @Override
    public void addAuthor(Author author) {
        PreparedStatement preparedStatement;
        try {
            String query = "insert into authors (name, lastname, dateofbirth) values (?, ?, ?)";

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
        PreparedStatement preparedStatement;
        try {
            String query = "delete from authors where id = ?";

            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setLong(1, id);

            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
