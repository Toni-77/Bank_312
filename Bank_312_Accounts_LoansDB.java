import java.util.ArrayList;
import java.util.List;

// This class could serve as a database for accounts and loans
// if it is decided not to keep accounts/loans stored in clients objects (only)

public class Bank_312_Accounts_LoansDB {

    // List of accounts
    private static List<Bank_312_Account> accounts = new ArrayList<>();
    // List of loans
    private static List<Bank_312_Loan> loans = new ArrayList<>();

    // Method to add an account to accounts' list
    public static void addAccount(Bank_312_Account account){
        accounts.add(account);
    }

    // Method to add an account to loans' list
    public static void addLoan(Bank_312_Loan loan){
        loans.add(loan);
    }

}

