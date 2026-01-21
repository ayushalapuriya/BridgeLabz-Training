package bank_account_hierarchy;

abstract class BankAccount {
    private final String accountNumber;
    private final double balance;
    abstract double calculateFee();

    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    protected double getBalance() {
        return balance;
    }
}
