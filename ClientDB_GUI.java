import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class ClientDB_GUI extends JFrame implements ActionListener {


    private ArrayList<Client> currentClientsDB;
    Transaction_Gui transactionFrame;
    private JPanel showClients;
    private JTable clientTable;


    private JLabel lblShowClients;


    public ClientDB_GUI(ArrayList<Client> clients){
        setLayout(null);
        setTitle("Client Interaction Frame");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null);


        showClients = new JPanel();
        showClients.setBounds(0,200,800,300);
        showClients.setLayout(null);
        add(showClients);


        lblShowClients = new JLabel("List of Clients and their accounts:");
        lblShowClients.setFont(new Font("Arial", Font.BOLD, 18));
        lblShowClients.setBounds(260,5,320,30);
        showClients.add(lblShowClients);


        String [] columnNames = {"First Name", "Last Name", "Phone Nr", "SSN", "Email", "Address"};
        //Client client;
        //ClientDB.populateDB();
        //client = clients.getFirst();
        //Object[] data = {client.getFirstName(), client.getLastName(),client.getPhoneNr(),client.getSSN(),client.getEmail(),client.getAddress()};


        //ArrayList<Client> clients = ClientDB.getClientDB();
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        ClientDB_GUI currentGui = this;
        //model.addRow(data);
        model.setRowCount(0);
        for(int i = 0; i < clients.size();i++) {
            Object [] obj = {clients.get(i).getFirstName(), clients.get(i).getLastName(),clients.get(i).getPhoneNr(),clients.get(i).getSSN(),clients.get(i).getEmail(),clients.get(i).getAddress()};
            model.addRow(obj);
        }
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
                    transactionFrame = new Transaction_Gui(currentGui, clients.get(row));
                    System.out.println(clients.get(row).getInfo());
                    //Transaction_Gui.setCurrentClient(clients.get(row));
                    transactionFrame.setVisible(true);


                   /*JOptionPane.showMessageDialog(ClientDBGui.this,
                           "Clicked on row: " + row + "\nFirst Name: " + fName + ", Last Name: " + lName + ", Phone: " + phone);*/
                }
            }
        });


        // Embed the table in a scroll pane
        JScrollPane scrollPane = new JScrollPane(clientTable);
        scrollPane.setBounds(50,50,600,100);


        // Add the scroll pane to the frame
        showClients.add(scrollPane);


        //setVisible(true);


    }




    @Override
    public void actionPerformed(ActionEvent e) {


    }
}

