import java.util.ArrayList;
// This class will create client objects with their information

public class Bank_312_Client {
    private ArrayList<Bank_312_Account> accounts = new ArrayList<>();
    private ArrayList<Bank_312_Loan> loanAccounts = new ArrayList<>();
    private String firstName;
    private String lastName;
    private String phoneNr;
    private String SSN;
    private String email;
    private String address;
    private String pin;

    public Bank_312_Client(String firstName, String lastName, String phoneNr, String SSN, String email, String address){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNr = phoneNr;
        this.SSN = SSN;
        this.email = email;
        this.address = address;
    }

    // Method to add account
    public void addAccount(Bank_312_Account account){
        accounts.add(account);
    }
    // Method to add loan
    public void addLoanAccount(Bank_312_Loan loanAccount){
        loanAccounts.add(loanAccount);
    }

    // ArrayList of client accounts
    public ArrayList<Bank_312_Account> getAccounts(){
        return accounts;
    }
    // ArrayList of client loans
    public ArrayList<Bank_312_Loan> getLoanAccounts(){
        return loanAccounts;
    }

    // getter and setters method for Client class fields

    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getPhoneNr() {
        return phoneNr;
    }
    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
    }
    public String getSSN() {
        return SSN;
    }
    public void setSSN(String SSN) {
        this.SSN = SSN;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPin() {
        return pin;
    }
    // Method to set pin if needed (not used, but nice addition to for the next improvement)
    public void setPin(String pin) {
        this.pin = pin;
    }

    // Returns a String representation of the client objects with all the info
    @Override
    public String toString(){
        return ( getFirstName() + "," + getLastName() + "," + getPhoneNr() + "," +getSSN()+ "," +getEmail()+ "," +getAddress());
    }
}
