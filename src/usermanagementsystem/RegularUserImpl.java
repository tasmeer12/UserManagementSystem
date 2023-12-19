import java.util.List;

public class RegularUserImpl implements RegularUserInterface {

    @Override
    public RegularUser authenticate(String username, String password) {
        // Implement logic to authenticate regular user
        // For simplicity, let's check if the provided credentials match the test credentials
        if ("user".equals(username) && "password".equals(password)) {
            return new RegularUser(username, password, "John", "Doe");
        } else {
            return null;
        }
    }

    @Override
    public void saveEquationCalculation(RegularUser regularUser, String equation, String solution) {
        // Implement logic to save equation calculation for the regular user
        // For simplicity, let's assume we store calculations in a list
        System.out.println("Equation calculation saved: " + equation + " = " + solution);
    }

    @Override
    public List<String> viewEquationCalculations(RegularUser regularUser) {
        // Implement logic to retrieve and return equation calculations for the regular user
        // For simplicity, let's return a sample list
        List<String> calculations = List.of("1 + 1 = 2", "2 * 3 = 6");
        return calculations;
    }

    @Override
    public void modifyProfile(RegularUser regularUser) {
        // Implement logic to modify regular user profile
        System.out.println("Profile modified for user: " + regularUser.getUsername());
    }

    // Additional methods for regular user interface
}
