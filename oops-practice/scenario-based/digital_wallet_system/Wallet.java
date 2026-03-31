package digital_wallet_system;

import java.util.ArrayList;
import java.util.List;

class Wallet {
    private User user;
    private double balance;
    private List<Transaction> transactions;

    Wallet(User user) {
        this.user = user;
        this.balance = 0;
        this.transactions = new ArrayList<>();
    }

    double getBalance() {
        return balance;
    }

    void addMoney(double amount) {
        balance += amount;
        transactions.add(new Transaction("ADD", amount));
        System.out.println(amount + " added to wallet");
    }

    void withdrawMoney(double amount) throws InsufficientBalanceException {
        if (balance < amount) {
            throw new InsufficientBalanceException("Insufficient balance");
        }
        balance -= amount;
        transactions.add(new Transaction("WITHDRAW", amount));
        System.out.println(amount + " withdrawn from wallet");
    }

    void transfer(double amount, Wallet receiver, TransferService service)
            throws InsufficientBalanceException {

        service.transfer(this, receiver, amount);
    }

    void recordTransaction(String type, double amount) {
        transactions.add(new Transaction(type, amount));
    }

    void displayTransactions() {
        System.out.println("\nTransaction History:");
        for (Transaction t : transactions) {
            t.display();
        }
        System.out.println("Current Balance: " + balance);
    }
}
