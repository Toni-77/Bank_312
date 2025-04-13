import java.util.ArrayList;
import java.util.List;


public class Bank_312_Accounts_LoansDB {


    public static List<Bank_312_Account> getAccounts() {
        return accounts;
    }


    public static List<Bank_312_Loan> getLoans() {
        return loans;
    }


    private static List<Bank_312_Account> accounts = new ArrayList<>();
    private static List<Bank_312_Loan> loans = new ArrayList<>();


    public static void addAccount(Bank_312_Account account){
        accounts.add(account);
    }


    public static void addLoan(Bank_312_Loan loan){
        loans.add(loan);
    }




}

