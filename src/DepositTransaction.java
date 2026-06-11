public class DepositTransaction extends BaseTransaction {

    public DepositTransaction(double amount, String transactionID) {
        super(amount, transactionID);
    }

    @Override
    public void apply(BankAccount ba) throws InsufficientFundsException { // 
        ba.deposit(amount);
        System.out.println("Deposit of $" + amount + " applied. New balance: $" + ba.getBalance());
    }
}