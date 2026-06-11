public class Main {
    public static void main(String[] args) {
        System.out.println("========== STARTING TRANSACTION SYSTEM TESTS ==========");

        // 1. Setup Bank Account
        BankAccount account = new BankAccount(500.0);
        System.out.println("Initial Balance: $" + account.getBalance());

        // 2. Test DepositTransaction
        System.out.println("\n--- 1. Testing Standard Deposit ---");
        DepositTransaction deposit = new DepositTransaction(200.0, "TXN-DEP-001");
        deposit.printTransactionDetails();
        try {
            deposit.apply(account);
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // 3. Test Standard Withdrawal (Success)
        System.out.println("\n--- 2. Testing Standard Withdrawal ---");
        WithdrawalTransaction withdrawal1 = new WithdrawalTransaction(100.0, "TXN-WIT-001");
        withdrawal1.printTransactionDetails();
        try {
            withdrawal1.apply(account);
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // 4. Test Reversal (From Phase 2)
        System.out.println("\n--- 3. Testing Transaction Reversal ---");
        withdrawal1.reverse();

        // 5. Test Exception Handling (From Phase 3)
        System.out.println("\n--- 4. Testing Insufficient Funds Exception ---");
        WithdrawalTransaction withdrawal2 = new WithdrawalTransaction(1000.0, "TXN-WIT-002");
        try {
            withdrawal2.apply(account);
        } catch (InsufficientFundsException e) {
            System.out.println("EXPECTED EXCEPTION CAUGHT: " + e.getMessage());
        }

        // 6. Test Partial Withdrawal (From Phase 3 Overloaded Method)
        System.out.println("\n--- 5. Testing Partial Withdrawal ---");
        WithdrawalTransaction withdrawal3 = new WithdrawalTransaction(800.0, "TXN-WIT-003");
        withdrawal3.apply(account, true); 

        // 7. Test Polymorphism & Type Casting (Crucial Q4 Requirement)
        System.out.println("\n--- 6. Testing Polymorphism & Type Casting ---");
        // Creating a subtype object (DepositTransaction) but referencing it as the Base type
        BaseTransaction polyTransaction = new DepositTransaction(50.0, "TXN-POLY-001");
        polyTransaction.printTransactionDetails();
        
        try {
            // Because of late binding (polymorphism), this will run the DepositTransaction's apply() 
            // method, NOT the BaseTransaction's generic apply() method.
            polyTransaction.apply(account); 
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n========== TESTS COMPLETED ==========");
    }
}