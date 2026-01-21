package bank_account_hierarchy;

public class SavingsAccount extends BankAccount {

    SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    public double calculateFee() {
        return (0.5 * getBalance()) / 100;
    }
}
