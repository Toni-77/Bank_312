import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bank_312_Main_Application extends JFrame implements ActionListener {
    private JTextField txtFirstName;
    private JTextField txtLastName;
    private JTextField txtPhone;
    private JLabel lblFirstName;
    private JPanel mainPanel;
    private JLabel lblLastName;
    private JLabel lblPhoneNr;
    private JTextField txtSSN;
    private JLabel lblSSN;
    private JButton btnSearch;

    public Bank_312_Main_Application (){
        setLayout(null);
        setTitle("312 Bank");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null);
        lblFirstName = new JLabel("First Name:");
        lblFirstName.setFont(new Font("Arial", Font.BOLD, 18));
        lblFirstName.setBounds(50,50,120,30);
        add(lblFirstName);
        txtFirstName = new JTextField();
        txtFirstName.setBounds(160,50,150,30);
        add(txtFirstName);
        lblLastName =new JLabel("Last Name:");
        lblLastName.setFont(new Font("Arial", Font.BOLD, 18));
        lblLastName.setBounds(50,100,120,30);
        add(lblLastName);
        txtLastName = new JTextField();
        txtLastName.setBounds(160,100,150,30);
        add(txtLastName);
        lblPhoneNr = new JLabel("Phone No:");
        lblPhoneNr.setFont(new Font("Arial", Font.BOLD, 18));
        lblPhoneNr.setBounds(50,150,120,30);
        add(lblPhoneNr);
        txtPhone = new JTextField();
        txtPhone.setBounds(160,150,150,30);
        add(txtPhone);

        lblSSN = new JLabel("SSN:");
        lblSSN.setFont(new Font("Arial", Font.BOLD, 18));
        lblSSN.setBounds(50,200,120,30);
        add(lblSSN);
        txtSSN = new JTextField();
        txtSSN.setBounds(160,200,150,30);
        add(txtSSN);

        btnSearch = new JButton("Search");
        btnSearch.setBounds(330,50,90,30);
        add(btnSearch);
        btnSearch.addActionListener(this);


    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
