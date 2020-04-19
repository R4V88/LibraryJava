package r4v88.dao;

import r4v88.api.UserDao;
import r4v88.model.User;

import java.sql.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class UserDaoImpl implements UserDao {

    private static UserDao instance = new UserDaoImpl();
    private Connection connection;
    private final String DATABASE_NAME = "library";
    private final String TABLE_NAME = "users";
    private final String USER = "root";
    private final String PASSWORD = "root";

    public static UserDao getInstance() {
        return UserDaoImpl.instance;
    }

    private UserDaoImpl() {
        init();
    }

    ;

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
    public Map<Long, User> getAllUsers() {
        Map<Long, User> users = new LinkedHashMap<>();
        Statement statement = null;

        try {
            statement = connection.createStatement();
            String query = "select * from " + TABLE_NAME;

            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String lastname = resultSet.getString("lastname");
                String login = resultSet.getString("login");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String dateOfBirth = resultSet.getString("dateofbirth");

                User user = new User.Builder()
                        .setName(name)
                        .setLastname(lastname)
                        .setLogin(login)
                        .setEmail(email)
                        .setPassword(password)
                        .setDateOfBirth(dateOfBirth)
                        .build();

                users.put(id, user);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void createUser(User user) {
        PreparedStatement preparedStatement = null;
        try {
            String query = "insert into " + TABLE_NAME + " (name, lastname, login, email, password, dateOfBirth) values (?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLastname());
            preparedStatement.setString(3, user.getLogin());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.setString(6, user.getDateOfBirth());

            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUser(User user, long id) {
        PreparedStatement preparedStatement = null;
        try {
            String query = "update " + TABLE_NAME + " set name = ?, lastname = ?, login = ?, email = ?, password = ?, dateofbirth = ? where id = ?";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLastname());
            preparedStatement.setString(3, user.getLogin());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.setString(6, user.getDateOfBirth());
            preparedStatement.setLong(7, id);

            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeUserById(long id) {
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
