// DatabaseOperationsImpl.java
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseOperationsImpl implements DatabaseOperations {

    private Connection connection;

    public DatabaseOperationsImpl() {
        try {
            this.connection = DatabaseConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle this appropriately in a real application
        }
    }

    @Override
    public User getUserByUsername(String username) {
        String query = "SELECT * FROM users WHERE username = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new User(
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("name"),
                        resultSet.getString("surname")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle this appropriately in a real application
        }
        return null;
    }

    @Override
    public void insertUser(User user) {
        String query = "INSERT INTO users (username, password, name, surname) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getName());
            statement.setString(4, user.getSurname());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle this appropriately in a real application
        }
    }

    @Override
    public void updateUser(User user) {
        String query = "UPDATE users SET password = ?, name = ?, surname = ? WHERE username = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getPassword());
            statement.setString(2, user.getName());
            statement.setString(3, user.getSurname());
            statement.setString(4, user.getUsername());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle this appropriately in a real application
        }
    }

    @Override
    public void deleteUser(User user) {
        String query = "DELETE FROM users WHERE username = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getUsername());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle this appropriately in a real application
        }
    }

    @Override
    public void insertEquationCalculation(RegularUser user, String equation, String solution) {
        String query = "INSERT INTO equation_calculations (username, equation, solution) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getUsername());
            statement.setString(2, equation);
            statement.setString(3, solution);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle this appropriately in a real application
        }
    }
}
