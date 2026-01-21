package bank_account_hierarchy;

public class CheckingAccount extends BankAccount {

    CheckingAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    public double calculateFee() {
        return getBalance() < 1000 ? 1.0 : 0.0;
    }
}
