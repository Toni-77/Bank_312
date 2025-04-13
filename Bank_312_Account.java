import java.util.*;


public abstract class Bank_312_Account {
    // Private field to store the account number
    private String accountNumber;
    private String type;


    private List<String> transactionsNo = new ArrayList<>();


    // Private field to store the balance
    private double balance;
    private static Set<String> uniqueNo = new HashSet<>();
    // Constructor to initialize account number and balance
    public Bank_312_Account(double balance) {
        this.balance = balance;
    }


    public void addAccountTransaction(String transactionNo){
        transactionsNo.add(transactionNo);
    }
    public List<String> getTransactionsNo(){
        return transactionsNo;
    }
    public abstract void assignAccountNo();
    // Method to deposit an amount into the account
    public Boolean deposit(double amount) {
        // Increase the balance by the deposit amount
        balance += amount;
        return true;
    }
    public void setAccountNo(String accountNo){
        this.accountNumber = accountNo;
    }
    // Method to withdraw an amount from the account




    public Boolean withdraw(double amount) {
        // Check if the balance is sufficient for the withdrawal
        if (balance >= amount) {
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
    public void setType(String type){
        this.type = type;
    }


    public String getType(){
        return type;
    }


    public String getAccountNumber(){
        return accountNumber;
    }
    public static boolean isNnumberUnique(String account){
        if (uniqueNo.contains(account))
            return false;
        return true;
    }


    public static String getRandomNumberString() {
        // It will generate 6 digit random Number.
        // from 0 to 999999
        Random rnd = new Random();
        int number = rnd.nextInt(999999);


        // this will convert any number sequence into 6 character.
        return String.format("%06d", number);
    }
}

