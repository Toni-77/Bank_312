import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
// This JFrame class will perform transactions for a chosen
// account from the JTable
// It can send the client to open a new account/loan
// or show transactions for a specific account/loan

public class Bank_312_Transaction_GUI extends JFrame {
    // Method returns current client
    public static Bank_312_Client getCurrentClient() {
        return currentBank312Client;
    }
    // Method sets current client
    public static void setCurrentClient(Bank_312_Client bank312Client) {
        currentBank312Client = bank312Client;
    }

    private String currentAccountNo;
    private String currentAccountType;
    private Bank_312_Transaction_GUI currentGUI = this;
    private Bank_312_ClientDB_GUI clientDBGui;
    private JTable accountsTable;
    private int row;
    private static Bank_312_Client currentBank312Client;
    private Bank_312_Account currentAccount;
    private ArrayList<Bank_312_Account> accounts;
    private ArrayList<Bank_312_Loan> loans;
    private Bank_312_Loan currentLoan;
    private JLabel lblCurrentClient;
    private JLabel lblClient;
    private JLabel lblBankClients;
    private JLabel lblAmount;
    private JFormattedTextField txtAmount;
    private JLabel lblAcountInSession;
    private JLabel lblTransactionType;
    private JLabel lblCurrentAccount;
    private JLabel lblAccount;
    private String currentAccountlabelTxt;
    private JComboBox payOptions;
    private DefaultTableModel model;
    private JButton btnTransactionHistory;
    private JButton btnBackToSearchCreate;
    private JButton btnAddNewAccount;
    private JButton btnSubmit;

    // Class constructor
    public Bank_312_Transaction_GUI(Bank_312_ClientDB_GUI clientDBFrame, Bank_312_Client bank312ClientInSession){
        // Create JFrame and set the size and location
        clientDBGui = clientDBFrame;
        currentBank312Client = bank312ClientInSession;
        setLayout(null);
        setTitle("Client Interaction Frame");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null);

        lblBankClients = new JLabel("Payment Type and Amount");
        lblBankClients.setFont(new Font("Arial", Font.BOLD, 18));
        lblBankClients.setBounds(290,5,250,30);
        add(lblBankClients);

        lblAcountInSession = new JLabel("Click on the table to choose the account:");
        lblAcountInSession.setFont(new Font("Arial", Font.BOLD, 18));
        lblAcountInSession.setBounds(220,210,380,30);
        add(lblAcountInSession);

        // used to format the text box for amount to allow numbers and 2 decimals
        DecimalFormat decimalFormat = new DecimalFormat("#.00"); // Format to allow up to 2 decimal places
        NumberFormatter numberFormatter = new NumberFormatter(decimalFormat);
        numberFormatter.setValueClass(Double.class); // Allow only Double values
        numberFormatter.setAllowsInvalid(false); // Prevent invalid input
        txtAmount = new JFormattedTextField(numberFormatter);
        txtAmount.setBounds(630, 100,80,30);
        add(txtAmount);

        lblTransactionType = new JLabel("Transaction Type:");
        lblTransactionType.setFont(new Font("Arial", Font.BOLD, 18));
        lblTransactionType.setBounds(450,50,180,30);
        add(lblTransactionType);

        payOptions = new JComboBox<>();
        payOptions.setBounds(630, 50,100,30);
        add(payOptions);

        lblAmount = new JLabel("Enter the amount:");
        lblAmount.setFont(new Font("Arial", Font.BOLD, 18));
        lblAmount.setBounds(450, 100,160,30);
        add(lblAmount);

        lblCurrentClient = new JLabel("Client in session:");
        lblCurrentClient.setFont(new Font("Arial", Font.BOLD, 18));
        lblCurrentClient.setBounds(50,50,160,30);
        add(lblCurrentClient);

        lblClient = new JLabel(currentBank312Client.getFirstName() + " " + currentBank312Client.getLastName());
        lblClient.setFont(new Font("Arial", Font.BOLD, 18));
        lblClient.setForeground(Color.BLUE);
        lblClient.setBounds(220,50,240,30);
        add(lblClient);

