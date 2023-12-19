public interface DatabaseOperations {
    User getUserByUsername(String username);
    void insertUser(User user);
    void updateUser(User user);
    void deleteUser(User user);
    void insertEquationCalculation(RegularUser user, String equation, String solution);
}
