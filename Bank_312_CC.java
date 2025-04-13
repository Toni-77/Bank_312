public class Bank_312_CC extends Bank_312_Loan{
    public Bank_312_CC(Double loanLimit){
        super(loanLimit);
        setType("Credit Card");
        assignLoanNo();
    }


    @Override
    public void assignLoanNo() {
        String accountNumber = getRandomNumberString();
        while(!isNnumberUnique(accountNumber))
            accountNumber = getRandomNumberString();
        setLoanAccountNo("111" + accountNumber);
    }
}

