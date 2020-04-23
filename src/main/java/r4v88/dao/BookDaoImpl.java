package r4v88.dao;

import r4v88.api.BookDao;
import r4v88.model.Book;
import r4v88.model.enums.Type;
import r4v88.model.parser.BookParser;

import java.sql.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class BookDaoImpl implements BookDao {

    private Connection connection;
    private final String DATABASE_NAME = "library";
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
                    .getConnection("jdbc:mysql://localhost/" + DATABASE_NAME + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addBook(Book book) {
        PreparedStatement preparedStatement;
        try {
            String query = "insert into " + TABLE_NAME + "(title, isbn, publisher, year, type, isborrowed) values (?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setInt(2, book.getIsbn());
            preparedStatement.setString(3, book.getPublisher());
            preparedStatement.setString(4, book.getYear());
            preparedStatement.setString(5, book.getType().toString().toLowerCase());
            preparedStatement.setBoolean(6, book.isBorrowed());

            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Map<Long, Book> getAllBooks() {
        Map<Long, Book> idBookMap = new LinkedHashMap<>();
        Statement statement;

        try {
            statement = connection.createStatement();
            String query = "select * from" + TABLE_NAME;
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Book book = Book.builder()
                        .title(resultSet.getString("title"))
                        .isbn(resultSet.getInt("isbn"))
                        .publisher(resultSet.getString("publisher"))
                        .year(resultSet.getString("year"))
                        .type(Type.valueOf(resultSet.getString("type")))
                        .isBorrowed(resultSet.getBoolean("isborrowed"))
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
            String query = "delete from " + TABLE_NAME + " where id = ?";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setLong(1, id);

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
            String query = "update " + TABLE_NAME + " set isborrowed = ? where id = ?";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setBoolean(1, borrow);
            preparedStatement.setLong(2, id);

            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
