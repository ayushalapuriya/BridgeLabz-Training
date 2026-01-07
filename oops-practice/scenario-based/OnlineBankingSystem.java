import java.util.*;

// Exception jab account me balance kam ho
class InsufficientBalanceException extends Exception {
    InsufficientBalanceException(String msg) {
        super(msg);
    }
}

// Base account class
abstract class Account {

    int accountNumber;
    String accountHolderName;
    double balance;

    // Account constructor
    Account(int accNo, String name, double bal) {
        accountNumber = accNo;
        accountHolderName = name;
        balance = bal;
    }

    // Deposit money (thread safe)
    synchronized void deposit(double amount) {
        balance += amount;
        System.out.println(amount + " deposited in " + accountNumber);
    }

    // Withdraw money
    synchronized void withdraw(double amount)
            throws InsufficientBalanceException {

        if (balance < amount) {
            throw new InsufficientBalanceException(
                    "Not enough balance in account " + accountNumber);
        }
        balance -= amount;
        System.out.println(amount + " withdrawn from " + accountNumber);
    }

    double getBalance() {
        return balance;
    }

    // Interest calculation (different for each account)
    abstract double calculateInterest();
}

// Savings account
class SavingsAccount extends Account {

    SavingsAccount(int accNo, String name, double bal) {
        super(accNo, name, bal);
    }

    // Savings account interest
    public double calculateInterest() {
        return balance * 0.04;
    }
}

// Current account
class CurrentAccount extends Account {

    CurrentAccount(int accNo, String name, double bal) {
        super(accNo, name, bal);
    }

    // No interest for current account
    public double calculateInterest() {
        return 0;
    }
}

// Bank services
interface BankService {

    void createAccount(Account acc);

    double checkBalance(int accNo);

    void transferFunds(int from, int to, double amount)
            throws InsufficientBalanceException;

    void showTransactionHistory();
}

// Implementation of bank services
class BankServiceImpl implements BankService {

    Map<Integer, Account> accounts = new HashMap<>();
    List<String> history = new ArrayList<>();

    // Add account
    public void createAccount(Account acc) {
        accounts.put(acc.accountNumber, acc);
        history.add("Account created: " + acc.accountNumber);
    }

    // Balance check
    public double checkBalance(int accNo) {
        return accounts.get(accNo).getBalance();
    }

    // Fund transfer
    public synchronized void transferFunds(int from, int to, double amount)
            throws InsufficientBalanceException {

        Account sender = accounts.get(from);
        Account receiver = accounts.get(to);

        sender.withdraw(amount);
        receiver.deposit(amount);

        history.add("Transfer " + amount + " from " + from + " to " + to);
    }

    // Show all transactions
    public void showTransactionHistory() {
        System.out.println("\nTransaction History:");
        for (String s : history) {
            System.out.println(s);
        }
    }
}

// Thread class for transaction
class TransactionThread extends Thread {

    BankService bank;
    int fromAcc, toAcc;
    double amount;

    TransactionThread(BankService bank, int from, int to, double amt) {
        this.bank = bank;
        fromAcc = from;
        toAcc = to;
        amount = amt;
    }

    public void run() {
        try {
            bank.transferFunds(fromAcc, toAcc, amount);
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }
}

// Main class
public class OnlineBankingSystem {

    public static void main(String[] args) {

        BankService bank = new BankServiceImpl();

        // Creating accounts
        Account a1 = new SavingsAccount(101, "Rahul", 5000);
        Account a2 = new CurrentAccount(102, "Amit", 3000);

        bank.createAccount(a1);
        bank.createAccount(a2);

        // Multiple transactions at same time
        Thread t1 = new TransactionThread(bank, 101, 102, 1000);
        Thread t2 = new TransactionThread(bank, 101, 102, 2000);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
            System.out.println(e);
        }

        // Final output
        System.out.println("\nBalance of 101: " + bank.checkBalance(101));
        System.out.println("Balance of 102: " + bank.checkBalance(102));

        bank.showTransactionHistory();
    }
}
