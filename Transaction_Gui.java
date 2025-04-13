import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Transaction_Gui extends JFrame implements ActionListener {


    public static Client getCurrentClient() {
        return currentClient;
    }


    public static void setCurrentClient(Client client) {
        currentClient = client;
    }


    private Transaction_Gui currentGUI = this;
    private ClientDB_GUI clientDBGui;
    private JTable accountsTable;
    private static Client currentClient;
    private JLabel lblCurrentClient;


    private JLabel lblClient;


    private JLabel lblBankClients;


    private JLabel lblAmount;
    private JTextField txtAmount;
    private JLabel lblAcountType;
    private JLabel lblTransactionType;


    private JComboBox payOptions;


    private JComboBox accountType;


    private DefaultTableModel model;
    private JButton btnBackToSearchCreate;


    private JButton btnAddNewAccount;


    public Transaction_Gui(ClientDB_GUI clientDBFrame, Client clientInSession){
        // Create JFrame and set the size and location
        clientDBGui = clientDBFrame;
        currentClient = clientInSession;
        setLayout(null);
        setTitle("Client Interaction Frame");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null);


        lblBankClients = new JLabel("Payment Type and Amount");
        lblBankClients.setFont(new Font("Arial", Font.BOLD, 18));
        lblBankClients.setBounds(290,5,250,30);
        add(lblBankClients);


        lblAcountType = new JLabel("Choose the Account:");
        lblAcountType.setFont(new Font("Arial", Font.BOLD, 18));
        lblAcountType.setBounds(50,50,200,30);
        add(lblAcountType);


        txtAmount = new JTextField();
        txtAmount.setBounds(590, 50,80,30);
        add(txtAmount);


        String[] accountOptions = {"Checking", "Savings", "Credit Card","Car Loan", "Mortgage"};
        accountType = new JComboBox<>(accountOptions);
        accountType.setBounds(250, 50,80,30);
        add(accountType);


        lblTransactionType = new JLabel("Transaction Type:");
        lblTransactionType.setFont(new Font("Arial", Font.BOLD, 18));
        lblTransactionType.setBounds(50,100,200,30);
        add(lblTransactionType);


        String[] paymentOptions = {"Deposit", "Withdraw", "Payment", "Option 4"};
        payOptions = new JComboBox<>(paymentOptions);
        payOptions.setBounds(250, 100,80,30);
        add(payOptions);


        lblAmount = new JLabel("Enter the amount:");
        lblAmount.setFont(new Font("Arial", Font.BOLD, 18));
        lblAmount.setBounds(420, 50,160,30);
        add(lblAmount);


        lblCurrentClient = new JLabel("Client in session:");
        lblCurrentClient.setFont(new Font("Arial", Font.BOLD, 18));
        lblCurrentClient.setBounds(260,210,160,30);
        add(lblCurrentClient);


        lblClient = new JLabel(currentClient.getFirstName() + " " + currentClient.getLastName());
        lblClient.setFont(new Font("Arial", Font.BOLD, 18));
        lblClient.setForeground(Color.BLUE);
        lblClient.setBounds(440,210,240,30);
        add(lblClient);


        btnBackToSearchCreate = new JButton("Back to Search/Create");
        btnBackToSearchCreate.setFont(new Font("Arial", Font.BOLD, 18));
        btnBackToSearchCreate.setBounds(450,370,250,30);
        add(btnBackToSearchCreate);


        btnBackToSearchCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // This code will be executed when the button is clicked
                dispose();
                clientDBGui.dispose();
                Welcome_GUI.getSearchCreate().setVisible(true);
            }
        });


        btnAddNewAccount =new JButton("Open New Account");
        btnAddNewAccount.setFont(new Font("Arial", Font.BOLD, 18));
        btnAddNewAccount.setBounds(100,370,250,30);
        add(btnAddNewAccount);


        btnAddNewAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // This code will be executed when the button is clicked
                setVisible(false);
                new Account_GUI(currentGUI).setVisible(true);
                //clientDBGui.dispose();
                //Welcome_GUI.getSearchCreate().setVisible(true);
            }
        });


        String [] columnNames = {"Account Number", "Account Type", "Balance"};
        Bank_312_Account account;
        ArrayList<Bank_312_Account> accounts = currentClient.getAccounts();


        model = new DefaultTableModel(columnNames, 0);


        model.setRowCount(0);
        for(int i = 0; i < accounts.size();i++) {
            Object [] obj = {accounts.get(i).getAccountNumber(), accounts.get(i).getType(),accounts.get(i).getBalance()};
            model.addRow(obj);
        }
        accountsTable = new JTable(model);


        // Embed the table in a scroll pane
        JScrollPane scrollPane = new JScrollPane(accountsTable);
        scrollPane.setBounds(100,250,600,100);


        // Add the scroll pane to the frame
        add(scrollPane);


    }


    public void updateTable(Bank_312_Account account){
        Object [] obj = {account.getAccountNumber(), account.getType(),account.getBalance()};
        model.addRow(obj);
        model.fireTableDataChanged();
    }




    @Override
    public void actionPerformed(ActionEvent e) {


    }
}

