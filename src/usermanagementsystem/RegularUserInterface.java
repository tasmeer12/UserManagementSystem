import java.util.List;

public interface RegularUserInterface {
    RegularUser authenticate(String username, String password);
    void saveEquationCalculation(RegularUser regularUser, String equation, String solution);
    List<String> viewEquationCalculations(RegularUser regularUser);
    void modifyProfile(RegularUser regularUser);
    // Add other methods as needed
}