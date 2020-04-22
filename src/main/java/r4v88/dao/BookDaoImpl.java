package r4v88.dao;

import r4v88.api.BookDao;
import r4v88.model.Book;
import r4v88.model.parser.BookParser;

import java.sql.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class BookDaoImpl implements BookDao {

    private Connection connection;
    private final String TABLE_NAME = "books";
    private final String USER = "root";
    private final String PASSWORD = "root";

    private BookParser bookParser = BookParser.getInstance();

    private static BookDao instance = new BookDaoImpl();

    public static BookDao getInstance() {
        return BookDaoImpl.instance;
    }

    private BookDaoImpl() {
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
    public void addBook(Book book) {
        PreparedStatement preparedStatement;
        try {
            String query = "insert into ? (title, isbn, publisher, year, type, isborrowed) values (?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, TABLE_NAME);
            preparedStatement.setString(2, book.getTitle());
            preparedStatement.setInt(3, book.getIsbn());
            preparedStatement.setString(4, book.getPublisher());
            preparedStatement.setString(5, book.getYear());
            preparedStatement.setString(6, book.getType().toString().toLowerCase());
            preparedStatement.setBoolean(7, book.isBorrowed());

            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Map<Long, Book> getAllBooks() {
        Map<Long, Book> idBookMap = new LinkedHashMap<>();
        PreparedStatement preparedStatement;

        try {
            String query = "select * from ?";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, TABLE_NAME);

            ResultSet resultSet = preparedStatement.executeQuery(query);

            while (resultSet.next()) {
                Book book = new Book.Builder()
                        .setTitle(resultSet.getString("title"))
                        .setIsbn(resultSet.getInt("isbn"))
                        .setPublisher(resultSet.getString("publisher"))
                        .setYear(resultSet.getString("year"))
                        .setType(bookParser.stringToEnum(resultSet.getString("type")))
                        .setIsBorrowed(resultSet.getBoolean("isborrowed"))
                        .build();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idBookMap;
    }

    @Override
    public void removeBook(long id) {
        PreparedStatement preparedStatement;
        try {
            String query = "delete from ? where id = ?";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, TABLE_NAME);
            preparedStatement.setLong(2, id);

            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void borrowBook(long id, boolean borrow) {
        PreparedStatement preparedStatement = null;
        try {
            String query = "update ? set isborrowed = ? where id = ?";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, TABLE_NAME);
            preparedStatement.setBoolean(2, borrow);
            preparedStatement.setLong(3, id);

            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
