import java.util.HashSet;
import java.util.Random;
import java.util.Set;
// This is used as a base class to create loans (CC, Car loan and Mortgage)


public abstract class Bank_312_Loan {

    // Private fields to store the balance, remaining balance etc
    private double loanLimit;
    private double paidLoanAmount = 0;
    private double remainingBalance;
    private String loanAccountNumber;

    // Unique account numbers are stored in a set
    private static Set<String> uniqueNo = new HashSet<>();
    private String type;

    // Constructor to create a ne loan
    // Needs to be updated to accept only (zero) 0, or positive values
    // maybe by creating a factory method to check for the amount value
    public Bank_312_Loan(Double loanLimit){
        this.loanLimit =loanLimit;
        remainingBalance = loanLimit;
    }
    // MMethod to process a payment
    // Returns true only if the amount is greater than (zero) or
    // less than or equal the remaining loan balance
    public boolean payment(double amount) {
        // Checks if the payment is bigger than the remaining balance
        if (amount > 0 && remainingBalance >= amount ){
            paidLoanAmount += amount;
            remainingBalance = loanLimit - paidLoanAmount;
            return true;
        }
        else {
            // Print a message if the balance is insufficient*/
            System.out.println(remainingBalance + " is less than " + amount);
            return false;
        }
    }

    // Method to assign loan numbers
    // Subclasses will create their own versions of it
    public abstract void assignLoanNo();
    // Method returns loan account number
    public String getLoanAccountNumber() {
        return loanAccountNumber;
    }
    // Method returns the remaining balance
    public double getRemainingBalance() {
        return remainingBalance;
    }
    // Method sets loan limit
    public void setLoanLimit(double loanLimit) {
        this.loanLimit = loanLimit;
    }
    // Methods returns loan limit
    public Double getLoanAccountLimit(){
        return loanLimit;
    }
    // Method sets the loan type
    public void setType(String type){
        this.type = type;
    }
    // Method gets the loan type
    public String getType(){
        return type;
    }
    // Methods sets loan account number
    public void setLoanAccountNo(String accountNo){
        this.loanAccountNumber = accountNo;
    }
    // Method checks for any
    public static boolean isNnumberUnique(String account){
        return !uniqueNo.contains(account);
    }

    // Method to generate random numbers for the loan accounts
    // Create and returns  digits number strings
    public static String getRandomNumberString() {
        // It will generate 6 digit random Number.
        // from 0 to 999999
        Random rnd = new Random();
        int number = rnd.nextInt(999999);

        // this will convert any number sequence into 6 character.
        return String.format("%06d", number);
    }
}



