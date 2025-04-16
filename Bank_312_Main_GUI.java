import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// This JFame has a form that will search for existing clients using
// 1)first name and last name or
// 2)phone number only or
// 3)social security number only

// And another form that will  create a new Client using
// 1) First and last name    - mandatory not unique
// 2) Phone number           - mandatory not unique
// 3) social security number - mandatory unique

public class Bank_312_Main_GUI extends JFrame implements ActionListener {
    private ArrayList <Bank_312_Client> clientsFound; // list of clients returned from the search for a client
    private Bank_312_ClientDB_GUI clientDBGui; // the GUI frame that displays the find/search clients table
    Bank_312_Transaction_GUI clientForm; // this frame was intended to show all bank transactions
    private JPanel searchPannel;
    private JPanel createPanel;
    private JLabel lblclientSearch;
    private JLabel lblNewClient;
    private JTextField txtFirstName;
    private JTextField txtLastName;
    private JTextField txtPhone;
    private JLabel lblFirstName;
    //private JPanel mainPanel;
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

    public Bank_312_Main_GUI(){
        // Create JFrame and set the size and location
        setLayout(null);
        setTitle("312 Bank");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null);

        // Left side of the frame will contain existing client search info
        searchPannel = new JPanel();
        searchPannel.setBounds(0,0,400,300);
        searchPannel.setLayout(null);
        add(searchPannel);

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

