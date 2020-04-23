package r4v88.dao;

import r4v88.model.Book;
import r4v88.model.entity.BookUser;
import r4v88.model.enums.Type;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class BookUserDaoImpl implements BookUserDao {

    private static BookUserDao instance = new BookUserDaoImpl();

    private Connection connection;
    private final String TABLE_NAME = "books";
    private final String USER = "root";
    private final String PASSWORD = "root";

    private BookUserDaoImpl() {
        init();
    }

    public static BookUserDao getInstance() {
        return BookUserDaoImpl.instance;
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
    public List<BookUser> getAllUsers() {
        List<BookUser> bookUsers = new LinkedList<>();
        PreparedStatement preparedStatement;
        try {
            String query = "select * from ?";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, TABLE_NAME);

            ResultSet resultSet = preparedStatement.executeQuery(query);

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String title = resultSet.getString("title");
                int isbn = resultSet.getInt("isbn");
                String publisher = resultSet.getString("publisher");
                String year = resultSet.getString("year");
                Type type = Type.valueOf(resultSet.getString("type"));
                boolean isBorrowed = resultSet.getBoolean("isborrowed");

                bookUsers.add(new BookUser(id, Book.builder()
                        .isBorrowed(isBorrowed)
                        .type(type)
                        .year(year)
                        .publisher(publisher)
                        .title(title)
                        .isbn(isbn)
                        .build()));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookUsers;
    }

    @Override
    public BookUser getBookById(long id) {
        PreparedStatement preparedStatement;
        try {
            String query = "select * from ? where id = ?";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, TABLE_NAME);
            preparedStatement.setLong(2, id);

            ResultSet resultSet = preparedStatement.executeQuery(query);

            while (resultSet.next()) {
                Book book = (Book) resultSet.getObject("book");
                return new BookUser(id, book);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public long getBookIdByName(String bookName) {
        PreparedStatement preparedStatement;
        try {
            String query = "select * from ? where bookName = ?";

            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, TABLE_NAME);
            preparedStatement.setString(2, bookName);

            ResultSet resultSet = preparedStatement.executeQuery(query);


            while (resultSet.next()) {
                return resultSet.getInt("id");
            }

            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
