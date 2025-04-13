public class Bank_312_Savings extends Bank_312_Account{
    public Bank_312_Savings(Double balance){
        super(balance);
        setType("Savings");
        assignAccountNo();
        Bank_312_Accounts_LoansDB.addAccount(this);
    }


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
        if (getBalance() - amount < 100) {
            // Print a message if the minimum balance requirement is not met
            System.out.println("Minimum balance of $100 required!");
            return false;
        } else {
            // Call the parent class withdraw method
            return super.withdraw(amount);
        }
    }
}

