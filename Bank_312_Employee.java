// This class will create employees

public class Bank_312_Employee {
    private String userName;
    private String password;
    private String email;

    // Constructor with employee info
    public Bank_312_Employee(String userName, String password, String email){
        this.userName =userName;
        this.password = password;
        this.email = email;
    }

    // Getters and setters for employee fields class
    public String getUserName() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}

