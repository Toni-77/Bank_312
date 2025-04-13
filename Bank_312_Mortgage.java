public class Bank_312_Mortgage extends Bank_312_Loan{


    public Bank_312_Mortgage(Double mortgageTotal){
        super(mortgageTotal);
        setType("Mortgage");
        assignLoanNo();
        Bank_312_Accounts_LoansDB.addLoan(this);
    }
    @Override
    public void assignLoanNo() {
        String accountNumber = getRandomNumberString();
        while(!isNnumberUnique(accountNumber))
            accountNumber = getRandomNumberString();
        setLoanAccountNo("333" + accountNumber);
    }
}

