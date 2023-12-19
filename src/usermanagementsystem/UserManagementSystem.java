import java.util.Scanner;
import java.util.List;

public class UserManagementSystem {
    private final AdminInterface adminInterface;
    private final RegularUserInterface regularUserInterface;
    private final DatabaseOperations databaseOperations;
    private final Scanner scanner;

    public UserManagementSystem(AdminInterface adminInterface, RegularUserInterface regularUserInterface, DatabaseOperations databaseOperations) {
        this.adminInterface = adminInterface;
        this.regularUserInterface = regularUserInterface;
        this.databaseOperations = databaseOperations;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.println("Welcome to the User Management System!");

        while (true) {
            System.out.println("\nSelect User Type:");
            System.out.println("1. Admin");
            System.out.println("2. Regular User");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    handleAdminInterface();
                    break;
                case 2:
                    handleRegularUserInterface();
                    break;
                case 3:
                    System.out.println("Exiting User Management System. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private void handleAdminInterface() {
        System.out.println("Enter Admin Username: ");
        String username = scanner.next();

        System.out.println("Enter Admin Password: ");
        String password = scanner.next();

        Admin admin = adminInterface.authenticate(username, password);

        if (admin != null) {
            System.out.println("Admin login successful.");

            while (true) {
                System.out.println("\nAdmin Menu:");
                System.out.println("1. Modify Admin Profile");
                System.out.println("2. Access List of Users");
                System.out.println("3. Remove User");
                System.out.println("4. Review Operations");
                System.out.println("5. Logout");

                int adminChoice = scanner.nextInt();

                switch (adminChoice) {
                    case 1:
                        adminInterface.modifyProfile(admin);
                        break;
                    case 2:
                        adminInterface.viewAllUsers();
                        break;
                    case 3:
                        adminInterface.removeUser();
                        break;
                    case 4:
                        adminInterface.reviewOperations();
                        break;
                    case 5:
                        System.out.println("Admin logout successful.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            }
        } else {
            System.out.println("Invalid admin credentials. Please try again.");
        }
    }

    private void handleRegularUserInterface() {
        System.out.println("Enter Regular User Username: ");
        String username = scanner.next();

        System.out.println("Enter Regular User Password: ");
        String password = scanner.next();

        RegularUser regularUser = regularUserInterface.authenticate(username, password);

        if (regularUser != null) {
            System.out.println("Regular User login successful.");

            while (true) {
                System.out.println("\nRegular User Menu:");
                System.out.println("1. Modify Profile");
                System.out.println("2. Save Equation Calculation");
                System.out.println("3. View Equation Calculations");
                System.out.println("4. Logout");

                int regularUserChoice = scanner.nextInt();

                switch (regularUserChoice) {
                    case 1:
                        regularUserInterface.modifyProfile(regularUser);
                        break;
                    case 2:
                        System.out.println("Enter equation: ");
                        String equation = scanner.next();
                        System.out.println("Enter solution: ");
                        String solution = scanner.next();
                        regularUserInterface.saveEquationCalculation(regularUser, equation, solution);
                        break;
                    case 3:
                        List<String> calculations = regularUserInterface.viewEquationCalculations(regularUser);
                        System.out.println("Equation Calculations: " + calculations);
                        break;
                    case 4:
                        System.out.println("Regular User logout successful.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            }
        } else {
            System.out.println("Invalid regular user credentials. Please try again.");
        }
    }

    public static void main(String[] args) {
        AdminInterface adminInterface = new AdminImpl();
        RegularUserInterface regularUserInterface = new RegularUserImpl();
        DatabaseOperations databaseOperations = new DatabaseOperationsImpl();

        UserManagementSystem system = new UserManagementSystem(adminInterface, regularUserInterface, databaseOperations);
        system.run();
    }
}
