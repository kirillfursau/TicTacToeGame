package repository;

import model.User;

import java.sql.*;
import java.util.Optional;

public class DatabaseUserRepository implements UserRepository {
    @Override
    public User saveUser(User user) {
        try {
            Connection connection = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/XO_schema", "root", "rootroot");
            Statement statement = connection.createStatement();
            statement.executeUpdate("REPLACE INTO users SET id = " + user.getId() + ",name = '"
                    + user.getName() + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public Optional<User> getUserByName(String name) {
        try {
            Connection connection = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/XO_schema", "root", "rootroot");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM user WHERE name = '" + name + "';");
            if (resultSet.next()) {
                return Optional.of(new User(resultSet.getInt("id"),
                        resultSet.getString("name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
