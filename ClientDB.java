import java.util.ArrayList;
import java.util.Iterator;


public class ClientDB {
    private static ArrayList<Client> clientsDB = new ArrayList<>();


    private static ArrayList<Client> searchedClients = new ArrayList<>();


    //private JFrame clientGui = new ClientDBGui();
    public ClientDB(){




       /*clientDB.add();
       clientDB.add();
       clientDB.add();
       clientDB.add();
       clientDB.add();
       clientDB.add();
       clientDB.add();
       clientDB.add();
       clientDB.add();*/
    }


    public static boolean addClient(Client newClient){
       /*for (Client existingClient: clientDB){
           if(existingClient.getSSN().equals(newClient.getSSN()))
               JOptionPane.showMessageDialog(clientGui, "Duplicate SSN!",
                       "SSN Checker", JOptionPane.ERROR_MESSAGE);
       return false;
       }*/
        clientsDB.add(newClient);
        return true;
    }


    public static ArrayList<Client> getClientDB(){
        return clientsDB;
    }


    public static ArrayList<Client> getSearchedClients(){return searchedClients;}


    public static void populateDB(){
        Client t = new Client("Toni","Dede","4142417481", "342223456","toni@gmail.com", "123 Main st");
        t.addAccount(new Bank_312_Checking(5000));
        t.addAccount(new Bank_312_Savings(4000.0));
        clientsDB.add(t);
        Client l = new Client("Greta", "Coleman", "4145467890","234567890","cole@gmail.com","340 Green st");
        l.addAccount(new Bank_312_Checking( 10000));
        clientsDB.add(l);
        Client a = new Client("Sabrina", "Trejo", "8473245678","234556789","trejo@gmail.com","14 E Lincoln st");
        a.addAccount(new Bank_312_Savings(4500.0));
        clientsDB.add(a);
        Client b = new Client("Andy", "Lawson", "847376766","234575785","Andy@gmail.com","10 W Pratt st");
        b.addAccount(new Bank_312_Savings(9800.0));
        clientsDB.add(b);
        Client c = new Client("Mike", "Ding", "847455656","235679785","ding@gmail.com","29 N Ridge blvd");
        c.addAccount(new Bank_312_Savings(15000.0));
        clientsDB.add(c);


    }


    public static void populateDB(ArrayList <Client> clients){
        searchedClients = clients;
    }


    public static ArrayList <Client> findByFullName(String firstName){
        Iterator <Client>iterator = clientsDB.iterator();
        ArrayList<Client> clients = new ArrayList<>();
        while(iterator.hasNext()) {
            Client client = iterator.next();
            if (client.getFirstName().equals(firstName)) { // Client found, return object
                clients.add(client);
            }
        }
        return clients;
        //return null;
    }
}