        lblAccount = new JLabel("In session:");
        lblAccount.setFont(new Font("Arial", Font.BOLD, 18));
        lblAccount.setBounds(50,100,120,30);
        add(lblAccount);

        lblCurrentAccount = new JLabel(currentAccountlabelTxt);
        lblCurrentAccount.setFont(new Font("Arial", Font.BOLD, 18));
        lblCurrentAccount.setForeground(Color.BLUE);
        lblCurrentAccount.setBounds(180,100,240,30);
        add(lblCurrentAccount);
        lblCurrentAccount.setVisible(false);

        btnTransactionHistory = new JButton("Detailed transactions");
        btnTransactionHistory.setFont(new Font("Arial", Font.BOLD, 18));
        btnTransactionHistory.setBounds(50,150,230,30);
        add(btnTransactionHistory);
        btnTransactionHistory.setVisible(false);
        // clicking this button will open a new JFrame
        // displaying transactions for the account/loan in session
        btnTransactionHistory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // This code will be executed when the button is clicked
                new Bank_312_Account_Transactions_GUI(currentAccountNo).setVisible(true);
            }
        });

        btnBackToSearchCreate = new JButton("Back to Search/Create");
        btnBackToSearchCreate.setFont(new Font("Arial", Font.BOLD, 18));
        btnBackToSearchCreate.setBounds(450,370,250,30);
        add(btnBackToSearchCreate);

        // clicking this button will return the user to search  for a client
        // or create a new one opening the Main_GUi JFrame
        btnBackToSearchCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // This code will be executed when the button is clicked
                dispose();
                clientDBGui.dispose();
                Bank_312_Welcome_GUI.getSearchCreate().setVisible(true);
            }
        });

        btnAddNewAccount =new JButton("Open New Account");
        btnAddNewAccount.setFont(new Font("Arial", Font.BOLD, 18));
        btnAddNewAccount.setBounds(100,370,250,30);
        add(btnAddNewAccount);

        // clicking this button will send the user to the Account_GUI JFrame
        // to open a new account/loan for the client
        btnAddNewAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // This code will be executed when the button is clicked
                setVisible(false);
                new Bank_312_Account_GUI(currentGUI).setVisible(true);
                //clientDBGui.dispose();
                //Welcome_GUI.getSearchCreate().setVisible(true);
            }
        });

        btnSubmit = new JButton("Submit");
        btnSubmit.setFont(new Font("Arial", Font.BOLD, 18));
        btnSubmit.setBounds(630, 150,100,30);
        add(btnSubmit);

        // Clicking this button will make a transaction on the
        // account/loan in session
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // This code will be executed when the button is clicked
                String selectedItem = (String) payOptions.getSelectedItem();
                if(!txtAmount.getText().isEmpty()){
                    if(selectedItem.equals("Deposit") && (currentAccountType.equals("Checking") || currentAccountType.equals("Savings"))) {
                        if(currentAccount.deposit(Double.parseDouble(txtAmount.getText()))){
                            accountsTable.getModel().setValueAt(String.format( "%.2f", currentAccount.getBalance() ),row,2);
                            Bank_312_TransactionsDB.addTransaction(new Bank_312_Transaction(currentAccountNo,selectedItem,Double.parseDouble(txtAmount.getText())));
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"Negative or zero amount", "Bank 312",JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    else if(selectedItem.equals("Withdraw") && (currentAccountType.equals("Checking") || currentAccountType.equals("Savings"))){
                        if(currentAccount.withdraw(Double.parseDouble(txtAmount.getText()))) {
                            accountsTable.getModel().setValueAt(String.format( "%.2f", currentAccount.getBalance()), row, 2);
                            Bank_312_TransactionsDB.addTransaction(new Bank_312_Transaction(currentAccountNo,selectedItem,Double.parseDouble(txtAmount.getText())));
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"Insufficient/negative or zero amount", "Bank 312",JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else if (selectedItem.equals("Payment")) {
                        if(currentLoan.payment(Double.parseDouble(txtAmount.getText()))){
                            accountsTable.getModel().setValueAt(String.format( "%.2f", currentLoan.getRemainingBalance() ),row,2);
                            Bank_312_TransactionsDB.addTransaction(new Bank_312_Transaction(currentAccountNo,selectedItem,Double.parseDouble(txtAmount.getText())));
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"Payment negative, zero or greater that balance", "Bank 312",JOptionPane.INFORMATION_MESSAGE);
                        }
                    }

                    System.out.println(Bank_312_TransactionsDB.getTransactions());
                    txtAmount.setValue(null);
                }else {
                    JOptionPane.showMessageDialog(null,"Enter an amount", "Bank 312",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        String [] columnNames = {"Account Number", "Account Type", "Balance"};
        accounts = currentBank312Client.getAccounts();
        loans = currentBank312Client.getLoanAccounts();
        // Model for JTable
        model = new DefaultTableModel(columnNames, 0);
        // adding account rows
        model.setRowCount(0);
        for(int i = 0; i < accounts.size();i++) {
            Object [] obj = {accounts.get(i).getAccountNumber(), accounts.get(i).getType(),(String.format( "%.2f",accounts.get(i).getBalance()))};
            model.addRow(obj);
        }
        // adding loan rows
        for(int i = 0; i < loans.size();i++) {
            Object [] obj = {loans.get(i).getLoanAccountNumber(), loans.get(i).getType(),(String.format( "%.2f", loans.get(i).getRemainingBalance()))};
            model.addRow(obj);
        }
        // JTable with all accounts/loans as rows
        accountsTable = new JTable(model);
        accountsTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                JTable target = (JTable) e.getSource();
                row = target.rowAtPoint(e.getPoint());
                if (row != -1) {
                    // Handle row click event
                    currentAccountNo = (String) accountsTable.getValueAt(row, 0);
                    System.out.println(currentAccountNo);
                    currentAccountType = (String) accountsTable.getValueAt(row, 1);
                    System.out.println(currentAccountType);
                    if(currentAccountType.equals("Checking") || currentAccountType.equals("Savings")) {
                        findAccount(currentAccountNo);
                        payOptions.removeAllItems();
                        payOptions.addItem("Deposit");
                        payOptions.addItem("Withdraw");
                        System.out.println(currentAccount.getAccountNumber() + " and " + currentAccount.getType());
                    } else if (currentAccountType.equals("Credit Card") || currentAccountType.equals("Car Loan") || currentAccountType.equals("Mortgage")) {
                        findLoan(currentAccountNo);
                        payOptions.removeAllItems();
                        payOptions.addItem("Payment");
                        System.out.println(currentLoan.getLoanAccountNumber() + " and " + currentLoan.getType());
                    }
                    currentAccountlabelTxt = (currentAccountType + " " + currentAccountNo);
                    lblCurrentAccount.setText(currentAccountlabelTxt);
                    lblCurrentAccount.setVisible(true);
                    btnTransactionHistory.setVisible(true);
                }
            }
        });

        // Embed the table in a scroll pane
        JScrollPane scrollPane = new JScrollPane(accountsTable);
        scrollPane.setBounds(100,250,600,100);

        // Add the scroll pane to the frame
        add(scrollPane);
    }
    // Method to find the clicked account/loan number clicked on the JTable
    public void findAccount(String accountNo) {
        for (Bank_312_Account account : accounts) {
            if (account.getAccountNumber().equals(accountNo)) {
                // account found
                currentAccount = account;
                break;
            }
        }
    }

    public void findLoan(String accountNo) {
        for (Bank_312_Loan loan : loans) {
            if (loan.getLoanAccountNumber().equals(accountNo)) {
                // account found
                currentLoan = loan;
                break;
            }
        }
    }

    // Method to update
    public void updateTable(Bank_312_Account account){
        Object [] obj = {account.getAccountNumber(), account.getType(), String.format( "%.2f", account.getBalance() )};
        model.addRow(obj);
        model.fireTableDataChanged();
    }

    public void updateTable(Bank_312_Loan loan){
        Object [] obj = {loan.getLoanAccountNumber(), loan.getType(),String.format( "%.2f", loan.getLoanAccountLimit())};
        model.addRow(obj);
        model.fireTableDataChanged();
    }
}



