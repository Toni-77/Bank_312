import java.time.LocalDate;


public class Bank_312_Transaction {
    private String accountNo;
    private String transactionType;
    private int serialNo;
    private LocalDate date;


    public String getTransactionType() {
        return transactionType;
    }


    public Double getAmount() {
        return amount;
    }


    public String getAccountNo() {
        return accountNo;
    }


    public int getSerialNo() {
        return serialNo;
    }


    public LocalDate getDate() {
        return date;
    }


    private Double amount;
    public Bank_312_Transaction(String accountNo, String transactionType, Double amount){
        this.accountNo = accountNo;
        serialNo = Bank_312_TransactionsDB.getCurrentSerialNo();
        this.transactionType = transactionType;
        this.amount = amount;
        date = LocalDate.now();
    }
    @Override
    public String toString(){
        return (serialNo + ", " + accountNo + ", " + transactionType + ", " + amount + ", " + date);
    }
}

