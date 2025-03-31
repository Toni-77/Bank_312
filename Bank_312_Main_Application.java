import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bank_312_Main_Application extends JFrame implements ActionListener {

    Client clientForm;
    private JPanel searchPannel;

    private JPanel createPanel;
    private JLabel lblclientSearch;
    private JLabel lblNewClient;
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

    private JToggleButton switchForms;


    private JLabel lblNewClientFirstName;
    private JLabel lblNewClientLastName;
    private JLabel lblNewClientPhoneNr;
    private JLabel lblNewClientSSN;
    private JLabel lblNewClientAddress;
    private JLabel lblNewClientEmail;

    private JTextField txtNewClientFirstName;
    private JTextField txtNewClientLastName;
    private JTextField txtNewClientPhoneNr;
    private JTextField txtNewClientSSN;
    private JTextField txtNewClientAddress;
    private JTextField txtNewClientEmail;

    private JButton btnCreateClient;


    public Bank_312_Main_Application (){

        // Create JFrame and set the size and location
        setLayout(null);
        setTitle("312 Bank");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null);

        searchPannel = new JPanel();
        searchPannel.setBounds(0,0,400,300);
        searchPannel.setLayout(null);
        add(searchPannel);

        // Left side of the frame will contain existing client search info
        lblclientSearch = new JLabel("Search for the Client");
        lblclientSearch.setFont(new Font("Arial", Font.BOLD, 18));
        lblclientSearch.setBounds(90,5,250,30);
        searchPannel.add(lblclientSearch);

        lblFirstName = new JLabel("First Name:");
        lblFirstName.setFont(new Font("Arial", Font.BOLD, 18));
        lblFirstName.setBounds(50,50,120,30);
        searchPannel.add(lblFirstName);
        txtFirstName = new JTextField();
        txtFirstName.setBounds(160,50,150,30);
        searchPannel.add(txtFirstName);
        txtFirstName.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                disable(txtLastName,txtPhone,txtSSN);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (txtFirstName.getText().isEmpty()) {
                    enable(txtLastName,txtPhone,txtSSN);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });


        lblLastName =new JLabel("Last Name:");
        lblLastName.setFont(new Font("Arial", Font.BOLD, 18));
        lblLastName.setBounds(50,100,120,30);
        searchPannel.add(lblLastName);
        txtLastName = new JTextField();
        txtLastName.setBounds(160,100,150,30);
        txtLastName.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                disable(txtFirstName,txtPhone,txtSSN);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (txtLastName.getText().isEmpty()) {
                    enable(txtFirstName,txtPhone,txtSSN);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });

        searchPannel.add(txtLastName);
        lblPhoneNr = new JLabel("Phone No:");
        lblPhoneNr.setFont(new Font("Arial", Font.BOLD, 18));
        lblPhoneNr.setBounds(50,150,120,30);
        searchPannel.add(lblPhoneNr);
        txtPhone = new JTextField();
        txtPhone.setBounds(160,150,150,30);
        searchPannel.add(txtPhone);
        txtPhone.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                disable(txtFirstName,txtLastName,txtSSN);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (txtPhone.getText().isEmpty()) {
                    enable(txtFirstName,txtLastName,txtSSN);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });

        lblSSN = new JLabel("SSN:");
        lblSSN.setFont(new Font("Arial", Font.BOLD, 18));
        lblSSN.setBounds(50,200,120,30);
        searchPannel.add(lblSSN);
        txtSSN = new JTextField();
        txtSSN.setBounds(160,200,150,30);
        searchPannel.add(txtSSN);
        txtSSN.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                disable(txtFirstName,txtLastName,txtPhone);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (txtSSN.getText().isEmpty()) {
                    enable(txtFirstName,txtLastName,txtPhone);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });

        btnSearch = new JButton("Search");
        btnSearch.setBounds(220,250,90,30);
        searchPannel.add(btnSearch);
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // This code will be executed when the button is clicked
                clientForm = new Client();
                clientForm.setVisible(true);
                setVisible(false);
            }
        });

        switchForms = new JToggleButton("Switch to Create Client");
        switchForms.setBounds(150,350, 180,30);
        add(switchForms);
        switchForms.addActionListener(this);


        // Right side of the frame will contain new client info

        createPanel = new JPanel();
        createPanel.setBounds(400,0,400,500);
        createPanel.setLayout(null);
        add(createPanel);

        lblNewClient = new JLabel("Create New Client");
        lblNewClient.setFont(new Font("Arial", Font.BOLD, 18));
        lblNewClient.setBounds(90,5,250,30);
        createPanel.add(lblNewClient);
        lblNewClient.setEnabled(false);

        lblNewClientFirstName = new JLabel("First Name:");
        lblNewClientFirstName.setFont(new Font("Arial", Font.BOLD, 18));
        lblNewClientFirstName.setBounds(60,50,120,30);
        createPanel.add(lblNewClientFirstName);
        lblNewClientFirstName.setEnabled(false);

        txtNewClientFirstName = new JTextField();
        txtNewClientFirstName.setBounds(170,50,150,30);
        createPanel.add(txtNewClientFirstName);
        txtNewClientFirstName.setEnabled(false);
        txtNewClientFirstName.setEnabled(false);

        lblNewClientLastName = new JLabel("Last Name:");
        lblNewClientLastName.setFont(new Font("Arial", Font.BOLD, 18));
        lblNewClientLastName.setBounds(60,100,120,30);
        createPanel.add(lblNewClientLastName);
        lblNewClientLastName.setEnabled(false);

        txtNewClientLastName = new JTextField();
        txtNewClientLastName.setBounds(170,100,150,30);
        createPanel.add(txtNewClientLastName);
        txtNewClientLastName.setEnabled(false);

        lblNewClientPhoneNr = new JLabel("Phone No:");
        lblNewClientPhoneNr.setFont(new Font("Arial", Font.BOLD, 18));
        lblNewClientPhoneNr.setBounds(60,150,120,30);
        createPanel.add(lblNewClientPhoneNr);
        lblNewClientPhoneNr.setEnabled(false);

        txtNewClientPhoneNr = new JTextField();
        txtNewClientPhoneNr.setBounds(170,150,150,30);
        createPanel.add(txtNewClientPhoneNr);
        txtNewClientPhoneNr.setEnabled(false);

        lblNewClientSSN = new JLabel("SSN:");
        lblNewClientSSN.setFont(new Font("Arial", Font.BOLD, 18));
        lblNewClientSSN.setBounds(60,200,120,30);
        createPanel.add(lblNewClientSSN);
        lblNewClientSSN.setEnabled(false);

        txtNewClientSSN = new JTextField();
        txtNewClientSSN.setBounds(170,200,150,30);
        createPanel.add(txtNewClientSSN);
        txtNewClientSSN.setEnabled(false);

        lblNewClientAddress = new JLabel("Address:");
        lblNewClientAddress.setFont(new Font("Arial", Font.BOLD, 18));
        lblNewClientAddress.setBounds(60,250,120,30);
        createPanel.add(lblNewClientAddress);
        lblNewClientAddress.setEnabled(false);

        txtNewClientAddress = new JTextField();
        txtNewClientAddress.setBounds(170,250,150,30);
        createPanel.add(txtNewClientAddress);
        txtNewClientAddress.setEnabled(false);

        lblNewClientEmail = new JLabel("Email:");
        lblNewClientEmail.setFont(new Font("Arial", Font.BOLD, 18));
        lblNewClientEmail.setBounds(60,300,120,30);
        createPanel.add(lblNewClientEmail);
        lblNewClientEmail.setEnabled(false);

        txtNewClientEmail = new JTextField();
        txtNewClientEmail.setBounds(170,300,150,30);
        createPanel.add(txtNewClientEmail);
        txtNewClientEmail.setEnabled(false);

        btnCreateClient = new JButton("Create Client");
        btnCreateClient.setBounds(210,350,110,30);
        createPanel.add(btnCreateClient);
        btnCreateClient.addActionListener(this);
        btnCreateClient.setEnabled(false);

    }


    public void enable(JTextField txt1,JTextField txt2,JTextField txt3){
        txt1.setEnabled(true);
        txt1.setBackground(null);
        txt2.setEnabled(true);
        txt2.setBackground(null);
        txt3.setEnabled(true);
        txt3.setBackground(null);
    }

    public void disable(JTextField txt1,JTextField txt2,JTextField txt3){
        txt1.setEnabled(false);
        txt1.setBackground(Color.LIGHT_GRAY);
        txt2.setEnabled(false);
        txt2.setBackground(Color.LIGHT_GRAY);
        txt3.setEnabled(false);
        txt3.setBackground(Color.LIGHT_GRAY);
    }

    public void paint(Graphics g) {
        super.paint(g);
        int x = 400; // X-coordinate of the line
        int y1 = 0; // Y-coordinate of the starting point
        int y2 = 450; // Y-coordinate of the ending point
        g.drawLine(x, y1, x, y2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == switchForms) {
            if (switchForms.isSelected()) {
                switchForms.setText("Search Client");
                for (Component component : searchPannel.getComponents()) {
                    component.setEnabled(false);
                    for (Component component2 : createPanel.getComponents()) {
                        component2.setEnabled(true);
                    }
                }
            } else {
                switchForms.setText("Create Client");
                for (Component component : searchPannel.getComponents()) {
                    component.setEnabled(true);
                }
                for (Component component2 : createPanel.getComponents()) {
                    component2.setEnabled(false);
                }
            }
        }
    }
}
