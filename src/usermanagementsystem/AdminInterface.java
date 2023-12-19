import java.util.List;

public interface AdminInterface {
    Admin authenticate(String username, String password);
    void modifyProfile(User user);
    List<User> viewAllUsers();
    void removeUser();
    List<String> reviewOperations();
    // Additional methods for admin interface
}
