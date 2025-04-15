import java.util.*;

//Abstract account that Checking and Savings will use to extend
public abstract class Bank_312_Account {
    // Private field to store the account number
    private String accountNumber;
    //Private field to store the account type
    private String type;

    // Private field to store the balance
    private double balance;
    // Private Set to store unique account numbers
    private static Set<String> uniqueNo = new HashSet<>();
    // Class Constructor needs a balance amount to create an account
    public Bank_312_Account(double balance) {
        this.balance = balance;
    }
    // Method to randomly assign unique account numbers
    // Each class will use its version of assigning account numbers
    public abstract void assignAccountNo();
    // Method to deposit an amount into the account
    public Boolean deposit(double amount) {
        // Increase the balance by the deposit amount
        if (amount > 0 && amount <= 1000000000){
            balance += amount;
            return true;
        }else
            return false;
    }
    // Method to set the account number
    public void setAccountNo(String accountNo){
        this.accountNumber = accountNo;
    }
    // Method to withdraw an amount from the account
    public Boolean withdraw(double amount) {
        // Check if the balance is sufficient for the withdrawal
        // and the amount is not negative or (zero) 0
        if (balance >= amount && amount > 0) {
            // Decrease the balance by the withdrawal amount
            balance -= amount;
            return true;
        } else {
            // Print a message if the balance is insufficient
            System.out.println("Insufficient balance");
            return false;
        }
    }

    // Method to get the current balance
    public double getBalance() {
        // Return the current balance
        return balance;
    }
    // Method to set account type(Checking or Savings)
    public void setType(String type){
        this.type = type;
    }
    // Method to return account type
    public String getType(){
        return type;
    }
    // method tha returns the account number
    public String getAccountNumber(){
        return accountNumber;
    }
    // method to check if the account number is already in use
    public static boolean isNnumberUnique(String account){
        if (uniqueNo.contains(account))
            return false;
        return true;
    }
    // method to generate an account number
    // the first three digits are the same, but the next 6 digits are used
    // to create an account number
    public static String getRandomNumberString() {
        // It will generate 6 digit random Number.
        // from 0 to 999999
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        // this will convert any number sequence into 6 character.
        return String.format("%06d", number);
    }
}

