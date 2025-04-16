import java.util.ArrayList;
import java.util.Iterator;
// This class serves as a database for clients
// including finding

public class Bank_312_ClientDB {
    private static ArrayList<Bank_312_Client> clientsDB = new ArrayList<>();
    private static ArrayList<Bank_312_Client> searchedBank312Clients = new ArrayList<>();

    // Method to add a new client to the List of clients
    // only if the SSN is not already in use by a different client
    public static boolean addClient(Bank_312_Client newBank312Client){
        for (Bank_312_Client existingClient: Bank_312_ClientDB.getClientDB()){
            if(existingClient.getSSN().equals(newBank312Client.getSSN()))
                return false;
        }
        clientsDB.add(newBank312Client);
        return true;
    }

    // method to return an Arraylist of all clients
    public static ArrayList<Bank_312_Client> getClientDB(){
        return clientsDB;
    }

    // Method returns a ArrayList of searchedClients to be passed on the ClientDB_GUI JFrame
    public static ArrayList<Bank_312_Client> getSearchedClients(){return searchedBank312Clients;}

    // Populates the database with some existing clients
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

    // Method overloaded to create a list after the search for a client
    public static void populateDB(ArrayList <Bank_312_Client> bank312Clients){
        searchedBank312Clients = bank312Clients;
    }

    // Method to find the client by the full name
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

    // Method to find client by social security number
    // Doesn't allow more than one client per SSN
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

    // Method to find client by phone number
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

    // Method to find client by email
    // not used in this project
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



