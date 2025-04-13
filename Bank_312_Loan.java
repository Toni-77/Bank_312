import java.util.HashSet;
import java.util.Random;
import java.util.Set;


public abstract class Bank_312_Loan {


    // Private field to store the balance
    private double loanLimit;


    private double remainingBalance;
    private String loanAccountNumber;




    private static Set<String> uniqueNo = new HashSet<>();
    private String type;


    public Bank_312_Loan(Double loanLimit){
        this.loanLimit =loanLimit;
    }
    public void payment(double amount) {
        // Check if the balance is sufficient for the withdrawal
        if (remainingBalance >= amount) {
            // Decrease the balance by the withdrawal amount
            remainingBalance -= amount;
        } else {
            // Print a message if the balance is insufficient
            System.out.println(remainingBalance + " is less than " + amount);
        }
    }
    public abstract void assignLoanNo();
    public String getLoanAccountNumber() {
        return loanAccountNumber;
    }


    public void setLoanAccountNumber(String accountNo){
        loanAccountNumber = accountNo;
    }


    public void setLoanLimit(double loanLimit) {
        this.loanLimit = loanLimit;
    }


    public Double getLoanAccountLimit(){
        return loanLimit;
    }


    public void setType(String type){
        this.type = type;
    }


    public String getType(){
        return type;
    }
    public void setLoanAccountNo(String accountNo){
        this.loanAccountNumber = accountNo;
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

