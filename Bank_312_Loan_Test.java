import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class Bank_312_Loan_Test {

    @Test
    void Bank_312_Loan_Test_One() {
        Bank_312_Loan loan = new Bank_312_CC(5000.0);
        assertEquals(5000,loan.getLoanAccountLimit());
        assertEquals("Credit Card",loan.getType());
        assertTrue(loan.payment(100));
        assertEquals(4900,loan.getRemainingBalance());
        assertTrue(loan.payment(200));
        assertEquals(4700,loan.getRemainingBalance());
    }

    @Test
    void Bank_312_Loan_Test_Two() {
        Bank_312_Loan loan = new Bank_312_Car_Loan(15000.0);
        assertEquals(15000,loan.getLoanAccountLimit());
        assertEquals("Car Loan",loan.getType());
        assertTrue(loan.payment(500));
        assertEquals(14500,loan.getRemainingBalance());
        assertFalse(loan.payment(0));
        assertFalse(loan.payment(-1));
        assertTrue(loan.payment(14500));
        assertEquals(0,loan.getRemainingBalance());
    }
}

