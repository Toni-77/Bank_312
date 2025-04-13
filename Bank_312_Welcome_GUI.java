import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


public class Bank_312_Welcome_GUI extends JFrame implements ActionListener {
    private static Bank_312_Main_GUI searchCreate;
    public static Bank_312_Main_GUI getSearchCreate() {
        return searchCreate;
    }


    private JLabel uNameLabel;
    private JTextField txtUserName;
    private JLabel lblPassword;
    private JPasswordField txtPassword;
    private JButton btnLogIn;


    private JButton btnForgotUserPass;
    private JLabel lblInfo;
    private JLabel lblLogo;


    public Bank_312_Welcome_GUI(){
        //Create Bank employees with username, password and email
        Bank_312_EmployeesDB.populateEmpDB();


        setLayout(null);
        setTitle("312 Bank");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null);




        lblLogo = new JLabel("Welcome to 312 Bank");
        lblLogo.setHorizontalAlignment(JLabel.CENTER);
        lblLogo.setBounds(260,30,250,30);
        lblLogo.setFont(new Font("Arial", Font.BOLD, 24));
        add(lblLogo);


        uNameLabel = new JLabel("Username:");
        uNameLabel.setBounds(80,100, 100,30);
        uNameLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(uNameLabel);


        txtUserName = new JTextField();
        txtUserName.setBounds(180,100,150,30);
        add(txtUserName);


        lblPassword = new JLabel("Password:");
        lblPassword.setFont(new Font("Arial", Font.BOLD, 18));
        lblPassword.setBounds(80,150, 100,30);
        add(lblPassword);


        txtPassword = new JPasswordField();
        txtPassword.setBounds(180,150,150,30);
        add(txtPassword);


        btnLogIn = new JButton("Log in");
        btnLogIn.setBounds(180,220,150,30);
        add(btnLogIn);


        btnForgotUserPass = new JButton("Forgot Username/Password");
        btnForgotUserPass.setBounds(350,220,200,30);
        add(btnForgotUserPass);
        btnForgotUserPass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // This code will be executed when the button is clicked
                new Bank_312_Password_Reset_GUI().setVisible(true);
            }
        });


        lblInfo = new JLabel();
        lblInfo.setFont(new Font("Arial", Font.BOLD, 18));
        lblInfo.setForeground(Color.red);
        lblInfo.setBounds(180,280,150,30);
        add(lblInfo);


        btnLogIn.addActionListener(this);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String userName = txtUserName.getText();
        String password = String.valueOf(txtPassword.getPassword());
        if (e.getSource() == btnLogIn) {
            if (Bank_312_EmployeesDB.findEmployee(userName, password))
            {
                //lblInfo.setText("Hi from button log in");
                Bank_312_ClientDB.populateDB();
                searchCreate = new Bank_312_Main_GUI();
                searchCreate.setVisible(true);
                setVisible(false);
            }
            else {
                lblInfo.setText("User not found!");
                txtUserName.setText(null);
                txtPassword.setText(null);
            }
        }
    }
}

