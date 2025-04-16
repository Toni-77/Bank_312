// This class creates mortgage objects

public class Bank_312_Mortgage extends Bank_312_Loan{
    public Bank_312_Mortgage(Double mortgageTotal){
        super(mortgageTotal);
        setType("Mortgage");
        assignLoanNo();
        Bank_312_Accounts_LoansDB.addLoan(this);
    }
    // Method to assign a random 9 digit number with
    // a fixed 3 digit prefix
    @Override
    public void assignLoanNo() {
        String accountNumber = getRandomNumberString();
        while(!isNnumberUnique(accountNumber))
            accountNumber = getRandomNumberString();
        setLoanAccountNo("333" + accountNumber);
    }
}




