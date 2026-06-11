import java.util.Calendar;

public class BaseTransaction implements TransactionInterface {
    protected double amount;
    protected Calendar date;
    protected String transactionID;

    // Constructor
    public BaseTransaction(double amount, String transactionID) {
        this.amount = amount;
        this.date = Calendar.getInstance(); // Captures the current date/time
        this.transactionID = transactionID;
    }

    @Override
    public double getAmount() {
        return amount; // [cite: 25]
    }

    @Override
    public Calendar getDate() {
        return date; // [cite: 26]
    }

    @Override
    public String getTransactionID() {
        return transactionID; // [cite: 27]
    }

    public void printTransactionDetails() { // [cite: 29]
        System.out.println("Transaction ID: " + transactionID);
        System.out.println("Date: " + date.getTime());
        System.out.println("Amount: $" + amount);
    }

    public void apply(BankAccount ba) throws InsufficientFundsException { // [cite: 30]
        System.out.println("Base transaction applied. No changes made to balance.");
    }
}