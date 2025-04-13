import java.util.ArrayList;
import java.util.List;


public class Bank_312_TransactionsDB {


    private static ArrayList<Bank_312_Transaction> transactions = new ArrayList<>();


    public static ArrayList<Bank_312_Transaction> getTransactions() {
        return transactions;
    }


    private static int currentSerialNo = 0;
    public static int getCurrentSerialNo() {
        currentSerialNo++;
        return currentSerialNo;
    }


    public static void addTransaction(Bank_312_Transaction transaction){
        transactions.add(transaction);
    }


}

