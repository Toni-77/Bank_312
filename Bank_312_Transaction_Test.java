import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class Bank_312_Transaction_Test {
    @Test
    void Bank_312_Transaction_Test() {
        Bank_312_Account checking = new Bank_312_Checking(2600);
        Bank_312_Loan CcLoan = new Bank_312_CC(5000.0);
        Bank_312_Savings savings = new Bank_312_Savings(3000.0);
        Bank_312_Transaction checkingTransaction = new Bank_312_Transaction(checking.getAccountNumber(), "Deposit", 500.0);
        Bank_312_Transaction loanTransaction = new Bank_312_Transaction(CcLoan.getLoanAccountNumber(), "Payment", 500.0);
        Bank_312_Transaction savingsTransaction = new Bank_312_Transaction(savings.getAccountNumber(), "Withdraw", 600.0);

        Bank_312_TransactionsDB.addTransaction(checkingTransaction);
        Bank_312_TransactionsDB.addTransaction(loanTransaction);
        Bank_312_TransactionsDB.addTransaction(savingsTransaction);

        ArrayList<Bank_312_Transaction> list = Bank_312_TransactionsDB.getTransactions();

        assertEquals(500, list.get(0).getAmount());
        assertEquals("Deposit", list.get(0).getTransactionType() );
        assertEquals(1, list.get(0).getSerialNo());

        assertEquals(600, list.get(2).getAmount());
        assertEquals("Withdraw", list.get(2).getTransactionType());
        assertEquals(3, list.get(2).getSerialNo());

        Bank_312_Loan mortgage = new Bank_312_Mortgage(5000.0);
        Bank_312_Transaction mortgageTransaction = new Bank_312_Transaction(mortgage.getLoanAccountNumber(), "Payment", 1500.0);

        list.add(mortgageTransaction);
        assertEquals(mortgage.getLoanAccountNumber(), list.get(3).getAccountNo());
        assertEquals("Payment", list.get(3).getTransactionType());

    }
}

