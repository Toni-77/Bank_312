import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;


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


        btnAddAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // This code will be executed when the button is clicked


                if(accountType.getSelectedItem().toString().equals("Checking")) {
                    Bank_312_Account account = new Bank_312_Checking(Double.parseDouble(txtAmount.getText()));
                    Bank_312_Transaction_GUI.getCurrentClient().addAccount(account);
                    transcactionGUI.updateTable(account);
                } else if (accountType.getSelectedItem().toString().equals("Savings")) {
                    Bank_312_Account account = new Bank_312_Savings(Double.parseDouble(txtAmount.getText()));
                    Bank_312_Transaction_GUI.getCurrentClient().addAccount(account);
                    transcactionGUI.updateTable(account);
                } else if (accountType.getSelectedItem().toString().equals("Credit Card")) {
                    Bank_312_Loan loan = new Bank_312_CC(Double.parseDouble(txtAmount.getText()));
                    Bank_312_Transaction_GUI.getCurrentClient().addLoanAccount(loan);
                    transcactionGUI.updateTable(loan);
                } else if (accountType.getSelectedItem().toString().equals("Car Loan")) {
                    Bank_312_Loan loan = new Bank_312_Car_Loan(Double.parseDouble(txtAmount.getText()));
                    Bank_312_Transaction_GUI.getCurrentClient().addLoanAccount(loan);
                    transcactionGUI.updateTable(loan);
                } else if (accountType.getSelectedItem().toString().equals("Mortgage")) {
                    Bank_312_Loan loan = new Bank_312_Mortgage(Double.parseDouble(txtAmount.getText()));
                    Bank_312_Transaction_GUI.getCurrentClient().addLoanAccount(loan);
                    transcactionGUI.updateTable(loan);
                }
               /*Transaction_Gui.getCurrentClient().addAccount(account);
               transcactionGUI.updateTable(account);*/
                setVisible(false);
                transactionGui.setVisible(true);
                //clientDBGui.dispose();
                //Welcome_GUI.getSearchCreate().setVisible(true);
            }
        });




    }
    public boolean addAccount(Bank_312_Account account){
        Bank_312_Transaction_GUI.getCurrentClient().addAccount(account);
        return true;
    }
}

