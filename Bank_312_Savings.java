// This class creates savings objects

public class Bank_312_Savings extends Bank_312_Account{
    public Bank_312_Savings(Double balance){
        super(balance);
        setType("Savings");
        assignAccountNo();
        Bank_312_Accounts_LoansDB.addAccount(this);
    }

    // Method to assign a random 9 digit number with
    // a fixed 3 digit prefix to an account
    @Override
    public void assignAccountNo() {
        String accountNumber = getRandomNumberString();
        while(!isNnumberUnique(accountNumber))
            accountNumber = getRandomNumberString();
        setAccountNo("555" + accountNumber);
    }
    @Override
    public Boolean withdraw(double amount) {
        // Check if the withdrawal would cause the balance to drop below $100
        // or the amount is not a positive number greater than (zero) 0
        if (amount > 0 && (getBalance() - amount) >= 100) {
            // Print a message if the minimum balance requirement is not met
            System.out.println("Minimum balance of $100 required!");
            return super.withdraw(amount);
        } else {
            // return false if amount is negative or leaves less than 100 in the account
            return false;
        }
    }
}



