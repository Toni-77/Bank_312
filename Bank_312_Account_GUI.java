import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;


// This JFrame will process different transaction of various accounts/loans
public class Bank_312_Account_GUI extends JFrame {


    private JLabel lblGreetings;
    private JLabel lblAcountType;
    private JComboBox accountType;
    private JLabel lblAmount;
    private JLabel lblLoanLimit;
    private JFormattedTextField txtAmount;
    private JLabel lblCurrentClient;
    private JLabel lblClient;
    private JButton btnAddAccount;
    Bank_312_Transaction_GUI transcactionGUI;


    // The constructor receives a Bank_312_Transaction_GUI to create an object
    public Bank_312_Account_GUI(Bank_312_Transaction_GUI transactionGui) {
        transcactionGUI = transactionGui;
        setLayout(null);
        setTitle("Open Account Frame");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null);


        lblGreetings = new JLabel("Open New Account");
        lblGreetings.setFont(new Font("Arial", Font.BOLD, 18));
        lblGreetings.setBounds(290,5,250,30);
        add(lblGreetings);


        lblAcountType = new JLabel("Choose the Account:");
        lblAcountType.setFont(new Font("Arial", Font.BOLD, 18));
        lblAcountType.setBounds(50,200,200,30);
        add(lblAcountType);


        String[] accountOptions = {"Checking", "Savings", "Credit Card", "Car Loan", "Mortgage"};
        accountType = new JComboBox<>(accountOptions);
        accountType.setBounds(250, 200,80,30);
        add(accountType);
        accountType.addActionListener(e -> {
            String selectedItem = (String) accountType.getSelectedItem();
            if(selectedItem.equals("Credit Card") || selectedItem.equals("Car Loan") || selectedItem.equals("Mortgage")){
                lblAmount.setVisible(false);
                lblLoanLimit.setVisible(true);
            }
            else{
                lblLoanLimit.setVisible(false);
                lblAmount.setVisible(true);
            }
        });


        // This code is used to format the amount input in numbers with 2 decimal places
        DecimalFormat decimalFormat = new DecimalFormat("#.00"); // Format to allow up to 2 decimal places
        NumberFormatter numberFormatter = new NumberFormatter(decimalFormat);
        numberFormatter.setValueClass(Double.class); // Allow only Double values
        numberFormatter.setAllowsInvalid(false); // Prevent invalid input
        txtAmount = new JFormattedTextField(numberFormatter);
        txtAmount.setBounds(600, 200,80,30);
        add(txtAmount);


        lblAmount = new JLabel("Enter the amount:");
        lblAmount.setFont(new Font("Arial", Font.BOLD, 18));
        lblAmount.setBounds(400, 200,160,30);
        add(lblAmount);


        lblLoanLimit = new JLabel("Enter Loan/CC Limit:");
        lblLoanLimit.setFont(new Font("Arial", Font.BOLD, 18));
        lblLoanLimit.setBounds(400, 200,200,30);
        add(lblLoanLimit);
        lblLoanLimit.setVisible(false);


        lblCurrentClient = new JLabel("Client in session:");
        lblCurrentClient.setFont(new Font("Arial", Font.BOLD, 18));
        lblCurrentClient.setBounds(260,110,160,30);
        add(lblCurrentClient);


        lblClient = new JLabel(Bank_312_Transaction_GUI.getCurrentClient().getFirstName() + " " + Bank_312_Transaction_GUI.getCurrentClient().getLastName());
        lblClient.setFont(new Font("Arial", Font.BOLD, 18));
        lblClient.setForeground(Color.BLUE);
        lblClient.setBounds(440,110,240,30);
        add(lblClient);


        btnAddAccount = new JButton("Add Account");
        btnAddAccount.setFont(new Font("Arial", Font.BOLD, 18));
        btnAddAccount.setBounds(520,250,160,30);
        add(btnAddAccount);


        // This button will add a chosen account/loan to the client in session
        // only if the amount entered is greater than, orA equal to (zero) 0.
        btnAddAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // This code will be executed when the button is clicked
                // and will create the chosen account/loan type with the typed amount
                // update the JTable in the Transaction_GUI JFrame
                // and also update the TransactionsDB
                Bank_312_Account account;
                Bank_312_Loan loan;
                Double amount = Double.parseDouble(txtAmount.getText());
                String selectedItem = (String) accountType.getSelectedItem();
                if (amount > 0){
                    if(selectedItem.equals("Checking")) {
                        account = new Bank_312_Checking(amount);
                        Bank_312_Transaction_GUI.getCurrentClient().addAccount(account);
                        Bank_312_TransactionsDB.addTransaction(new Bank_312_Transaction(account.getAccountNumber(), "Open account",amount));
                        transcactionGUI.updateTable(account);
                    } else if (selectedItem.equals("Savings")) {
                        account = new Bank_312_Savings(amount);
                        Bank_312_Transaction_GUI.getCurrentClient().addAccount(account);
                        Bank_312_TransactionsDB.addTransaction(new Bank_312_Transaction(account.getAccountNumber(), "Open account",amount));
                        transcactionGUI.updateTable(account);
                    } else if (selectedItem.equals("Credit Card")) {
                        loan = new Bank_312_CC(amount);
                        Bank_312_Transaction_GUI.getCurrentClient().addLoanAccount(loan);
                        Bank_312_TransactionsDB.addTransaction(new Bank_312_Transaction(loan.getLoanAccountNumber(), "Open CC Loan",amount));
                        transcactionGUI.updateTable(loan);
                    } else if (selectedItem.equals("Car Loan")) {
                        loan = new Bank_312_Car_Loan(amount);
                        Bank_312_Transaction_GUI.getCurrentClient().addLoanAccount(loan);
                        Bank_312_TransactionsDB.addTransaction(new Bank_312_Transaction(loan.getLoanAccountNumber(), "Open Car Loan",amount));
                        transcactionGUI.updateTable(loan);
                    } else if (selectedItem.equals("Mortgage")) {
                        loan = new Bank_312_Mortgage(amount);
                        Bank_312_Transaction_GUI.getCurrentClient().addLoanAccount(loan);
                        Bank_312_TransactionsDB.addTransaction(new Bank_312_Transaction(loan.getLoanAccountNumber(), "Open Mortgage",amount));
                        transcactionGUI.updateTable(loan);
                    }
                    setVisible(false);
                    transactionGui.setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(null,"Negative amount", "Bank 312",JOptionPane.INFORMATION_MESSAGE);
                    txtAmount.setValue(null);
                }
            }
        });
    }
}



