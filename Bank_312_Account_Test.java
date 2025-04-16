import static org.junit.jupiter.api.Assertions.*;
class Bank_312_Account_Test {
    @org.junit.jupiter.api.Test
    void Bank_312_CheckingTestOne() {
        Bank_312_Account checking = new Bank_312_Checking(5000);
        assertEquals(5000, checking.getBalance());
        assertEquals("Checking", checking.getType());
        assertEquals(true, checking.deposit(100));
        assertEquals(5100, checking.getBalance());
        assertEquals(true, checking.withdraw(200));
        assertEquals(4900, checking.getBalance());
    }


    @org.junit.jupiter.api.Test
    void Bank_312_CheckingTestTwo() {
        Bank_312_Account checking = new Bank_312_Checking(2500);
        assertNotEquals(2600, checking.getBalance());
        assertNotEquals("Savings", checking.getType());
        assertEquals(false, checking.deposit(0));
        assertEquals(false, checking.deposit(-1));
        assertEquals(false, checking.withdraw(0));
        assertEquals(false, checking.withdraw(-1));
        assertEquals(false, checking.withdraw(2501));// balance is 2500
    }
}






