import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
// JFrame class to display the clients in a JTable

public class Bank_312_ClientDB_GUI extends JFrame  {

    Bank_312_Transaction_GUI transactionFrame;
    private JPanel showClients;
    private JTable clientTable;
    private JLabel lblShowClients;

    // Class Constructor
    public Bank_312_ClientDB_GUI(ArrayList<Bank_312_Client> bank312Clients){
        setLayout(null);
        setTitle("Client Interaction Frame");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null);
        // The listener doesn't close the application on close
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
            }
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                Bank_312_Welcome_GUI.getSearchCreate().setVisible(true);
            }
            @Override
            public void windowClosed(WindowEvent e) {
            }
            @Override
            public void windowIconified(WindowEvent e) {
            }
            @Override
            public void windowDeiconified(WindowEvent e) {
            }
            @Override
            public void windowActivated(WindowEvent e) {
            }
            @Override
            public void windowDeactivated(WindowEvent e) {
            }
        });


        showClients = new JPanel();
        showClients.setBounds(0,200,800,300);
        showClients.setLayout(null);
        add(showClients);


        lblShowClients = new JLabel("List of Clients and their accounts:");
        lblShowClients.setFont(new Font("Arial", Font.BOLD, 18));
        lblShowClients.setBounds(260,5,320,30);
        showClients.add(lblShowClients);

        // creates a table model with column headers
        String [] columnNames = {"First Name", "Last Name", "Phone Nr", "SSN", "Email", "Address"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        Bank_312_ClientDB_GUI currentGui = this;

        // adds clients on the rows of the model
        model.setRowCount(0);
        for(int i = 0; i < bank312Clients.size(); i++) {
            Object [] obj = {bank312Clients.get(i).getFirstName(), bank312Clients.get(i).getLastName(), bank312Clients.get(i).getPhoneNr(), bank312Clients.get(i).getSSN(), bank312Clients.get(i).getEmail(), bank312Clients.get(i).getAddress()};
            model.addRow(obj);
        }

        // creates a table with a listener for user click on rows
        clientTable = new JTable(model);
        clientTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                JTable target = (JTable) e.getSource();
                int row = target.rowAtPoint(e.getPoint());
                if (row != -1) {
                    // Handle row click event
                    String fName = (String) clientTable.getValueAt(row, 0);
                    String lName = (String) clientTable.getValueAt(row, 1);
                    String phone = (String) clientTable.getValueAt(row, 2);
                    String SSN = (String) clientTable.getValueAt(row, 3);
                    String email = (String) clientTable.getValueAt(row, 4);
                    String address = (String) clientTable.getValueAt(row, 5);
                    transactionFrame = new Bank_312_Transaction_GUI(currentGui, bank312Clients.get(row));
                    System.out.println(bank312Clients.get(row));
                    //Transaction_Gui.setCurrentClient(clients.get(row));
                    transactionFrame.setVisible(true);
                }
            }
        });


        // Embed the table in a scroll pane
        JScrollPane scrollPane = new JScrollPane(clientTable);
        scrollPane.setBounds(50,50,600,100);


        // Add the scroll pane to the frame
        showClients.add(scrollPane);
    }
}

