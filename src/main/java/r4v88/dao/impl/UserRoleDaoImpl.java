package r4v88.dao.impl;

import r4v88.dao.UserRoleDao;
import r4v88.model.entity.UserRole;
import r4v88.model.enums.Role;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class UserRoleDaoImpl implements UserRoleDao {

    private static UserRoleDao instance = new UserRoleDaoImpl();

    private Connection connection;
    private final String TABLE_NAME = "roles";
    private final String USER = "root";
    private final String PASSWORD = "root";


    private UserRoleDaoImpl() {
        init();
    }

    public static UserRoleDao getInstance() {
        return UserRoleDaoImpl.instance;
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
    public List<UserRole> getAllUsers() {
        List<UserRole> userRoles = new LinkedList<>();
        PreparedStatement preparedStatement;
        try {
            String query = "select * from ?";

            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, TABLE_NAME);

            ResultSet resultSet = preparedStatement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("role");


                userRoles.add(new UserRole(id, Role.valueOf(name)));
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userRoles;
    }

    @Override
    public UserRole getRoleById(long id) {
        PreparedStatement preparedStatement;
        try {
            String query = "select * from ? where id = ?";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, TABLE_NAME);
            preparedStatement.setLong(2, id);

            ResultSet resultSet = preparedStatement.executeQuery(query);

            while (resultSet.next()) {
                String role = resultSet.getString("role");
                Role userRole = Role.valueOf(role);
                return new UserRole(id, userRole);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public int getRoleIdByName(String roleName) {
        PreparedStatement preparedStatement;
        try {
            String query = "select * from ? where role = ?";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, TABLE_NAME);
            preparedStatement.setString(2, roleName);

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
