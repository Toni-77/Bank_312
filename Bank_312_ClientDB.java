import java.util.ArrayList;
import java.util.Iterator;


public class Bank_312_ClientDB {
    private static ArrayList<Bank_312_Client> clientsDB = new ArrayList<>();


    private static ArrayList<Bank_312_Client> searchedBank312Clients = new ArrayList<>();


    //private JFrame clientGui = new ClientDBGui();


    public static boolean addClient(Bank_312_Client newBank312Client){
       /*for (Client existingClient: clientDB){
           if(existingClient.getSSN().equals(newClient.getSSN()))
               JOptionPane.showMessageDialog(clientGui, "Duplicate SSN!",
                       "SSN Checker", JOptionPane.ERROR_MESSAGE);
       return false;
       }*/
        clientsDB.add(newBank312Client);
        return true;
    }


    public static ArrayList<Bank_312_Client> getClientDB(){
        return clientsDB;
    }


    public static ArrayList<Bank_312_Client> getSearchedClients(){return searchedBank312Clients;}


    public static void populateDB(){
        Bank_312_Client t = new Bank_312_Client("Toni","Dede","4142417481", "342223456","toni@gmail.com", "123 Main st");
        t.addAccount(new Bank_312_Checking(5000));
        t.addAccount(new Bank_312_Savings(4000.0));
        clientsDB.add(t);
        Bank_312_Client l = new Bank_312_Client("Greta", "Coleman", "4145467890","234567890","cole@gmail.com","340 Green st");
        l.addAccount(new Bank_312_Checking( 10000));
        clientsDB.add(l);
        Bank_312_Client a = new Bank_312_Client("Sabrina", "Trejo", "8473245678","234556789","trejo@gmail.com","14 E Lincoln st");
        a.addAccount(new Bank_312_Savings(4500.0));
        clientsDB.add(a);
        Bank_312_Client b = new Bank_312_Client("Andy", "Lawson", "847376766","234575785","Andy@gmail.com","10 W Pratt st");
        b.addAccount(new Bank_312_Savings(9800.0));
        clientsDB.add(b);
        Bank_312_Client c = new Bank_312_Client("Mike", "Ding", "847455656","235679785","ding@gmail.com","29 N Ridge blvd");
        c.addAccount(new Bank_312_Savings(15000.0));
        clientsDB.add(c);


    }


    public static void populateDB(ArrayList <Bank_312_Client> bank312Clients){
        searchedBank312Clients = bank312Clients;
    }


    public static ArrayList <Bank_312_Client> findByFullName(String firstName, String lastName){
        Iterator <Bank_312_Client>iterator = clientsDB.iterator();
        ArrayList<Bank_312_Client> bank312Clients = new ArrayList<>();
        while(iterator.hasNext()) {
            Bank_312_Client bank312Client = iterator.next();
            if (bank312Client.getFirstName().equalsIgnoreCase(firstName) && bank312Client.getLastName().equalsIgnoreCase(lastName)) { // Client found, return object
                bank312Clients.add(bank312Client);
            }
        }
        return bank312Clients;


    }


    public static ArrayList<Bank_312_Client> findBySSN(String ssn){
        Iterator <Bank_312_Client>iterator = clientsDB.iterator();
        ArrayList<Bank_312_Client> bank312Clients = new ArrayList<>();
        while(iterator.hasNext()) {
            Bank_312_Client bank312Client = iterator.next();
            if (bank312Client.getSSN().equals(ssn) ) { // Client found, return object
                bank312Clients.add(bank312Client);
                return bank312Clients;
            }
        }
        return bank312Clients;
    }
    //allows more than one client per phone number
    public static ArrayList<Bank_312_Client> findByPhone(String phone){
        Iterator <Bank_312_Client>iterator = clientsDB.iterator();
        ArrayList<Bank_312_Client> bank312Clients = new ArrayList<>();
        while(iterator.hasNext()) {
            Bank_312_Client bank312Client = iterator.next();
            if (bank312Client.getPhoneNr().equals(phone) ) { // Client found, return object
                bank312Clients.add(bank312Client);
            }
        }
        return bank312Clients;
    }


    public static ArrayList<Bank_312_Client> findByEmail(String email){
        Iterator <Bank_312_Client>iterator = clientsDB.iterator();
        ArrayList<Bank_312_Client> bank312Clients = new ArrayList<>();
        while(iterator.hasNext()) {
            Bank_312_Client bank312Client = iterator.next();
            if (bank312Client.getEmail().equals(email) ) { // Client found, return object
                bank312Clients.add(bank312Client);
                return bank312Clients;
            }
        }
        return bank312Clients;
    }
}

