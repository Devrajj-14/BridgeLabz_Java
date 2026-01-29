package staticFinalConcepts;

public class BankAccount {

    static String bankName = "NexBank";
    private static int totalAccounts = 0;

    private final long accountNumber;     // final: cannot change after constructor

    private String accountHolderName;
    private double balance;

    /*
     * Class: BankAccount
     * Purpose: Demonstrates static, this, final, instanceof in one program.
     */
    public BankAccount(String accountHolderName, long accountNumber, double balance) {
        this.accountHolderName = accountHolderName; // this: resolves ambiguity
        this.accountNumber = accountNumber;         // final assigned once
        this.balance = balance;

        totalAccounts++;
    }

    public static void getTotalAccounts() {
        System.out.println("Bank Name: " + bankName);
        System.out.println("Total Accounts: " + totalAccounts);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    public void displayDetails() {
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }

    public static void safeDisplay(Object obj) {
        if (obj instanceof BankAccount) { // instanceof check
            ((BankAccount) obj).displayDetails();
        } else {
            System.out.println("Not a BankAccount object.");
        }
    }

    public static void main(String[] args) {
        BankAccount a1 = new BankAccount("Devraj", 1001001L, 5000);
        BankAccount a2 = new BankAccount("Rahul", 1001002L, 12000);

        BankAccount.getTotalAccounts();

        a1.deposit(1500);
        a2.withdraw(2000);

        BankAccount.safeDisplay(a1);
        BankAccount.safeDisplay("hello"); // shows instanceof check working
    }
}
