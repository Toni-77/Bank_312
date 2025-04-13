import java.util.Iterator;


public class Bank_312_Input_Validation {
    public static Boolean isNameValid(String name){
        if (name == null || name.isEmpty()) {
            return false; // Empty name is invalid
        }
        if (name.contains("  ")) {
            return false; // Multiple spaces in name
        }
        return name.matches("^[a-zA-Z\\s-]+$"); // Invalid characters in name
    }


    public static Boolean isSsnValid(String ssn){
        if (ssn == null || ssn.isEmpty()) {
            return false; // Empty textbox
        }


        if (ssn.length() != 9) {
            System.out.println("Not 9 digits");
            return false; // Not 9 digits
        }


        for (int i = 0; i < ssn.length(); i++) {
            if (!Character.isDigit(ssn.charAt(i))) {
                System.out.println("Not numbers");
                return false; // Contains non-digit character
            }
        }


        return true; // It's a 9-digit number
    }


    public static Boolean isPhoneValid(String phone){
        if (phone == null || phone.isEmpty()) {
            return false; // Empty textbox
        }


        if (phone.length() != 10) {
            System.out.println("Not 9 digits");
            return false; // Not 9 digits
        }


        for (int i = 0; i <  phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                System.out.println("Not numbers");
                return false; // Contains non-digit character
            }
        }


        return true; // It's a 9-digit number
    }


    public static boolean isSsnUnique(String ssn){
        Iterator<Bank_312_Client> iterator = Bank_312_ClientDB.getClientDB().iterator();
        while(iterator.hasNext()) {
            Bank_312_Client bank312Client = iterator.next();
            if (bank312Client.getSSN().equals(ssn)) { // Client found, return object
                return false;
            }
        }
        return true;
    }
}

