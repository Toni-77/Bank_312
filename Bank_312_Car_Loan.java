public class Bank_312_Car_Loan extends Bank_312_Loan{


    public Bank_312_Car_Loan(Double loanTotal){
        super(loanTotal);
        setType("Car Loan");
        assignLoanNo();
        Bank_312_Accounts_LoansDB.addLoan(this);
    }
    @Override
    public void assignLoanNo() {
        String accountNumber = getRandomNumberString();
        while(!isNnumberUnique(accountNumber))
            accountNumber = getRandomNumberString();
        setLoanAccountNo("222" + accountNumber);
    }
}

