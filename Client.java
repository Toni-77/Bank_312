import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Client extends JFrame implements ActionListener {

    Bank_312_Main_Application mainForm;
    private JLabel lblBankClients;

    private JLabel lblAmount;
    private JTextField txtAmount;
    private JLabel lblAcountType;
    private JLabel lblPaymentType;

    private JComboBox payOptions;

    private JComboBox accountType;

    public Client(){
        // Create JFrame and set the size and location
        setLayout(null);
        setTitle("Client Interaction Frame");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null);

        lblAmount = new JLabel("Enter the Amount:");
        lblAmount.setFont(new Font("Arial", Font.BOLD, 18));
        //lblAmount.setBounds();
        add(lblAmount);

        lblBankClients = new JLabel("Payment Type and Amount");
        lblBankClients.setFont(new Font("Arial", Font.BOLD, 18));
        lblBankClients.setBounds(290,5,250,30);
        add(lblBankClients);

        lblAcountType = new JLabel("Choose the Account:");
        lblAcountType.setFont(new Font("Arial", Font.BOLD, 18));
        lblAcountType.setBounds(50,100,200,30);
        add(lblAcountType);

        txtAmount = new JTextField();
        txtAmount.setBounds(520, 100,80,30);
        add(txtAmount);

        String[] accountOptions = {"Checking", "Savings", "Credit Card", "Mortgage"};
        accountType = new JComboBox<>(accountOptions);
        accountType.setBounds(250, 100,80,30);
        add(accountType);

        lblPaymentType = new JLabel("Payment Type:");
        lblPaymentType.setFont(new Font("Arial", Font.BOLD, 18));
        lblPaymentType.setBounds(50,150,160,30);
        add(lblPaymentType);

        String[] paymentOptions = {"Deposit", "Withdraw", "Payment", "Option 4"};
        payOptions = new JComboBox<>(paymentOptions);
        payOptions.setBounds(250, 150,80,30);
        add(payOptions);


    }




    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