        // the text boxes will get able/disabled if they have text typed on them
        txtFirstName.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                disable(txtPhone,txtSSN);
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                if (txtFirstName.getText().isEmpty() && txtLastName.getText().isEmpty()) {
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
                disable(txtPhone,txtSSN);
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                if (txtLastName.getText().isEmpty() && txtFirstName.getText().isEmpty()) {
                    enable(txtPhone,txtSSN);
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

        // button that will show the find client if clicked
        btnSearch = new JButton("Search");
        btnSearch.setBounds(220,250,90,30);
        searchPannel.add(btnSearch);
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // This code will be executed when the button is clicked
                // It will search by (first name + last name, phone no, or SSN)
                if (!txtFirstName.getText().isEmpty() || !txtLastName.getText().isEmpty()) {
                    String firstName = txtFirstName.getText();
                    String lastName = txtLastName.getText();
                    if(Bank_312_Input_Validation.isNameValid(firstName) && Bank_312_Input_Validation.isNameValid(lastName)){
                        if(Bank_312_ClientDB.findByFullName(firstName, lastName).isEmpty()){
                            JOptionPane.showMessageDialog(null, "Client not found! Try again!", "Bank 312", JOptionPane.INFORMATION_MESSAGE);
                        }else{
                            clientsFound = Bank_312_ClientDB.findByFullName(firstName,lastName);
                            Bank_312_ClientDB.populateDB(clientsFound);
                            clientDBGui = new Bank_312_ClientDB_GUI(Bank_312_ClientDB.getSearchedClients());
                            clientDBGui.setVisible(true);
                            setVisible(false);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null,"Enter a valid full name", "Bank 312",JOptionPane.INFORMATION_MESSAGE);
                    }
                } else if (!txtPhone.getText().isEmpty()) {
                    String phone = txtPhone.getText();
                    if(Bank_312_Input_Validation.isPhoneValid(phone)){
                        if(Bank_312_ClientDB.findByPhone(phone).isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Client not found! Try again!", "Bank 312", JOptionPane.INFORMATION_MESSAGE);
                        }  else{
                            clientsFound = Bank_312_ClientDB.findByPhone(phone);
                            Bank_312_ClientDB.populateDB(clientsFound);
                            clientDBGui = new Bank_312_ClientDB_GUI(Bank_312_ClientDB.getSearchedClients());
                            clientDBGui.setVisible(true);
                            setVisible(false);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null,"Enter a valid phone number", "Bank 312",JOptionPane.INFORMATION_MESSAGE);
                    }
                } else if (!txtSSN.getText().isEmpty()) {
                    String ssn = txtSSN.getText();
                    if(Bank_312_Input_Validation.isSsnValid(ssn)){
                        if(Bank_312_ClientDB.findBySSN(ssn).isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Client not found! Try again!", "Bank 312", JOptionPane.INFORMATION_MESSAGE);
                        }  else{
                            clientsFound = Bank_312_ClientDB.findBySSN(ssn);
                            Bank_312_ClientDB.populateDB(clientsFound);
                            clientDBGui = new Bank_312_ClientDB_GUI(Bank_312_ClientDB.getSearchedClients());
                            clientDBGui.setVisible(true);
                            setVisible(false);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null,"Enter a valid SSN", "Bank 312",JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                clearTxtFields();
            }
        });

        // this button will enable/disable between search and create panels(info forms)
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

        // This button will create a new client only if the SSN is not already in use
        // all text box information will be checked for entering information in correct format
        btnCreateClient = new JButton("Create Client");
        btnCreateClient.setBounds(210,350,110,30);
        createPanel.add(btnCreateClient);
        btnCreateClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // This code will be executed when the button is clicked
                if(!Bank_312_Input_Validation.isNameValid(txtNewClientFirstName.getText()) || !Bank_312_Input_Validation.isNameValid(txtNewClientLastName.getText())){
                    JOptionPane.showMessageDialog(null,"Enter a valid Name", "Bank 312",JOptionPane.INFORMATION_MESSAGE);
                    txtNewClientFirstName.setText(null);
                }else if (!Bank_312_Input_Validation.isPhoneValid(txtNewClientPhoneNr.getText())) {
                    JOptionPane.showMessageDialog(null,"Enter a valid Phone Number", "Bank 312",JOptionPane.INFORMATION_MESSAGE);
                    txtNewClientPhoneNr.setText(null);
                }else if (!Bank_312_Input_Validation.isSsnValid(txtNewClientSSN.getText()) || !Bank_312_Input_Validation.isSsnUnique(txtNewClientSSN.getText())) {
                    JOptionPane.showMessageDialog(null, "Enter a valid/unique SSN", "Bank 312", JOptionPane.INFORMATION_MESSAGE);
                    txtNewClientSSN.setText(null);
                }else {
                    Bank_312_Client client = new Bank_312_Client(txtNewClientFirstName.getText(),txtNewClientLastName.getText(),txtNewClientPhoneNr.getText(),txtNewClientSSN.getText(),txtNewClientEmail.getText(),txtNewClientAddress.getText());
                    Bank_312_ClientDB.addClient(client);
                    clientDBGui = new Bank_312_ClientDB_GUI(Bank_312_ClientDB.getClientDB());
                    clientDBGui.setVisible(true);
                    setVisible(false);
                    clearTxtFields();
                }
            }
        });
        btnCreateClient.setEnabled(false);
    }

    // This method will clear all text fields previous text (if any)
    private void clearTxtFields(){
        txtFirstName.setText(null);
        txtLastName.setText(null);
        txtPhone.setText(null);
        txtSSN.setText(null);
        txtNewClientFirstName.setText(null);
        txtNewClientLastName.setText(null);
        txtNewClientPhoneNr.setText(null);
        txtNewClientSSN.setText(null);
        txtNewClientEmail.setText(null);
        txtNewClientAddress.setText(null);
    }

    // This method will enable text boxes on either Search or Create
    private void enable(JTextField... txtFields){
        for(JTextField txtField:txtFields){
            txtField.setEnabled(true);
            txtField.setBackground(Color.WHITE);
        }
    }

    // This method will disable text boxes on either Search or Create
    private void disable(JTextField... txtFields){
        for(JTextField txtField:txtFields){
            txtField.setEnabled(false);
            txtField.setBackground(Color.LIGHT_GRAY);
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        int x = 400; // X-coordinate of the line
        int y1 = 0; // Y-coordinate of the starting point
        int y2 = 450; // Y-coordinate of the ending point
        g.drawLine(x, y1, x, y2);
    }

    // this method will listen for button Switch to enable/disable panels
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
                    clearTxtFields();
                }
            } else {
                switchForms.setText("Create Client");
                for (Component component : searchPannel.getComponents()) {
                    component.setEnabled(true);
                }
                for (Component component2 : createPanel.getComponents()) {
                    component2.setEnabled(false);
                }
                clearTxtFields();
            }
        }
    }
}







