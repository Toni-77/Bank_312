import static org.junit.jupiter.api.Assertions.*;


class Bank_312_CreateClientAndAddAccountAndLoanTest {


    @org.junit.jupiter.api.Test
    void createClientTestOne() {
        Bank_312_Client a = new Bank_312_Client("Josh", "Martinez", "3123456789", "324567890", "josh@gmail.com", "34 N sheridan Chicago");
        assertEquals("Josh", a.getFirstName());
        assertEquals("Martinez", a.getLastName());
        assertEquals("3123456789", a.getPhoneNr());
        assertEquals("324567890", a.getSSN());
        assertEquals("josh@gmail.com", a.getEmail());
        assertEquals("34 N sheridan Chicago", a.getAddress());
    }


    @org.junit.jupiter.api.Test
    void createClientTestTwo() {
        Bank_312_Client b = new Bank_312_Client("josh", "Martinez", "3123456789", "324567890", "josh@gmail.com", "34 N sheridan Chicago");
        assertNotEquals("Josh", b.getFirstName());
        assertNotEquals("3122456789", b.getPhoneNr());
    }

    @org.junit.jupiter.api.Test
    void addAccountTest() {
        Bank_312_Client a = new Bank_312_Client("Josh", "Martinez", "3123456789", "324567890", "josh@gmail.com", "34 N sheridan Chicago");
        Bank_312_Account checkingA = new Bank_312_Checking(3400);
        a.addAccount(checkingA);
        assertEquals(3400, a.getAccounts().get(0).getBalance());
    }

    @org.junit.jupiter.api.Test
    void addLoanAccount() {
        Bank_312_Client a = new Bank_312_Client("John", "Doe", "3126543245", "908764325", "doe@yahoo.com", "44 N Grand Ave Chicago");
        Bank_312_Loan l = new Bank_312_CC(5000.00);
        a.addLoanAccount(l);
        assertEquals(5000, l.getLoanAccountLimit());
    }
}

