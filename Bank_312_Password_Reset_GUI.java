import javax.swing.*;
import java.awt.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Bank_312_Password_Reset_GUI extends JFrame {
    private JLabel lblMainMessage;
    private JLabel lblEmail;
    private JTextField txtEmail;
    private JButton btnSubmit;
    private JLabel lblInfo;


    public Bank_312_Password_Reset_GUI(){
        setLayout(null);
        setTitle("312 Bank Password Reset");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null);


        lblMainMessage = new JLabel("Password recovery");
        lblMainMessage.setHorizontalAlignment(JLabel.CENTER);
        lblMainMessage.setBounds(260,30,250,30);
        lblMainMessage.setFont(new Font("Arial", Font.BOLD, 24));
        add(lblMainMessage);


        lblEmail = new JLabel("Enter email address:");
        lblEmail.setBounds(80,100, 200,30);
        lblEmail.setFont(new Font("Arial", Font.BOLD, 18));
        add(lblEmail);


        txtEmail = new JTextField();
        txtEmail.setBounds(280,100,150,30);
        add(txtEmail);


        lblInfo = new JLabel();
        lblInfo.setFont(new Font("Arial", Font.BOLD, 18));
        lblInfo.setForeground(Color.red);
        lblInfo.setBounds(440,100,150,30);
        add(lblInfo);


        btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(280,160,150,30);
        add(btnSubmit);
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // This code will be executed when the button is clicked
                if(!Bank_312_EmployeesDB.findEmployee(txtEmail.getText())){
                    lblInfo.setText("Email not found");
                }else
                    lblInfo.setText("Email sent");
            }
        });
    }


}

