public class User {
    private String username;
    private String password;
    private String name;
    private String surname;

    public User(String username, String password, String name, String surname) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    // Getters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    // Setters with basic validation (you can customize as needed)
    public void setUsername(String username) {
        if (username != null && !username.isEmpty()) {
            this.username = username;
        } else {
            System.out.println("Username cannot be null or empty.");
        }
    }

    public void setPassword(String password) {
        if (password != null && password.length() >= 8) {
            this.password = password;
        } else {
            System.out.println("Password must be at least 8 characters long.");
        }
    }

    public void setName(String name) {
        this.name = name; // No validation added for simplicity
    }

    public void setSurname(String surname) {
        this.surname = surname; // No validation added for simplicity
    }
}
