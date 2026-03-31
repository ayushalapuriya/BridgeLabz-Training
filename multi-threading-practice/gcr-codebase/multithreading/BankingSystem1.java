import java.time.LocalTime;

class BankAccount1 {
    int balance = 10000;

    // NOT synchronized (intentionally)
    public void withdraw(String customer, int amount) {
        System.out.println("[" + customer + "] Attempting to withdraw " + amount);
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Transaction successful: " + customer +
                    ", Amount: " + amount +
                    ", Balance: " + balance +
                    ", Time: " + LocalTime.now());
        } else {
            System.out.println("Transaction failed: " + customer +
                    ", Insufficient balance, Time: " + LocalTime.now());
        }
    }
}

class Transaction implements Runnable {
    private BankAccount1 account;
    private int amount;
    private String customer;

    Transaction(BankAccount1 account, String customer, int amount) {
        this.account = account;
        this.amount = amount;
        this.customer = customer;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() +
                " state before run: " + Thread.currentThread().getState());
        account.withdraw(customer, amount);
    }
}

public class BankingSystem1 {
    public static void main(String[] args) {

        BankAccount1 account = new BankAccount1();

        Thread t1 = new Thread(new Transaction(account, "Customer-1", 3000));
        Thread t2 = new Thread(new Transaction(account, "Customer-2", 4000));
        Thread t3 = new Thread(new Transaction(account, "Customer-3", 2000));
        Thread t4 = new Thread(new Transaction(account, "Customer-4", 5000));
        Thread t5 = new Thread(new Transaction(account, "Customer-5", 1500));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
