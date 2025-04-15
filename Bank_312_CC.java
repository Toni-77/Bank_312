// this class extends the abstract loan class with a
// prefix (111) at the beginning of the account number

public class Bank_312_CC extends Bank_312_Loan{
    public Bank_312_CC(Double loanLimit){
        super(loanLimit);
        setType("Credit Card");
        assignLoanNo();
        Bank_312_Accounts_LoansDB.addLoan(this);
    }


    @Override
    public void assignLoanNo() {
        String accountNumber = getRandomNumberString();
        while(!isNnumberUnique(accountNumber))
            accountNumber = getRandomNumberString();
        setLoanAccountNo("111" + accountNumber);
    }
}

