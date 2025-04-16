import java.util.ArrayList;
import java.util.List;
// This class serves as a transactions database
// by storing transaction information in a list

public class Bank_312_TransactionsDB {
    private static ArrayList<Bank_312_Transaction> transactions = new ArrayList<>();
    public static ArrayList<Bank_312_Transaction> getTransactions() {
        return transactions;
    }
    private static int currentSerialNo = 0;
    // Method returns current transaction serial number
    // It increases the current number by one after each call
    public static int getCurrentSerialNo() {
        currentSerialNo++;
        return currentSerialNo;
    }
    // Method to add a new transaction to tha ArrayList of transactions
    public static void addTransaction(Bank_312_Transaction transaction){
        transactions.add(transaction);
    }
}




