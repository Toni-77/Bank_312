import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

// This JFrame will show all the transactions from the chosen account/loan
// of the client in session from the JTable
public class Bank_312_Account_Transactions_GUI extends JFrame {
    private JTable transactionsSummary;
    private  DefaultTableModel model;

    public Bank_312_Account_Transactions_GUI(String chosenAccount){
        setLayout(null);
        setTitle("Transactions Frame");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null);

        String [] columnNames = {"No","Account Number", "Type", "Amount" , "Date"};
        model = new DefaultTableModel(columnNames, 0);
        ArrayList<Bank_312_Transaction> transactions = new ArrayList<>();
        for(Bank_312_Transaction transaction:Bank_312_TransactionsDB.getTransactions()){
            if(transaction.getAccountNo().equals(chosenAccount))
                transactions.add(transaction);
        }

        model.setRowCount(0);

        for(int i = 0; i < transactions.size();i++) {
            Object [] obj = {transactions.get(i).getSerialNo(), transactions.get(i).getAccountNo(),transactions.get(i).getTransactionType(), transactions.get(i).getAmount(),transactions.get(i).getDate()};
            model.addRow(obj);
        }

        transactionsSummary = new JTable(model);

        // Embed the table in a scroll pane
        JScrollPane scrollPane = new JScrollPane(transactionsSummary);
        scrollPane.setBounds(100,250,600,100);

        // Add the scroll pane to the frame
        add(scrollPane);
    }

}


