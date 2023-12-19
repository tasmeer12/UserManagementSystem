import java.util.ArrayList;
import java.util.List;

public class Admin extends User implements AdminInterface {
    private String adminRole;

    public Admin(String username, String password, String name, String surname, String adminRole) {
        super(username, password, name, surname);
        this.adminRole = adminRole;
    }

    public String getAdminRole() {
        return adminRole;
    }

    public void setAdminRole(String adminRole) {
        this.adminRole = adminRole;
    }

    public void performAdminAction() {
        System.out.println("Admin action performed.");
    }

    @Override
    public void modifyProfile(User user) {
        if (user instanceof Admin) {
            Admin adminUser = (Admin) user;
            // Implement logic to modify admin profile
            System.out.println("Admin profile modified: " + adminUser.getUsername());
        } else {
            System.out.println("Cannot modify profile. Invalid user type.");
        }
    }

    @Override
    public List<User> viewAllUsers() {
        // Implement logic to retrieve and return a list of all users
        // For simplicity, let's return a sample list
        List<User> allUsers = new ArrayList<>();
        allUsers.add(new Admin("admin1", "adminPass", "Admin1", "AdminSurname1", "Role1"));
        allUsers.add(new RegularUser("user1", "userPass", "User1", "UserSurname1"));
        // Add more users as needed
        return allUsers;
    }

    @Override
    public void removeUser() {
        // Implement logic to remove a user
        System.out.println("User removed.");
    }

    @Override
    public List<String> reviewOperations() {
        // Implement logic to retrieve and return a list of operations
        // For simplicity, let's return a sample list
        List<String> operations = new ArrayList<>();
        operations.add("Operation1");
        operations.add("Operation2");
        // Add more operations as needed
        return operations;
    }

    @Override
    public Admin authenticate(String username, String password) {
        // Implement logic to authenticate an admin
        // You might need to access the database here
        return null; // Replace with the actual logic
    }
}
