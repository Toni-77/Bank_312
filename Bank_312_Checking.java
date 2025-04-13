public class Bank_312_Checking extends Bank_312_Account{
    public Bank_312_Checking(double balance){
        super(balance);
        setType("Checking");
        assignAccountNo();
    }
    @Override
    public void assignAccountNo() {
        String accountNumber = getRandomNumberString();
        while(!isNnumberUnique(accountNumber))
            accountNumber = getRandomNumberString();
        setAccountNo("222" + accountNumber);
    }
}

